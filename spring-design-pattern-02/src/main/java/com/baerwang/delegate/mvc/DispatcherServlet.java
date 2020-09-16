package com.baerwang.delegate.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author baerwang
 * @since 2020/9/16 15:57
 */
public class DispatcherServlet extends HttpServlet {

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String uri = request.getRequestURI();
        String mid = request.getParameter("mid");
        String str = uri.substring(uri.lastIndexOf("/") + 1);
        if ("getMemberById".equals(str)) {
            new MemberController().getMemberById(mid);
        } else if ("getOrderById".equals(str)) {
            new OrderController().getOrderById(mid);
        } else if ("logout".equals(str)) {
            new SystemController().logout();
        } else {
            response.getWriter().write("404 not found!");
        }
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
