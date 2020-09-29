<%@ page import="java.util.List" %>
<%@ page import="com.zretc.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/asserts/css/backend.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/asserts/css/bootstrap.css" />
    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>

    <script type="text/javascript">
        function confirm_del(miId) {
            if(confirm("您确定要删除" + miId + "的数据么?")) {
                location.href="<%=request.getContextPath()%>/back/mi/delete?miId=" + miId ;
            }
        }
    </script>

</head>
<body>
<div class="container">
    <table class="table table-hover">
        <tr>
            <th>手机编号</th>
            <th>手机名称</th>
            <th>图片</th>
            <th>价格</th>
            <th>首页信息</th>
            <th>详情信息1</th>
            <th>详情信息2</th>
            <th>操作</th>
        </tr>
        <%
            List<Product> list= (List<Product>) request.getAttribute("products");
            for (Product product : list) {
        %>
        <tr>
            <td><%=product.getMiId()%></td>
            <td><%=product.getMiName()%></td>
            <td><%=product.getMiImg()%></td>
            <td><%=product.getMiPrice()%></td>
            <td><%=product.getMiMsg()%></td>
            <td><%=product.getMiMsg2()%></td>
            <td><%=product.getMiMsg3()%></td>
            <td> <a href="<%=request.getContextPath()%>/backend/mi/updateProduct.jsp?miId=<%=product.getMiId()%>">详情</a>
                <a href="javascript:void(0);" onclick="confirm_del('<%=product.getMiId()%>')">删除</a></td>
        </tr>
        <%
            }
        %>
    </table>

</div>
</body>
</html>
