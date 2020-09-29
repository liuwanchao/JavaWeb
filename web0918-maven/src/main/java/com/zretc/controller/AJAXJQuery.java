package com.zretc.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AJAXJQuery extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        super.service(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post");

        String info=req.getParameter("account");
        System.out.println(info);

        PrintWriter out=resp.getWriter();
        out.write("addsasd");
        out.flush();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info=req.getParameter("account");
        System.out.println(info);

        PrintWriter out=resp.getWriter();
        if ("admin".equals(info)){
            out.write("用户名重复");
            out.flush();
        }else {
            out.write("用户名可用");
            out.flush();
        }

    }
}
