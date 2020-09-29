<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>作业2</title>
</head>
<body>
<%--计算100以内的偶数之和--%>
<%
    List num=new ArrayList();
    for(int i=1;i<=100;i++){
        if (i%2==0){
            num.add(i);
        }
    }
    int sum=0;
    String result="";
    for (Object o : num) {
        result=result+o+",";
        sum=sum+(int)o;
    }
%>
100以内的偶数：
<%=result%>
100以内偶数的和：
<%=sum%>


</body>
</html>
