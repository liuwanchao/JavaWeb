<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/17
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/asserts/css/bootstrap.css"/>
    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="container">
    <div style="height: 50px"></div>
    <div class="col-md-6 col-md-offset-3">
        <form method="post" action="../../controller/gradeAddController.jsp">
            <div class="form-group">
                <label for="gradeName">要添加的班级名称</label>
                <input type="text" class="form-control" id="gradeName" name="gradeName">
            </div>
            <button type="submit" class="btn btn-default">添加班级</button>
        </form>
    </div>

</div>
</body>
</html>
