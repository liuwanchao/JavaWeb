<%@ page import="com.zretc.entity.Product" %>
<%@ page import="com.zretc.service.impl.ProductServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/asserts/css/bootstrap.css"/>
    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <%
        String miId=request.getParameter("miId");
        Product product=new ProductServiceImpl().selectProductById(miId);
    %>
</head>
<body>
<div class="container">
    <div style="height: 50px"></div>
    <div class="col-md-6 col-md-offset-3">
        <form method="post" action="<%=request.getContextPath()%>/back/mi/update">
            <div class="form-group">
                <label for="miId">编号</label>
                <input type="text" class="form-control" id="miId" name="miId" value="<%=product.getMiId()%>" readonly="readonly" >
            </div>
            <div class="form-group">
                <label for="miName">名称</label>
                <input type="text" class="form-control" id="miName" name="miName" value="<%=product.getMiName()%>">
            </div>
            <div class="form-group">
                <label for="miImg">图片地址</label>
                <input type="text" class="form-control" id="miImg" name="miImg" value="<%=product.getMiImg()%>">
            </div>
            <div class="form-group">
                <label for="miPrice">价格</label>
                <input type="text" class="form-control" id="miPrice" name="miPrice" value="<%=product.getMiPrice()%>">
            </div>
            <div class="form-group">
                <label for="miMsg">首页信息</label>
                <input type="text" class="form-control" id="miMsg" name="miMsg" value="<%=product.getMiMsg()%>">
            </div>
            <div class="form-group">
                <label for="miMsg2">详情信息1</label>
                <input type="text" class="form-control" id="miMsg2" name="miMsg2" value="<%=product.getMiMsg2()%>">
            </div>
            <div class="form-group">
                <label for="miMsg3">详情信息2</label>
                <input type="text" class="form-control" id="miMsg3" name="miMsg3" value="<%=product.getMiMsg3()%>">
            </div>
            <button type="submit" class="btn btn-default">修改</button>
        </form>
    </div>

</div>
</body>
</html>
