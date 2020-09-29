<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功</title>
</head>
<body>
    <%
        // 获取session中的username
        String username=(String)session.getAttribute("username");
        if("".equals(username)||username==null){
            response.sendRedirect("login.jsp");
        }else {
    %>
     欢迎登录：<%=username%>
    <%
        }
    %>
    <br>
    <a href="LoginOut.jsp">退出登录</a>
</body>
</html>
