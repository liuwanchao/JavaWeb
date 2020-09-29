<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/asserts/css/backend.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/asserts/css/bootstrap.css" />
    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>

    <script type="text/javascript">
        function confirm_del(deptNo) {
            if(confirm("您确定要删除" + deptNo + "的数据么?")) {
                location.href="<%=request.getContextPath()%>/back/dept?msg=deleteDept&deptNo=" + deptNo ;
            }
        }
    </script>

</head>
<body>
<div class="container">
    <table class="table table-hover">
        <tr>
            <th>部门编号</th>
            <th>部门名称</th>
            <th>办公地点</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${deptPage.data}" var="dept">
            <tr>
                <td>${dept.deptNo}</td>
                <td>${dept.dName}</td>
                <td>${dept.loc}</td>
                <td> <a href="<%=request.getContextPath()%>/back/dept?msg=selectDeptByNo&deptNo=${dept.deptNo}" class="btn btn-default">详情</a>
                    <a href="javascript:void(0);" onclick="confirm_del('${dept.deptNo}')" class="btn btn-default">删除</a></td>
            </tr>
        </c:forEach>
        <%--页数操作--%>
        <tr class="text-center">
            <td colspan="9">
                <a href="<%=request.getContextPath()%>/back/dept?msg=listDept&pageNum=1" class="btn btn-default">首页</a>
                <a href="<%=request.getContextPath()%>/back/dept?msg=listDept&pageNum=${deptPage.upPage()}" class="btn btn-default">上一页</a>
                当前页${deptPage.currentPage}/${deptPage.totalPageCount()}
                <a href="<%=request.getContextPath()%>/back/dept?msg=listDept&pageNum=${deptPage.downPage()}" class="btn btn-default">下一页</a>
                <a href="<%=request.getContextPath()%>/back/dept?msg=listDept&pageNum=${deptPage.totalPageCount()}" class="btn btn-default">尾页</a>
            </td>
        </tr>
    </table>

</div>
</body>
</html>
