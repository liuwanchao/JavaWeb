<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020年9月25日
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        //XML对象的全局变量
        var xhr;
        window.onload=function (ev) {
            document.getElementById("btn").onclick=function (ev1) {
                var info=document.getElementById("info").value;
                // 判断浏览器是否支持XMLHTTPRequest对象
                if (window.XMLHttpRequest){
                    xhr=new XMLHttpRequest();
                } else {//使用旧版本进行兼容
                    xhr=new ActiveXObject("Mirosoft.XMLHTTP");
                }
                //绑定回调函数
                xhr.onreadystatechange=callback;
                //获取连接
                xhr.open("get","<%=application.getContextPath()%>/ajax?info="+info,true);
                //发送消息
                xhr.send(null);
            }
        }
        // 回调函数处理
        function callback() {
            // 判断状态信息，是否已经获取完毕响应信息
            if (xhr.readyState==4){
                // 判断HTTP状态码
                if (xhr.status==200){
                    // 相应获取完毕，获取响应信息
                    var s=xhr.responseText;
                    document.getElementById("myDiv").innerHTML=s;
                }
            }

        }


    </script>
</head>
<body>
<input type="text" name="info" id="info">
<button id="btn">按钮</button>
<div id="myDiv">div</div>
</body>
</html>
