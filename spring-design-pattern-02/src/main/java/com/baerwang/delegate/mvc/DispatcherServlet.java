package com.baerwang.delegate.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author baerwang
 * @since 2020/9/16 15:57
 */
public class DispatcherServlet extends HttpServlet {

    private List<Handler> handlerMapping = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        try {
            Class<MemberController> memberControllerClass = MemberController.class;
            Handler handler = new Handler();
            handler.setController(memberControllerClass.newInstance());
            handler.setMethod(memberControllerClass.getMethod("getMemberById", new Class[]{String.class}));
            handler.setUrl("/getMemberById");
            handlerMapping.add(handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取用户请求的URL
        // 按照J2EE的标准，每个URL对应Servlet，URL从浏览器输入
        String uri = request.getRequestURI();
        // Servlet拿到URL以后，要做权衡(要做判断，做选择)
        // 根据用户请求的URL，找到这个URL对应的某个Java类的方法

        // 通过获取的URL去做handlerMapping（以为它是策略常量）

        Handler handler = null;

        for (Handler h : handlerMapping) {
            if (uri.equals(h.getUrl())) {
                handler = h;
                break;
            }
        }

        if (request.getParameter("mid") != null) {
            // 将具体的任务分发给Method（通过反射调用对应的方法）
            assert handler != null;
            handler.getMethod().invoke(handler.getController(), request.getParameter("mid"));
            return;
        }
        response.getWriter().write("404 not found");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class Handler {
        private Object controller;

        private Method method;

        private String url;

        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
