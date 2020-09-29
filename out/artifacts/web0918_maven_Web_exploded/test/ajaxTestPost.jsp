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
                if (window.XMLHttpRequest){
                    xhr=new XMLHttpRequest();
                } else {
                    xhr=new ActiveXObject("Mirosoft.XMLHTTP");
                }
                xhr.onreadystatechange=callback;
                xhr.open("post","<%=application.getContextPath()%>/ajax",true);
                xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                xhr.send("info="+info);
            }
        }

        function callback() {
            if (xhr.readyState==4){
                if (xhr.status==200){
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
