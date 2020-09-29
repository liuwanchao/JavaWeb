<%@ page import="java.util.List" %>
<%@ page import="com.zretc.entity.Grade" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/17
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/asserts/css/backend.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/asserts/css/bootstrap.css" />
    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>

    <script type="text/javascript">
        function confirm_del(gradeId) {
            if(confirm("您确定要删除" + gradeId + "的数据么?")) {
                location.href="gradeDeleteController.jsp?gradeId=" + gradeId ;
            }
        }
    </script>

</head>
<body>
<div class="container">
    <table class="table table-hover">
        <tr>
            <th>班级编号</th>
            <th>班级名称</th>
            <th>操作</th>
        </tr>
        <%
            List<Grade> list= (List<Grade>) request.getAttribute("list");
            for (Grade grade : list) {
        %>
        <tr>
            <td><%=grade.getGradeId()%></td>
            <td><%=grade.getGradeName()%></td>
            <td> <a href="<%=request.getContextPath()%>/controller/gradeDetailShow.jsp?gradeId=<%=grade.getGradeId()%>">详情</a>
                <a href="javascript:void(0);" onclick="confirm_del('<%=grade.getGradeId()%>')">删除</a></td>
        </tr>
        <%
            }
        %>
    </table>

</div>
</body>
</html>
