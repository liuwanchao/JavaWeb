<%@ page import="com.zretc.entity.Grade" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/17
  Time: 19:19
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
<%
    Grade grade = (Grade) request.getAttribute("grade");
%>
<div class="container">
    <div style="height: 50px"></div>
    <div class="col-md-6 col-md-offset-3">
        <form method="post" action="gradeUpdateController.jsp">
            <div class="form-group">
                <label for="gradeId">班级编号</label>
                <input type="text" class="form-control" id="gradeId" name="gradeId" readonly="readonly" value="<%=grade.getGradeId()%>">
            </div>
            <div class="form-group">
                <label for="gradeName">班级名称</label>
                <input type="text" class="form-control" id="gradeName" name="gradeName" value="<%=grade.getGradeName()%>">
            </div>
            <button type="submit" class="btn btn-default">更改</button>
        </form>
    </div>

</div>

</body>
</html>
