<%@ page import="com.zretc.service.GradeService" %>
<%@ page import="com.zretc.service.impl.GradeServiceImpl" %>
<%@ page import="com.zretc.entity.Grade" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    GradeService gs=new GradeServiceImpl();
    List<Grade> list=gs.listGrade();

    //传递数据
    request.setAttribute("list",list);
    request.getRequestDispatcher("/backend/grade/listGradeShow.jsp").forward(request,response);

%>