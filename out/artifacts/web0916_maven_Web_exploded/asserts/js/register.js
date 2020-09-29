//用户名失去焦点验证
$("#username").blur(function () {
    //获取用户名
    var username=$("#username").val();
    if (username.length<4||username.length>12){
        $("#msgusername").text("用户名要求长度4-12位")
    }else {
        $("#msgusername").text("");
    }
});
//密码失去焦点验证
$("#password").blur(function () {
    //获取密码
    var password=$("#password").val();
    if (password.length<4||username.length>12){
        $("#msgpwd").text("密码要求长度4-12位")
    }else {
        $("#msgpwd").text("");
    }
});
//提交按钮检查
function registerCheck() {
    var username=$("#username").val();
    if (username.length<4||username.length>12){
        alert("用户名要求长度4-12位");
        return false;
    }
    var password=$("#password").val();
    if (password.length<4||username.length>12){
        alert("密码要求长度4-12位");
        return false;
    }
    return true;
}