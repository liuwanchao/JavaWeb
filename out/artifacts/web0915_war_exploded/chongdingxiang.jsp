<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/15
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    String phone = request.getParameter("phone");
    String name = request.getParameter("name");
    String pwd1 = request.getParameter("pwd1");
    String pwd2 = request.getParameter("pwd2");
    String email = request.getParameter("em");


    response.sendRedirect("cdxreslut.jsp");
%>
</body>
</html>
