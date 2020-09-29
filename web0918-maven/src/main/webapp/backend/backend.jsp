<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        UserInfo user= (UserInfo) session.getAttribute("user");
//        if (user==null){
//            request.setAttribute("msg","请登录后访问后台");
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
//        }
    %>
</head>
<body>
<div class="container">
    <div class="pageTop row">
        <div class="col-md-8">
            历史访问人数：${applicationScope.num}
        </div>
        <div class="col-md-4 text-right">
            <c:if test="${empty sessionScope.user}">
                未登录
            </c:if>
            <c:if test="${!empty sessionScope.user}">
                欢迎登录：${user.username}<br>
                <a href="<%=application.getContextPath()%>/login?msg=loginout">注销</a>
            </c:if>
        </div>
    </div>
    <div class="pageBody row">
        <div class="bodyLeft col-md-2" style="line-height: 50px">
            <ul>
                <li>手机管理<span class="glyphicon glyphicon-menu-down"></span></li>
                <li>
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/backend/mi/addProduct.jsp" target="frame">添加手机</a></li>
                        <li><a href="<%=request.getContextPath()%>/back/mi/list" target="frame">查询手机</a></li>
                    </ul>
                </li>
                <li>部门管理<span class="glyphicon glyphicon-menu-down"></span></li>
                <li>
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/backend/dept/addDept.jsp" target="frame">添加部门</a></li>
                        <li><a href="<%=request.getContextPath()%>/back/dept?msg=listDept" target="frame" >查询部门</a></li>
                    </ul>
                </li>
                <li>员工管理<span class="glyphicon glyphicon-menu-down"></span></li>
                <li>
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/back/emp?msg=insert" target="frame">添加员工</a></li>
                        <li><a href="<%=request.getContextPath()%>/back/emp?msg=listEmp" target="frame" >查询员工</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="bodyRight col-md-10">
            <iframe src="hello.jsp" name="frame" width="100%" height="100%" frameborder="0" scrolling="yes"></iframe>
        </div>
    </div>
    <div class="pageDown">

    </div>
</div>
</body>
</html>
