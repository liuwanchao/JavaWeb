<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/16
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int num= (int) application.getAttribute("num");
    num++;
    application.setAttribute("num",num);
%>
页面历史访问人数：<%=num%>
</body>
</html>
