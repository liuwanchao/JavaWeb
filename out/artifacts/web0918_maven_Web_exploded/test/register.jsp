<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
    <link rel="stylesheet" type="text/css" href="../asserts/css/bootstrap.css"/>
    <script src="../asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="../asserts/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h1 class="text-center">用户注册</h1>
            <div class="col-md-12">
                <form action="elTest2.jsp" method="post" onsubmit="return registerCheck()">
                    <div class="form-group">
                        <label for="username">用户名</label>
                        <input type="text" class="form-control" id="username" name="username" placeholder="用户名">
                        <!-- 验证提示信息-->
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="密码">
                        <!-- 验证提示信息-->
                    </div>
                    <div class="form-group">
                        <label>爱好</label>
                        <input type="checkbox" class="form-control" name="love" placeholder="足球">足球
                        <input type="checkbox" class="form-control" name="love" placeholder="篮球">篮球
                        <!-- 验证提示信息-->
                    </div>
                    <button type="submit" class="btn btn-primary btn-lg btn-block">注册</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
