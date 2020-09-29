<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业3</title>
</head>
<body>
<%--
计算2013~2018年的闰年
能够被4整除而不能被100整除，或者能够被400整除--%>
<%
    List num=new ArrayList();
    for (int i=2013;i<=2018;i++){
        if ((i%4==0&&i%100!=0)||i%400==0){
            num.add(i);
        }
    }
    String result="";
    for (Object o : num) {
        result=result+o+",";
    }
%>
2013~2018年的闰年有：
<%=result%>



</body>
</html>
