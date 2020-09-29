<%@ page import="com.zretc.entity.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020年9月18日
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/asserts/css/bootstrap.css" />
    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        function confirm_del(studentNo) {
            if(confirm("您确定要删除" + studentNo + "的数据么?")) {
                location.href="<%=request.getContextPath()%>/delete?studentNo=" + studentNo ;
            }
        }
    </script>

</head>
<body>
<div class="container">
    <table class="table table-hover">
        <tr>
            <th>学生编号</th>
            <th>学生名称</th>
            <th>性别</th>
            <th>出生日期</th>
            <th>联系方式</th>
            <th>住址</th>
            <th>体重</th>
            <th>操作</th>
        </tr>
        <%
            List<Student> list= (List<Student>) request.getAttribute("list");
            for (Student student : list) {
        %>
        <tr>
            <td><%=student.getStudentNo()%></td>
            <td><%=student.getStudentName()%></td>
            <td><%=student.getStudentGender()%></td>
            <td><%=student.getStudentBorndate()%></td>
            <td><%=student.getStudentContact()%></td>
            <td><%=student.getStudentAddress()%></td>
            <td><%=student.getStudentWeight()%></td>
            <td><a href="javascript:void(0);" onclick="confirm_del('<%=student.getStudentNo()%>')">删除</a></td>
        </tr>
        <%
            }
        %>
    </table>

</div>
</body>
</html>
