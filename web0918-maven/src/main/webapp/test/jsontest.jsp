<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="../asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
<html>
<head>
    <title>Title</title>
    <script>
        var user={"id":1,"name":"张三","pwd":123};
        var coun=["z","m","e"];
        var users=[{"id":11,"name":"张三","pwd":123},
            {"id":12,"name":"李四","pwd":456},
            {"id":13,"name":"王五","pwd":789}]
        
        $(function () {
            $("#id").html(user.id);
            $("#name").text(user.name);
            $("#pwd").text(user.pwd);
            $.each(coun,function (i,obj) {
                $("#ul").append("<li>"+obj+"</li>")
            })
            $.each(users,function (i,obj) {
                $("#tab").append("<tr><td>"+obj.id+"</td><td>"+obj.name+"</td><td>"+obj.pwd+"</td></tr>")
            })
        })
    </script>
</head>
<body>
id:<span id="id"></span><br>
name:<span id="name"></span><br>
pwd:<span id="pwd"></span><br>
<hr>
<ul id="ul">
</ul>
<hr>
<table id="tab">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>pwd</th>
    </tr>
</table>

</body>
</html>
