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
    String phone=(String)request.getAttribute("phone");
    String name=(String)request.getAttribute("name");
    String sex=(String)request.getAttribute("sex");
    String pwd1=(String)request.getAttribute("pwd1");
    String pwd2=(String)request.getAttribute("pwd2");
    String email=(String)request.getAttribute("email");
%>
转发结果<br>
<%=phone%><br>
<%=name%><br>
<%=sex%><br>
<%=pwd1%><br>
<%=pwd2%><br>
<%=email%>
</body>
</html>
