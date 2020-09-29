<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <form method="post" action="<%=request.getContextPath()%>/back/dept?msg=updateDept">
            <div class="form-group">
                <label for="deptNo">编号</label>
                <input type="text" class="form-control" id="deptNo" name="deptNo" readonly="readonly" value="${dept.deptNo}">
            </div>
            <div class="form-group">
                <label for="dName">名称</label>
                <input type="text" class="form-control" id="dName" name="dName" value="${dept.dName}">
            </div>
            <div class="form-group">
                <label for="loc">地址</label>
                <input type="text" class="form-control" id="loc" name="loc" value="${dept.loc}">
            </div>

            <button type="submit" class="btn btn-default">修改</button>
        </form>
    </div>

</div>
</body>
</html>
