<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/list.css" />
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/util.js"></script>
<script type="text/javascript" src="../js/index.js"></script>
<script type="text/javascript" src="../js/jqPaginator.js"></script>
<script type="text/javascript" src="../js/userlist/pageFunction.js"></script>
<script type="text/javascript" src="../js/userlist/list.js"></script>
</head>
<body>
		<%/*左侧导航栏*/ %>
		<div id='menu'>
			<div id="logo">
				<img src="../images/Community.png"/>
				<span>Community</span>
			</div>
		<ul>
			<li><a href="javascript:;" class="active notchoosed"><img src="../images/User.png"/>用户<img src="../images/Exit.png" id="exit"/></a>
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
		
		<%/*顶端横条*/%>
		<div id="top_content">
			<span>超级管理员</span>
			<a href="userExit"><img src="../images/Admin.png"/>John<img src="../images/Exit.png" id="exit"/></a>
		</div>
		
		<%/*顶端导航栏*/ %>
		<div id="index">
			<input id="keyword" type="text" placeholder="关键字"/>
			<input id="starttime" class="input_date" type="text" placeholder="起始时间"/>
			<input id="endtime" class="input_date" type="text" placeholder="结束时间"/>
			<select>
				<option>- 过滤器 -</option>
			</select>
			<input id="check" type="button" value="检索"/>
		</div>
		
		<%/*内容*/ %>
		 <div id="content">
		 		<span>显示行</span>
		 		<select id="pageSize">
		 			<option>2</option>
		 			<option selected="selected">5</option>
		 			<option>10</option>
		 		</select>
		 		<input id="user_add" type="button" value="添加"/>
				<table id="user">
					<tr class="table_top">
						<th>编号</th>
						<th>姓名</th>
						<th>性别</th>		
						<th>电话</th>
						<th>邮箱</th>
						<th>操作</th>
					</tr>
				</table>
				<div id="page_devide">
					<div id="pages"></div>
					<span>共<strong id="pageTotalNum"></strong>页</span>
					<span>当前</span><input id="currentPage" type="text" value="1"/><span>页</span>
					<input id="toPage" type="button" value="转到"/>
				</div>
		</div>
		
</body>
</html>