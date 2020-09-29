<%@ page import="com.zretc.service.UserInfoService" %>
<%@ page import="com.zretc.service.impl.UserInfoServiceImpl" %>
<%@ page import="com.zretc.entity.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/17
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    //获取表单数据
    String username=request.getParameter("username");
    String password=request.getParameter("password");

    UserInfoService uis=new UserInfoServiceImpl();
    UserInfo userInfo=uis.selectUser(username,password);
    if (userInfo==null){
        response.sendRedirect("/login.jsp");
    }else {
        request.setAttribute("userInfo",userInfo);
        request.getRequestDispatcher("/backend/backend.jsp").forward(request,response);

}

%>