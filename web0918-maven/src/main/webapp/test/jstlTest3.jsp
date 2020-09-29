<%@ page import="java.util.List" %>
<%@ page import="com.zretc.entity.Dept" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.zretc.service.DeptService" %>
<%@ page import="com.zretc.service.impl.DeptServiceImpl" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        DeptService ds=new DeptServiceImpl();
        List<Dept> depts = ds.listDept();
        Map<String,Dept> maps=new HashMap<>();
        for (Dept dept : depts) {
            maps.put(dept.getdName(),dept);
        }
        request.setAttribute("maps",maps);
    %>
</head>
<body>
<ol>
    <c:forEach items="${maps}" var="emp">
        <li>${emp.key}<br>
                ${emp.value}</li>
    </c:forEach>
</ol>
</body>
</html>
