<%@ page import="com.zretc.entity.Emp" %>
<%@ page import="com.zretc.service.EmpService" %>
<%@ page import="com.zretc.service.impl.EmpServiceImpl" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020年9月24日
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    EmpService es=new EmpServiceImpl();
    Emp emp = es.selectEmpByNo(7788);
    List<Emp> list = es.listEmp();
    session.setAttribute("emp",emp);
    session.setAttribute("list",list);

%>
<c:set var="isLogin" value="${emp.eName ne null}"/>
<c:if test="${isLogin}">
    欢迎登录：${emp.eName}
</c:if>
<c:if test="${!isLogin}">
    请登录
</c:if>
<br>
<c:choose>
    <c:when test="${emp.dept.deptNo==10}">10</c:when>
    <c:when test="${emp.dept.deptNo==20}">20</c:when>
    <c:when test="${emp.dept.deptNo==30}">30</c:when>
    <c:otherwise>其他</c:otherwise>
</c:choose>
<hr>
<ol>
    <c:forEach items="${list}" var="emp">
        <li>${emp.eName}<br>
                ${emp.dept.dName}</li>
    </c:forEach>
</ol>

</body>
</html>
