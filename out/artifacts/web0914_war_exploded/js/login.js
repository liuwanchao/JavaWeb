//点击跳转首页
$(".toindex").click(function() {
	window.open("index.html")
})
//登录方式切换
$(".cho").click(function() {
	$("#userlogin").css("color", "black");
	$("#piclogin").css("color", "black");
	$(this).css("color", "orangered");
	if ($(this).text() == "账号登录") {
		$("#ulogin").css("display", "inline");
		$(".plogin").css("display", "none");
	}
	if ($(this).text() == "扫码登录") {
		$(".plogin").css("display", "inline");
		$("#ulogin").css("display", "none");
	}
})
$(function(){
	
	// 用户名失去焦点时验证
	$("#username").blur(function(){
		var username=$("#username").val();
		// 用户名4-10位
		var uchk=/^[\S]{4,10}$/;
		if(username == ""){
			$("#msgu").text("用户名不能为空").css("display","block");
		}else if(uchk.test(username)){
			$("#msgu").css("display","none");
		}else{
			$("#msgu").text("用户名格式不正确").css("display","block");
		}
	})
	// 密码失去焦点时验证
	$("#pwd").blur(function(){
		var pwd=$("#pwd").val();
		if(pwd == ""){
			$("#msgp").text("密码不能为空").css("display","block");
		}else{
			$("#msgp").css("display","none");
		}
	})
	
	// 点击登录时验证
	$("#checkForm").click(function(){
		var username=$("#username").val();
		var pwd=$("#pwd").val();
		var flag=true;
		$.getJSON("json/users.json", function(data) {
			$.each(data, function(i, user) {
				if(user.username==username&&user.password==pwd){
					flag=false;
					alert("登陆成功！");
					sessionStorage.uname=user.username;
					location.href="index.html";
					window.location.href="index.html";
				}
			})
			if(flag){
				alert("账号或密码错误。登录失败！");
			}
		})
		
	})
	
	
})