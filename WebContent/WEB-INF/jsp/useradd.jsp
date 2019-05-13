<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>用户信息修改</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/list.css" />
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/util.js"></script>
<script type="text/javascript" src="../js/jqPaginator.js"></script>
<script type="text/javascript" src="../js/index.js"></script>
<script type="text/javascript" src="../js/getUserInfo.js"></script>
<script type="text/javascript" src="../js/userAction.js"></script>
</head>
<body>
		<%/*左侧导航栏*/ %>
		<div id='menu'>
			<div id="logo">
				<img src="../images/Community.png"/>
				<span>Community</span>
			</div>
		<ul>
			<li><a href="javascript:;" class="active notchoosed"><img src="../images/User.png"/>用户<img src="../images/Sliddown.png"/></a>
				<ul class="choosed">
					<li><a id="userview" href="javascript:;" class="notchoosed">用户视图</a></li>
					<li><a id="userlist" href="javascript:;" class="choosed">用户列表</a></li>
				</ul>
			</li>
			<li><a href="javascript:;" class="active notchoosed"><img src="../images/Question.png"/>问答<img src="../images/Sliddown.png"/></a>
				<ul class="notchoosed">
					<li><a href="javascript:;" class="notchoosed">问答视图</a></li>
					<li><a href="javascript:;" class="notchoosed">问答列表</a></li>
				</ul>
			</li>
			<li><a href="javascript:;" class="active notchoosed"><img src="../images/Post.png"/>帖子<img src="../images/Sliddown.png"/></a>
				<ul class="notchoosed">
					<li><a href="javascript:;" class="notchoosed">帖子视图</a></li>
					<li><a href="javascript:;" class="notchoosed">帖子列表</a></li>
				</ul>
			</li>
			<li><a href="javascript:;" class="active notchoosed"><img src="../images/Lost.png"/>失物招领<img src="../images/Sliddown.png"/></a>
				<ul class="notchoosed">
					<li><a href="javascript:;" class="notchoosed">失物招领视图</a></li>
					<li><a href="javascript:;" class="notchoosed">失物列表</a></li>
					<li><a href="javascript:;" class="notchoosed">招领列表</a></li>
				</ul>
			</li>
			<li><a href="javascript:;" class="active notchoosed"><img src="../images/Sensitive.png"/>违规词语<img src="../images/Sliddown.png"/></a>
				<ul class="notchoosed">
					<li><a href="javascript:;" class="notchoosed">违规词语列表</a></li>
				</ul>
			</li>
		</ul>
		</div>
		
		<%/*顶端横条*/ %>
		<div id="top_content">
			<span>超级管理员</span>
			<a href="userExit"><img src="../images/Admin.png"/>John<img src="../images/Exit.png" id="exit"/></a>
		</div>
		
		<%/*内容*/ %>
		<div id="content">
			<div class="userInfo">
				<div class="infoHeader">
					<strong>基本信息</strong>
				</div>
				<div class="infoContent">
					编号: <input class="edit_content" type="text" disabled="disabled" id="userId" value="${param.userId}"/><br/>
					姓名: <input class="edit_content" type="text" id="userName"/><br/>
					性别: <select class="edit_content" id="userSex"><option>--请选择--</option><option value="男">男</option><option value="女">女</option></select><br/>
					电话: <input class="edit_content" type="text" id="userTel"/><br/>
					邮箱: <input class="edit_content" type="text" id="userEmail"/><br/>
				</div>
			</div>
			<div class="userInfo">
				<div class="infoHeader">
					<strong>扩展信息</strong>
				</div>
				<div class="infoContent">
					学校: <select class="edit_content" id="userSchool"><option>--请选择--</option></select><br/>
					院系: <select class="edit_content" id="userDepartment"><option>--请选择--</option></select><br/>
					年级: <select class="edit_content" id="userGrade"><option>--请选择--</option></select><br/>
					班级: <select class="edit_content" id="userClass"><option>--请选择--</option></select><br/>
					余额: <input class="edit_content" id="userDeposite" value="0.0" disabled="disabled"/><br/>
				</div>
			</div>
			<div class="userInfo">
				<div class="infoHeader">
					<strong>其余信息</strong>
				</div>
				<div class="infoContent">
					密码&nbsp;&nbsp;	&nbsp;&nbsp;&nbsp;&nbsp;: <input class="edit_content" type="text" id="userPwd"/><br/>
					确认密码: <input class="edit_content" type="text" id="userRePwd"/><br/>
				</div>	
			</div>
			<div id="edit_action">
				<input type="button" value="确定添加" id="add_ok" class="action_ok"/>
				<input type="button" value="取消添加" id="add_cancel" class="action_cancel"/>
			</div>
		</div>
</body>
</html>