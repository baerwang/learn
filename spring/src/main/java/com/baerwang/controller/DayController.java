package com.baerwang.controller;

import com.baerwang.annotation.Autowired;
import com.baerwang.annotation.Controller;
import com.baerwang.annotation.RequestMapping;
import com.baerwang.service.DayService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/day")
public class DayController {

    @Autowired
    private DayService dayService;

    @RequestMapping("/find")
    public void find(HttpServletRequest request, HttpServletResponse response, String name) throws Exception {
        response.getWriter().write(dayService.find(name) ? "<h1 style=\"color:green;\">yes</h1>" : "<h1 style=\"color:red;\">no</h1>");
    }

}
