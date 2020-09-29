$(function(){
	// 手机号码失去焦点时验证
	$("#phone").blur(function(){
		var phone=$("#phone").val();
		var phonechk=/^1[3456789]\d{9}$/;
		if(phone ===""){
			$("#msgphone").text("手机号不能为空").css("display","block");
		}else if(phonechk.test(phone)){
			$("#msgphone").css("display","none");
		}else{
			$("#msgphone").text("手机号格式不正确").css("display","block");
		}
	})
	// 密码失去焦点时验证
	$("#pwd1").blur(function(){
		var pwd=$("#pwd1").val();
		if(pwd == ""){
			$("#msgpwd1").text("密码不能为空").css("display","block");
		}else if(pwd.length<6 || pwd.length>12){
			$("#msgpwd1").text("密码长度为6-12位").css("display","block");
		}else{
			$("#msgpwd1").css("display","none");
		}
	})
	// 确认密码
	$("#pwd2").blur(function(){
		var pwd1=$("#pwd1").val();
		var pwd2=$("#pwd2").val();
		if(pwd1 ==pwd2){
			$("#msgpwd2").css("display","none");
		}else{
			$("#msgpwd2").text("密码不相同").css("display","block");
		}
	})
	// 邮箱
	$("#em").blur(function(){
		var email=$("#em").val();
		var emchk=/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(email ===""){
			$("#msgemail").text("邮箱不能为空").css("display","block");
		}else if(emchk.test(email)){
			$("#msgemail").css("display","none");
		}else{
			$("#msgemail").text("邮箱格式不正确").css("display","block");
		}
	})
	
	
	// 点击登录时验证
	$("#checkForm").click(function(){
		var phone=$("#phone").val();
		var pwd1=$("#pwd1").val();
		var pwd2=$("#pwd2").val();
		var email=$("#em").val();
		
		var phonechk=/^1[3456789]\d{9}$/;
		var emchk=/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		
		if(phonechk.test(phone)&&pwd1==pwd2&&emchk.test(email)&&pwd1.length>=6&&pwd1.length<=12){
			window.open("regssuccess.html");	
		}else{
			alert("输入内容格式存在问题，注册失败")
		}	
	})
	
	
})