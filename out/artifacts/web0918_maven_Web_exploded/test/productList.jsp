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
                        "msg":"selectpro",
                        "pName":$("#pName").val()
                    },
                    success: function (data) {
                        $("#tabe").html("<tr>" +
                            "<th>编号</th>" +
                            "<th>名称</th>" +
                            "<th>描述</th>" +
                            "<th>价格</th>" +
                            "<th>库存</th>" +
                            "<th>分类1</th>" +
                            "<th>分类2</th>" +
                            "<th>分类3</th>" +
                            "<th>文件名称</th>" +
                            "<th>是否删除</th>" +
                            "<th>所属品牌</th>" +
                            "</tr>");
                        var arr = JSON.parse(data);
                        $.each(arr, function (i, obj) {
                            $("#tabe").append("<tr><td>" + obj.id + "</td>" +
                                "<td>" + obj.name + "</td>" +
                                "<td>" + obj.description + "</td>" +
                                "<td>" + obj.proce + "</td>" +
                                "<td>" + obj.stock + "</td>" +
                                "<td>" + obj.categoryLevel1Id + "</td>" +
                                "<td>" + obj.categoryLevel2Id + "</td>" +
                                "<td>" + obj.categoryLevel3Id + "</td>" +
                                "<td>" + obj.fileName + "</td>" +
                                "<td>" + obj.isDelete + "</td>" +
                                "<td>" + obj.brand_id + "</td></tr>")
                        })
                    },
                    error: function () {
                        alert("获取数据失败");
                    }
                })
            })
        })
    </script>
</head>
<body>
<input type="text" name="pname" id="pname">
<button id="btn">搜索</button>
<hr>
<div class="container">
    <table id="tabe" class="table table-hover">
    </table>
</div>
</body>
</html>
<%--$("#tabe").html("<tr>" +
                            "<th>编号</th>" +
                            "<th>名称</th>" +
                            "<th>描述</th>" +
                            "<th>价格</th>" +
                            "<th>库存</th>" +
                            "<th>分类1</th>" +
                            "<th>分类2</th>" +
                            "<th>分类3</th>" +
                            "<th>文件名称</th>" +
                            "<th>是否删除</th>" +
                            "<th>所属品牌</th>" +
                            "</tr>");
                        var arr = JSON.parse(data);
                        $.each(arr, function (i, obj) {
                            $("#tabe").append("<tr><td>" + obj.id + "</td>" +
                                "<td>" + obj.name + "</td>" +
                                "<td>" + obj.description + "</td>" +
                                "<td>" + obj.proce + "</td>" +
                                "<td>" + obj.stock + "</td>" +
                                "<td>" + obj.categoryLevel1Id + "</td>" +
                                "<td>" + obj.categoryLevel2Id + "</td>" +
                                "<td>" + obj.categoryLevel3Id + "</td>" +
                                "<td>" + obj.fileName + "</td>" +
                                "<td>" + obj.isDelete + "</td>" +
                                "<td>" + obj.brand_id + "</td></tr>")
                        })--%>