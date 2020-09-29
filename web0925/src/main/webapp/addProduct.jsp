<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css"/>
    <script src="<%=request.getContextPath()%>/res/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.js" type="text/javascript"
            charset="utf-8"></script>
</head>
<body>
<div class="col-md-6 col-md-offset-3">
    <form action="<%=application.getContextPath()%>/product?msg=add" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="name">商品名称</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="price">价格</label>
            <input type="text" class="form-control" id="price" name="price">
        </div>
        <div class="form-group">
            <label for="img">选择图片</label>
            <input type="file" id="img" name="img">
        </div>
        <div class="text-center" style="color: red">${msg}</div>

        <button type="submit" class="btn btn-default  btn-primary btn-lg btn-block">添加</button>
    </form>
</div>
</body>
</html>
