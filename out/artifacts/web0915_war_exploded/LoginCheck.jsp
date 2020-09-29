<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //获取数据
    String username=request.getParameter("username");
    String pwd=request.getParameter("password");

    //对数据进行判断
    if("admin".equals(username)&&"admin".equals(pwd)){
        //登录成功，username存处在session中，重定向到登录成功页面
        session.setAttribute("username",username);
        response.sendRedirect("LoginSuccess.jsp");
    }else {
        response.sendRedirect("login.jsp");
    }
%>