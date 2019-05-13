$(function(){
	var code_count=0;
	//验证码点击
	$("#code_img").on("click",function(){
		$("#code_img").attr("src","codeImg?v="+code_count);
		code_count++;
	});
	//自动登录点击
	$("#autologin").on("click",function(){
		var autologin = $(this).is(':checked');
		if(autologin){
			$(this).val("1");
		}else{
			$(this).val("0");
		}
	});
	//登录操作
	$("#login_action").on("click",function(){
		$("#errorMsg").html("正在校验登录...");
		var username = $("#username").val();
		var pwd = $("#pwd").val();
		var code_input = $("#code_input").val();
		window.location.href = "checkLogin.java.action?username="+username+"&password="+pwd+"&check="+code_input;
	});
});