<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020年9月18日
  Time: 09:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.invalidate();

    response.sendRedirect("../login.jsp");
%>