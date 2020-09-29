<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/15
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="zhuanfa.jsp" method="get">
    手机号码<input type="text" id="phone" name="phone" placeholder="手机号码"><br>
    姓名<input type="text" id="name" name="name" placeholder="手机号码"><br>
    密码<input type="password" id="pwd1" name="pwd1" placeholder="密码"><br>
    性别<input type="radio" name="sex" value="男"> 男<input type="radio" name="sex" value="女"> 女<br>
    确认密码<input type="password" id="pwd2" name="pwd2" placeholder="确认密码"><br>
    邮箱<input type="email" id="em" name="em" placeholder="邮箱"><br>

    <button type="submit" id="checkForm">注册</button>
</form>
</body>
</html>
