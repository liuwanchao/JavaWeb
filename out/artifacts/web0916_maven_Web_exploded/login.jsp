<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <link rel="stylesheet" type="text/css" href="asserts/css/bootstrap.css"/>
    <script src="asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="asserts/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h1 class="text-center">用户登录</h1>
            <div class="col-md-12">
                <form action="controller/userLoginController.jsp" method="post">
                    <div class="form-group">
                        <label for="username">用户名</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="用户名">
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="密码">
                    </div>
                    <button type="submit" class="btn btn-primary btn-lg btn-block">登录</button>
                </form>
            </div>
        </div>
    </div>

</div>
</body>
</html>
