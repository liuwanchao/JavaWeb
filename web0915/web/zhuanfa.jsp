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
    //获取数据
    String phone = request.getParameter("phone");
    String name = request.getParameter("name");
    String sex = request.getParameter("sex");
    String pwd1 = request.getParameter("pwd1");
    String pwd2 = request.getParameter("pwd2");
    String email = request.getParameter("em");

    request.setAttribute("phone",phone);
    request.setAttribute("name",name);
    request.setAttribute("sex",sex);
    request.setAttribute("pwd1",pwd1);
    request.setAttribute("pwd2",pwd2);
    request.setAttribute("email",email);
    request.getRequestDispatcher("zfreslut.jsp").forward(request,response);
%>
</body>
</html>
