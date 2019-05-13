$(function(){
	getUserNum();
	getUserLoginNum();
	getUserRegisterNum();
	getUserRegisterList(10,1);
	/*ajax请求
	 * 获取未销户的用户数量
	 */
	function getUserNum(){
		$.ajax({
			"url":"getUserNum.action",
			"type":"post",
			"data":{},
			"dataType":"json",
			"success":function(data){
				$("#userNum").html(data.userNum);
			},
			"error":function(){
				alert("服务器繁忙,请稍后再试!");
			},
		});
	};
	/*ajax请求
	 * 获得今日登录用户数量
	 */
	function getUserLoginNum(){
		var timeDataStr = [];
		timeDataStr.push(GetDateStr(0));
		$.ajax({
			"url":"getUserLoginNum.action",
			"type":"post",
			"data":{"timeDataStr":timeDataStr},
			"dataType":"json",
			"traditional": true,
			"success":function(data){
				$("#userLoginNum").html(Number(data[0]));
			},
			"error":function(){
				alert("服务器繁忙,请稍后再试!");
			},
		});
	};
	/*ajax请求
	 * 获得今日注册用户数量
	 */
	function getUserRegisterNum(){
		var timeDataStr = [];
		timeDataStr.push(GetDateStr(0));
		$.ajax({
			"url":"getUserRegisterNum.action",
			"type":"post",
			"data":{"timeDataStr":timeDataStr},
			"dataType":"json",
			"traditional": true,
			"success":function(data){
				$("#userRegisterNum").html(Number(data[0]));
			},
			"error":function(){
				alert("服务器繁忙,请稍后再试!");
			},
		});
	};
	/*ajax请求
	 * 获得注册记录
	 */
	function getUserRegisterList(pageSize,currentPage){
		var user = $("#user>tbody");
		//列表清空
		user.html('<th class="left">编号</th><th class="left">注册时间</th>');
		//ajax
		$.ajax({
			"url":"getUserRegisterList.action",
			"type":"post",
			"data":{"pageSize":pageSize,"currentPage":currentPage},
			"dataType":"json",
			"success":function(data){
				/*添加数据
				 */
				for(var i in data.userRegisterList){
					var u = data.userRegisterList[i];
					user.append('<tr><td>'+u.userId+'</td><td>'+ChangeDateStr(u.registerTime)+'</td></tr>');
				}
			},
			"error":function(data){
				alert("系统繁忙,请稍后再试");
			}
		});
	};
});