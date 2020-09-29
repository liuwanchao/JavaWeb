<%@ page import="com.zretc.service.UserInfoService" %>
<%@ page import="com.zretc.service.impl.UserInfoServiceImpl" %>
<%@ page import="com.zretc.entity.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //处理乱码
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    //获取表单信息
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    String email=username+"@123.com";

    //创建用于注册的对象
    UserInfo userInfo=new UserInfo();
    userInfo.setUserName(username);
    userInfo.setPassword(password);
    userInfo.setEmail(email);

    //调用业务层执行注册方法
    UserInfoService uis=new UserInfoServiceImpl();
    boolean flag=uis.addUser(userInfo);

    //注册成功跳转登录页面，失败跳转注册页面
    if (flag){
        response.sendRedirect("/login.jsp");
    }else {
        response.sendRedirect("/register.jsp");
    }
%>