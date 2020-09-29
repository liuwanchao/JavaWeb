
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script>
        $(function () {
            $("#account").blur(function () {
                $.ajax({
                    url:"<%=application.getContextPath()%>/ajaxjq",
                    type:"get",
                    data:{
                        "account":$("#account").val()
                    },
                    success:function (data) {
                       $("#msg").html(data);
                    }
                });
            });
        });
    </script>
</head>
<body>
<input type="text" name="account" id="account">
<div id="msg"></div>

</body>
</html>
