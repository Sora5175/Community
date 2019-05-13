<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>用户视图</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/list.css" />
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/util.js"></script>
<script type="text/javascript" src="../js/index.js"></script>
<script type="text/javascript" src="../js/jqPaginator.js"></script>
<script type="text/javascript" src="../js/index/getInfo.js"></script>
<script type="text/javascript" src="../js/Chart.js"></script>
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
					<li><a id="userview" href="javascript:;" class="choosed">用户视图</a></li>
					<li><a id="userlist" href="javascript:;" class="notchoosed">用户列表</a></li>
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
		
		<%/*顶端视图*/ %>
		<div id="userView_top">
			<a href="javascript:;"><span id="userNum" class="number">NaN</span><span>用户数量</span></a>
			<a href="javascript:;"><span id="userLoginNum" class="number">NaN</span><span>今日登录用户</span></a>
			<a href="javascript:;"><span id="userRegisterNum" class="number">NaN</span><span>今日用户增长</span></a>
		</div>
		
		<%/*视图内容*/ %>
		<div id="userView_content">
			<div id="chartList">
				<div id="userLoginNumView" class="viewContent">
					<div id="userLoginNumView_head" class="viewContent_head"><strong>用户登录数目明细</strong></div>
				 	<div id="userLoginNumView_content" class="viewContent_content">
				 		<canvas id="userLoginNumChart" style="width:600px;"></canvas>
				 	</div>
			 	</div>
				<div id="identityView" class="viewContent">
					<div id="identityView_head" class="viewContent_head"><strong>用户比例明细</strong></div>
				 	<div id="identityView_content" class="viewContent_content">
				 		<canvas id="userProportionChart" style="width:600px;"></canvas>
				 	</div>
			 	</div>
		 	</div>
		 	<div id="textList">
			 	<div id="userRegisterNumView" class="viewContent">
			 		<div id="userRegisterNumView_head" class="viewContent_head"><Strong>用户注册明细</Strong></div>
			 		<div id="userRegisterNumView_content" class="viewContent_content">
			 			<table id="user">
							<tr class="table_top">
								<th class="left">编号</th>
								<th class="left">注册时间</th>
							</tr>
						</table>
			 		</div>
			 	</div>
			 </div>
		</div>
		
		<script type="text/javascript" src="../js/index/charts.js"></script>
</body>
</html>