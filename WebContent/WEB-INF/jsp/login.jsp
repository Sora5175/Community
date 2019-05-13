<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>管理员登录</title>
<link rel="stylesheet" type="text/css" href="../css/login.css"/>
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/util.js"></script>
<script type="text/javascript" src="../js/login/login.js"></script>
</head>
<body>
	<div id="login_div">
		<div>
			<form enctype="application/x-www-form-urlencoded">
				<span>用户名：</span><input id="username" type="text" name="username" maxlength="10"/><br/>
				<span>密码&nbsp;&nbsp;&nbsp;：</span><input id="pwd"  type="password"name="pwd" maxlength="16"/><br/>
				<span>验证码：</span><input id="code_input" type="text" name="code_input" maxlength="4"/>
				<img id="code_img" src="code" title="看不清？重换一张" /><br/>
				<input id="autologin" type="checkbox" name="autologin" value="0"/><span>&nbsp;&nbsp;下次自动登录</span><br/>
				<input id="login_action" type="button" value="登录"/>
				<span id="errorMsg"></span>
			</form>
		</div>
	</div>
</body>
</html>