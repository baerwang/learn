package com.baerwang.proxy.dynamicproxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成源代码工具类
 *
 * @author baerwang
 * @since 2020/9/2 11:12
 */
public class GPProxy {

    public static final String LN = "\r\n";

    public static Object newProxyInstance(GPClassLoader classLoader, Class<?>[] interfaces, GPInvocationHandler h) {
        try {
            // 动态生成源代码.java
            String src = generateSrc(interfaces);
            // Java文件输出磁盘
            String filePath = GPProxy.class.getResource("").getPath();
            File file = new File(filePath + "$Proxy1.java");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(src);
            fileWriter.flush();
            fileWriter.close();

            // 把生成的.java文件编译成.class 文件
            JavaCompiler systemJavaCompiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager standardFileManager = systemJavaCompiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(file);

            JavaCompiler.CompilationTask task = systemJavaCompiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);

            task.call();
            standardFileManager.close();

            // 编译生成的.class文件加载到jvm中
            Class<?> proxyClass = classLoader.findClass("$Proxy1");
            Constructor<?> constructor = proxyClass.getConstructor(GPInvocationHandler.class);
            file.delete();
            // 返回字节码重组以后新的代理对象
            return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        sb.append("package com.baerwang.proxy.dynamicproxy;").append(LN);
        sb.append("import com.baerwang.proxy.xx.Person;").append(LN);
        sb.append("import java.lang.reflect.*;").append(LN);
        sb.append("public class $Proxy1 implements ").append(interfaces[0].getName()).append("  {").append(LN);
        sb.append("GPInvocationHandler h;").append(LN);
        sb.append("public $Proxy1(GPInvocationHandler h) { ").append(LN);
        sb.append("this.h = h; }").append(LN);

        for (Method method : interfaces[0].getMethods()) {
            Class<?>[] parameterTypes = method.getParameterTypes();

            StringBuilder paramNames = new StringBuilder();
            StringBuilder paramValues = new StringBuilder();
            StringBuilder paramClasses = new StringBuilder();

            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> clazz = parameterTypes[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type).append(" ").append(paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName()).append(".class");

                if (i > 0 && i < parameterTypes.length - 1) {
                    paramNames.append(",");
                    paramValues.append(",");
                    paramClasses.append(",");
                }
            }

            sb.append("public ").append(method.getReturnType().getName())
                    .append(" ").append(method.getName()).append("(").append(paramNames.toString()).append(") {").append(LN);

            sb.append("try {").append(LN);
            sb.append("Method m = ").append(interfaces[0].getName()).append(".class.getMethod(\"")
                    .append(method.getName()).append("\",new Class[]{").append(paramClasses.toString()).append("});").append(LN);

            sb.append(hasReturnValue(method.getReturnType()) ? "return " : "")
                    .append(getCaseCode("this.h.invoke(this,m,new Object []{" + paramValues + "})", method.getReturnType())).append(";").append(LN);

            sb.append("}catch(Error _ex) { }").append("catch(Throwable e) { ").append(LN);
            sb.append("throw new UndeclaredThrowableException(e);").append(LN).append("}");
            sb.append(getReturnEmptyCode(method.getReturnType()));
            sb.append("}");
        }
        sb.append("}").append(LN);
        return sb.toString();
    }

    private static Map<Class<?>, Class<?>> mappings = new HashMap<Class<?>, Class<?>>(16);

    static {
        mappings.put(int.class, Integer.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            return "return 0;";
        } else if (returnClass == void.class) {
            return "";
        } else {
            return "return null;";
        }
    }

    private static String getCaseCode(String code, Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            System.out.println(returnClass.getSimpleName());
            return "((" + mappings.get(returnClass).getName() + ")" + code + ")." + returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

    private static boolean hasReturnValue(Class<?> aClass) {
        return aClass != void.class;
    }

    private static String toLowerFirstCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
