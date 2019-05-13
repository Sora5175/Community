$(function(){
	var code_count=0;
	//验证码点击
	$("#code_img").on("click",function(){
		$("#code_img").attr("src","code?v="+code_count);
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
		var code_input = $("#code_input").val();
		//校验验证码正确性
		$.ajax({
			"url":"checkcode.action",
			"type":"post",
			"data":{"code_input":code_input},
			"dataType":"json",
			"success":function(data){
				if(!data){
					//登录失败
					$("#errorMsg").html("验证码输入错误！");
				}else{
					//验证码正确，校验账号密码正确性
					var username = $("#username").val();
					var pwd = $("#pwd").val();
					var autologin = $("#autologin").val();
					$.ajax({
						"url":"checkpass.action",
						"type":"post",
						"data":{"username":username,"pwd":pwd,"autologin":autologin},
						"dataType":"json",
						"success":function(data){
							if(!data){
								//登录失败
								$("#errorMsg").html("账号或密码输入错误！");
							}else{
								//登录成功
								window.location.href = "../superadmin_user/userview.java.action";
							}
						},
						"error":function(data){
							$("#errorMsg").html("服务器繁忙,请稍后再试！");
						}
					});
				}
			},
			"error":function(data){
				$("#errorMsg").html("服务器繁忙,请稍后再试！");
			}
		});
		$("#code_img").attr("src","code?v="+code_count);
		code_count++;
	});
});