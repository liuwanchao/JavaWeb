<%@ page import="com.zretc.entity.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="../asserts/css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../asserts/css/backend.css" />
    <script src="../asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="../asserts/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
        $(function(){
            $(".bodyLeft>ul>li:odd").hide();
            $(".bodyLeft>ul>li:even").click(function(){
                $(this).next().slideToggle();
                if($(this).children("span").attr("class")=="glyphicon glyphicon-menu-down"){
                    $(this).children("span").attr("class","glyphicon glyphicon-menu-down");
                }else{
                    $(this).children("span").attr("class","glyphicon glyphicon-menu-up");
                }
            });
        })
    </script>
    <%
        UserInfo userInfo= (UserInfo) request.getAttribute("userInfo");
    %>
</head>
<body>
<div class="container">
    <div class="pageTop">
        <div class="text-right">欢迎登录：<%=userInfo.getUserName()%> <a href="loginOutController.jsp" >注销</a></div>
    </div>
    <div class="pageBody row">
        <div class="bodyLeft col-md-2">
            <ul>
                <li>学生管理<span class="glyphicon glyphicon-menu-down"></span></li>
                <li>
                    <ul>
                        <li><a href="#" target="frame">添加学生</a></li>
                        <li><a href="#" target="frame">查询学生</a></li>
                    </ul>
                </li>
                <li>班级管理<span class="glyphicon glyphicon-menu-down"></span></li>
                <li>
                    <ul>
                        <li><a href="../backend/grade/gradeAdd.jsp" target="frame">添加班级</a></li>
                        <li><a href="<%=request.getContextPath()%>/controller/listGrade.jsp" target="frame">查询班级</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="bodyRight col-md-10">
            <iframe src="<%=request.getContextPath()%>/backend/hello.jsp" name="frame" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>
        </div>
    </div>
    <div class="pageDown">

    </div>
</div>
</body>
</html>
