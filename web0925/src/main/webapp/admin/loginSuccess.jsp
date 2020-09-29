<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020年9月28日
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
欢迎登录：${user.username} <a href="<%=application.getContextPath()%>/login?msg=loginout">注销</a>
<hr>
历史访问人数：${applicationScope.num}
</body>
</html>
