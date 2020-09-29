<%@ page import="com.zretc.entity.Emp" %>
<%@ page import="com.zretc.service.EmpService" %>
<%@ page import="com.zretc.service.impl.EmpServiceImpl" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        EmpService es=new EmpServiceImpl();
        Emp emp=es.selectEmpByNo(7788);
        request.setAttribute("emp",emp);
    %>
</head>
<body>
${emp}<br>
<c:set target="${emp}" property="eName" value="123"/>
${emp}<br>
out标签输出:<br>
${"<a href='https://www.baidu.com/'>百度</a>"}<br>
<c:out escapeXml="false" value="<a href='https://www.baidu.com/'>百度</a>" /><br>
<c:out value="<a href='https://www.baidu.com/'>百度</a>" /><br>
</body>
</html>
