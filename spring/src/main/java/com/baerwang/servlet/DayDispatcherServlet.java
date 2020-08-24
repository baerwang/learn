package com.baerwang.servlet;

import com.baerwang.annotation.Autowired;
import com.baerwang.annotation.Controller;
import com.baerwang.annotation.RequestMapping;
import com.baerwang.annotation.Service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class DayDispatcherServlet extends HttpServlet {

    /**
     * web.xml param-name
     */
    private static final String LOCATION = "contextConfigLocation";

    /**
     * 保存配置信息
     */
    private Properties properties = new Properties();

    /**
     * 保存扫描到相关的类名
     */
    private List<String> classNames = new ArrayList<>();

    /**
     * ioc容器,保存初始化的bean
     */
    private Map<String, Object> ioc = new HashMap<>();

    /**
     * 保存url和方法映射关系
     */
    private Map<String, Method> handlerMapping = new HashMap<>();

    public DayDispatcherServlet() {
        super();
    }

    /**
     * 第一步：初始化
     * 当servlet容器启动时，会调用init方法，从init方法参数中，可以拿到主配置文件的路径，
     * 能读取到配置文件中的信息
     *
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        // 1 加载配置文件
        doLoadConfig(config.getInitParameter(LOCATION));

        // 2 扫描所有相关的类
        doScanner(properties.getProperty("scanPackage"));

        // 3 初始化所有相关类的实例，保存到 ioc 容器中
        doInstance();

        // 4 依赖注入
        doAutowired();

        // 5 构造handlerMapping
        initHandlerMapping();

        // 等待请求,匹配URL，反射调用执行

    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doLoadConfig(String location) {
        InputStream inputStream = null;
        try {
            inputStream = this.getClass().getClassLoader().getResourceAsStream(location);
            // 读配置文件
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void doScanner(String scanPackage) {
        // 将所有的包路径转换为文件路径
        URL resource = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        if (resource != null) {
            File file = new File(resource.getFile());
            for (File listFile : Objects.requireNonNull(file.listFiles())) {
                // 如果是文件夹，继续递归
                if (listFile.isDirectory()) {
                    doScanner(scanPackage + "." + listFile.getName());
                } else {
                    classNames.add(scanPackage + "." + listFile.getName().replace(".class", "").trim());
                }
            }
        }
    }

    private void doInstance() {
        if (classNames.size() == 0) {
            return;
        }

        for (String className : classNames) {
            try {
                Class<?> aClass = Class.forName(className);
                if (aClass.isAnnotationPresent(Controller.class)) {
                    // 默认将首字母小写作为beanName
                    String beanName = lowerFirstCase(aClass.getSimpleName());
                    ioc.put(beanName, aClass.newInstance());
                } else if (aClass.isAnnotationPresent(Service.class)) {
                    Service service = aClass.getAnnotation(Service.class);
                    String beanName = service.value();
                    // 设置了名字,就用用户自己设置
                    if (!"".equals(beanName.trim())) {
                        ioc.put(beanName, aClass.newInstance());
                        continue;
                    }
                    // 没设置,按接口类型创建一个实例
                    Class<?>[] interfaces = aClass.getInterfaces();
                    for (Class<?> anInterface : interfaces) {
                        ioc.put(anInterface.getName(), aClass.newInstance());
                    }
                } else {
                    continue;
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }

    }

    private String lowerFirstCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private void doAutowired() {
        if (ioc.isEmpty()) {
            return;
        }

        ioc.forEach((k, v) -> {
            Field[] declaredFields = v.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                if (!field.isAnnotationPresent(Autowired.class)) {
                    continue;
                }
                Autowired autowired = field.getAnnotation(Autowired.class);
                String beanName = autowired.value().trim();
                if ("".equals(beanName)) {
                    beanName = field.getType().getName();
                }
                // 暴力反射,允许访问private
                field.setAccessible(true);
                try {
                    field.set(v, ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    continue;
                }
            }
        });
    }

    private void initHandlerMapping() {
        if (ioc.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> aClass = entry.getValue().getClass();
            if (!aClass.isAnnotationPresent(Controller.class)) {
                continue;
            }
            String baseUrl = "";
            // 获取controller的URL配置
            if (aClass.isAnnotationPresent(RequestMapping.class)) {
                RequestMapping mapping = aClass.getAnnotation(RequestMapping.class);
                baseUrl = mapping.value();
            }

            // 获取Method的url配置
            Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                if (!method.isAnnotationPresent(RequestMapping.class)) {
                    continue;
                }
                RequestMapping mapping = method.getAnnotation(RequestMapping.class);
                String url = ("/" + baseUrl + "/" + mapping.value()).replaceAll("/+", "/");
                handlerMapping.put(url, method);
            }
        }

    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (this.handlerMapping.isEmpty()) {
            return;
        }

        String requestURI = req.getRequestURI();
        String contextPath = req.getContextPath();

        requestURI = requestURI.replace(contextPath, "").replaceAll("/+", "/");

        if (!this.handlerMapping.containsKey(requestURI)) {
            resp.getWriter().write("404");
            return;
        }

        Method method = this.handlerMapping.get(requestURI);
        // 获取方法参数列表
        Class<?>[] parameterTypes = method.getParameterTypes();
        // 获取请求的参数
        Map<String, String[]> parameterMap = req.getParameterMap();
        // 保存参数值
        Object[] paramValues = new Object[parameterTypes.length];
        // 方法参数列表
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i];
            if (parameterType == HttpServletRequest.class) {
                // 参数类型已明确,强转类型
                paramValues[i] = req;
                continue;
            } else if (parameterType == HttpServletResponse.class) {
                paramValues[i] = resp;
                continue;
            } else if (parameterType == String.class) {
                for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                    paramValues[i] = Arrays.toString(entry.getValue())
                            .replaceAll("\\[|\\]", "")
                            .replaceAll(",\\s", ",");
                }
            }

            String beanName = lowerFirstCase(method.getDeclaringClass().getSimpleName());
            // 利用反射机制来调用
            method.invoke(this.ioc.get(beanName), paramValues);
        }

    }

}
