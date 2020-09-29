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
        <form method="post" action="<%=request.getContextPath()%>/back/emp?msg=updateEmp">
            <div class="form-group">
                <label for="empNo">编号</label>
                <input type="text" class="form-control" id="empNo" name="empNo" value="${emp.empNo}" readonly>
            </div>
            <div class="form-group">
                <label for="empName">姓名</label>
                <input type="text" class="form-control" id="empName" name="empName" value="${emp.eName}">
            </div>
            <div class="form-group">
                <label>工作</label>
                <select  class="form-control" name="job">
                    <option value="CLERK">CLERK</option>
                    <option value="SALESMAN">SALESMAN</option>
                    <option value="MANAGER">MANAGER</option>
                    <option value="ANALYST">ANALYST</option>
                </select>
            </div>
            <div class="form-group">
                <label>经理</label>
                <select  class="form-control" name="mgr">
                    <c:forEach items="${emps}" var="e">
                        <option value="${e.eName}" <c:if test="${e.empNo==emp.mgr}"> selected</c:if> >${e.eName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="hireDate">入职时间</label>
                <input type="date" class="form-control" id="hireDate" name="hireDate" value="${emp.hireDate}">
            </div>
            <div class="form-group">
                <label for="sal">工资</label>
                <input type="text" class="form-control" id="sal" name="sal" value="${emp.sal}">
            </div>
            <div class="form-group">
                <label for="comm">奖金</label>
                <input type="text" class="form-control" id="comm" name="comm" value="${emp.comm}">
            </div>
            <div class="form-group">
                <label>部门</label>
                <select  class="form-control" name="deptNo">
                    <c:forEach items="${depts}" var="d">
                        <option value="${d.deptNo}" <c:if test="${d.deptNo==emp.dept.deptNo}"> selected</c:if> >${d.dName}</option>
                    </c:forEach>

                </select>
            </div>

            <button type="submit" class="btn btn-default">修改</button>
        </form>
    </div>

</div>
</body>
</html>
