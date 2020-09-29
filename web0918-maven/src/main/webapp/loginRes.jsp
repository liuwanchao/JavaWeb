<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        * {
            text-align: center
        }
    </style>
</head>
<body>
<h1><c:choose>
    <c:when test="${user==null}">未登录</c:when>
    <c:when test="${user!=null}">欢迎登录：${user.uUsername}</c:when>
</c:choose></h1>
<h1><c:if test="${info!=null}">${info}</c:if></h1>
</body>
</html>
