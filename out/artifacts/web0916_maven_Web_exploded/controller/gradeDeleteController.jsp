<%@ page import="com.zretc.service.GradeService" %>
<%@ page import="com.zretc.service.impl.GradeServiceImpl" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/17
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //设置编码
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    //获取数据
    int gradeId= Integer.parseInt(request.getParameter("gradeId"));

    GradeService gs=new GradeServiceImpl();
    boolean flag=gs.deleteGradeByNo(gradeId);

    if (flag){
    response.sendRedirect("listGrade.jsp");
    }

%>