<%@ page import="com.zretc.service.GradeService" %>
<%@ page import="com.zretc.service.impl.GradeServiceImpl" %>
<%@ page import="com.zretc.entity.Grade" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/17
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //设置编码
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    //获取数据
    int gradeId= Integer.parseInt(request.getParameter("gradeId"));
    String gradeName=request.getParameter("gradeName");
    Grade grade=new Grade(gradeId,gradeName);

    GradeService gs=new GradeServiceImpl();
    boolean flag=gs.updateGradeByNo(grade);

    if (flag){
        response.sendRedirect("listGrade.jsp");
    }

%>