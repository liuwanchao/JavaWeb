<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css"/>
    <script src="<%=request.getContextPath()%>/res/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.js" type="text/javascript" charset="utf-8"></script></head>
    <style type="text/css">
        img{
            height: 100px;
        }
    </style>

<body>

<div class="container">
    <table id="tabe" class="table table-hover">
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>价格</th>
            <th>图片</th>
        </tr>
        <c:forEach items="${list}" var="pro">
            <tr>
                <td>${pro.id}</td>
                <td>${pro.name}</td>
                <td>${pro.price}</td>
                <td><img src="<%=application.getContextPath()%>${pro.image}"></td>
            </tr>

        </c:forEach>
    </table>
</div>
</body>
</html>
