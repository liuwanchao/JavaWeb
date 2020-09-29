<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020年9月25日
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script>
        $(function () {
            $("#myform").submit(function () {
                $.ajax({
                    url:$("#myform").attr("action"),
                    type:"post",
                    data:{
                        "account":$("#account").val()
                    },
                    success:function (data) {
                       $("#msg").html(data);
                    }
                });
                return false;
            });
        });
    </script>
</head>
<body>
    <form id="myform" action="<%=application.getContextPath()%>/ajaxjq" method="post">
        <input type="text" name="account" id="account">
        <input type="submit" value="1">
    </form>
    <div id="msg">4</div>

</body>
</html>
