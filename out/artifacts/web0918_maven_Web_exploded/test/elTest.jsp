<%@ page import="java.util.List" %>
<%@ page import="com.zretc.entity.Dept" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020年9月23日
  Time: 09:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        List<Dept> depts= (List<Dept>) request.getAttribute("depts");
        Map<String,Dept> maps=new HashMap<>();
        for (Dept dept : depts) {
            maps.put(dept.getdName(),dept);
        }
        request.setAttribute("maps",maps);
    %>
</head>
<body>
获取对象;<br>
${requestScope.emp}<hr>
获取对象的属性：<br>
${requestScope.emp.empNo}<br>
${requestScope.emp.dept.deptNo}<hr>
获取集合List：<br>
${requestScope.emps}<br>
集合的某条数据：<br>
${requestScope.emps[0]}<hr>
获取集合Map：<br>
${requestScope.maps}<br>
集合的某条数据：<br>
${requestScope.maps.SALES}<hr>
获取注册页面信息：<br>
${pageContext.username}


</body>
</html>
