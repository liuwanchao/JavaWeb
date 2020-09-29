<%@ page import="java.util.List" %>
<%@ page import="com.zretc.entity.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mi首页商品展示</title>
    <link rel="stylesheet" type="text/css" href="/asserts/css/bootstrap.css"/>
    <script src="/asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="/asserts/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" type="text/css" href="/asserts/css/show.css"/>
</head>
<body>
<div class="row">
    <div class="container">
        <div id="pho-show" class="col-md-12 row">
            <!-- 左侧广告 -->
            <div id="pho-show-l" class="col-md-3">
                <img src="/asserts/img/广告.webp">
            </div>

            <!-- 右侧商品 -->
            <div id="pho-show-r" class="col-md-9 row">
                <div class="row" id="addpro">
                    <%
                        List<Product> list=(List<Product>) request.getAttribute("list");
                        String show="";
                        for (int i=0;i<8;i++) {
                            show="<div class='pitem col-sm-3'><div><a href='detail?miId="+list.get(i).getMiId()
                                    +"'><img src='"+list.get(i).getMiImg() +"'><h3>"+list.get(i).getMiName()
                                    +"</h3><p class='msg'>"+list.get(i).getMiMsg()
                                    +"</p><p class='prc'>"+list.get(i).getMiPrice()+"</p></a></div></div>";
                    %>
                    <%=show%>
                    <%
                        }
                    %>

                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>
