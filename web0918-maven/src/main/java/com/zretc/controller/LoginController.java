package com.zretc.controller;

import com.zretc.entity.UserInfo;
import com.zretc.service.UserService;
import com.zretc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginController",urlPatterns = "/login")
public class LoginController extends HttpServlet {
    UserService us = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String msg = req.getParameter("msg");

        if ("login".equals(msg)) {
            login(req, resp);
        }else  if ("loginout".equals(msg)) {
            loginout(req, resp);
        }
    }

    /**
     * 注销登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void loginout(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException  {
        req.getSession().removeAttribute("user");
        req.setAttribute("msg","注销成功");
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    /**
     * 登录
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("password");
        UserInfo user = us.selectUser(username, pwd);

        //账号密码不存在
        if (user==null) {
            req.setAttribute("msg", "登录失败，请重新登陆");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        //登录成功
        }else {
            req.getSession().setAttribute("user",user);
            //登录成功，记录到全局变量中
            int num= (int) getServletContext().getAttribute("num");
            getServletContext().setAttribute("num",num+1);
            resp.sendRedirect("backend/backend.jsp");
        }

    }
  /*  *//**
     * 登录
     *重复提交
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     *//*
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("password");
        UserInfo user = us.selectUser(username, pwd);

        String uid = (String) req.getSession().getAttribute("uid");
        String token = req.getParameter("token");
        System.out.println(uid+":"+token);
        if (uid != null && token != null && uid.equals(token)) {
            req.getSession().setAttribute("user", user);
            req.getSession().removeAttribute("uid");
            resp.sendRedirect("loginRes.jsp");
        }

    }*/
}
