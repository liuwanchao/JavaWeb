<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //注销session
    session.invalidate();
    //返回登录页面
    response.sendRedirect("login.jsp");
%>