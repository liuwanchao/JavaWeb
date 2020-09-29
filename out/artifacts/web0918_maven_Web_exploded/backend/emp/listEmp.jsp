<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/asserts/css/backend.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/asserts/css/bootstrap.css" />
    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>

    <script type="text/javascript">
        function confirm_del(empNo) {
            if(confirm("您确定要删除" + empNo + "的数据么?")) {
                location.href="<%=request.getContextPath()%>/back/emp?msg=delete&empNo=" + empNo ;
            }
        }
    </script>

</head>
<body>
<div class="container">
    <table class="table table-hover">
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>工作</th>
            <th>经理</th>
            <th>入职时间</th>
            <th>工资</th>
            <th>奖金</th>
            <th>部门</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${empPage.data}" var="emp">
            <tr>
                <td>${emp.empNo}</td>
                <td>${emp.eName}</td>
                <td>${emp.job}</td>
                <td>${emp.mgr}</td>
                <td>${emp.hireDate}</td>
                <td>${emp.sal}</td>
                <td>${emp.comm}</td>
                <td>${emp.dept.dName}</td>
                <td> <a href="<%=request.getContextPath()%>/back/emp?msg=selectEmpByNo&empNo=${emp.empNo}" class="btn btn-default">详情</a>
                    <a href="javascript:void(0);" onclick="confirm_del('${emp.empNo}')" class="btn btn-default">删除</a></td>
            </tr>
        </c:forEach>
        <%--页数操作--%>
        <tr class="text-center">
            <td colspan="9">
                <a href="<%=request.getContextPath()%>/back/emp?msg=listEmp&pageNum=1" class="btn btn-default">首页</a>
                <a href="<%=request.getContextPath()%>/back/emp?msg=listEmp&pageNum=${empPage.upPage()}" class="btn btn-default">上一页</a>
                当前页${empPage.currentPage}/${empPage.totalPageCount()}
                <a href="<%=request.getContextPath()%>/back/emp?msg=listEmp&pageNum=${empPage.downPage()}" class="btn btn-default">下一页</a>
                <a href="<%=request.getContextPath()%>/back/emp?msg=listEmp&pageNum=${empPage.totalPageCount()}" class="btn btn-default">尾页</a>
            </td>
        </tr>

    </table>

</div>
</body>
</html>
