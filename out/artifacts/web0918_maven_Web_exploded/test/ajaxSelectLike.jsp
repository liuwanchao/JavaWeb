<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
<script>
    $(function () {
        $("#btn").click(function () {
            $.ajax({
                url:"<%=application.getContextPath()%>/back/dept",
                type:"post",
                data:{
                    "msg":"selectLike",
                    "dName":$("#dName").val()
                },
                success:function (data) {
                    $("#tab").html(" <tr><th>编号</th><th>名称</th><th>地点</th></tr>");
                    var arr=JSON.parse(data);
                    $.each(arr,function (i,obj) {
                        $("#tab").append("<tr><td>"+obj.deptNo+"</td>" +
                            "<td>"+obj.dName+"</td>" +
                            "<td>"+obj.loc+"</td></tr>")
                    })
                },
                error:function () {
                    alert("获取数据失败")
                }
            })
        })
    })
</script>
</head>
<body>
<input type="text" name="dName" id="dName">
<button id="btn" >搜索</button><hr>
<table id="tab">
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>地点</th>
    </tr>
</table>
</body>
</html>
