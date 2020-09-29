<%@ page import="com.zretc.service.GradeService" %>
<%@ page import="com.zretc.service.impl.GradeServiceImpl" %>
<%@ page import="com.zretc.entity.Grade" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int gradeId= Integer.parseInt(request.getParameter("gradeId"));
    GradeService gs=new GradeServiceImpl();
    Grade grade=gs.selectGradeByNo(gradeId);

    request.setAttribute("grade",grade);
    request.getRequestDispatcher("../backend/grade/gradeDetail.jsp").forward(request,response);
%>
