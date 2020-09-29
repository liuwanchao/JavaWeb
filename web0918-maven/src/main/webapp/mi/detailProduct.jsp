<%@ page import="com.zretc.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020年9月20日
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/asserts/css/bootstrap.css"/>
    <script src="/asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="/asserts/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <style type="text/css">
        span{
            color: orange;
        }
        img{
            width: 400px;
        }
    </style>
    <%
        Product product= (Product) request.getAttribute("product");
    %>
</head>
<body>
<div class="row">
    <!-- 左侧 -->
    <div id="body-left" class="col-md-6">
       <div class="text-center"><img src="<%=product.getMiImg()%>"></div>
    </div>
    <!-- 右侧 -->
    <div id="body-right" class="col-md-6">
        <h2><%=product.getMiName()%></h2>
        <span ><%=product.getMiMsg2()%></span>
        <p><%=product.getMiMsg3()%></p><br>
        <hr>
        <span style="font-size: 30px;"><%=product.getMiPrice()%></span>

    </div>
</div>
</body>
</html>
