$(function(){
	//点击添加
	$("#user_add").on("click",function(){
		window.location.href="useradd.java.action";
	});
	//点击编辑
	$("#user>tbody").on("click",".edit",function(){
		window.location.href="useredit.java.action?userId="+$(this).parent().prevAll().last().html();
	});
	//点击删除
	$("#user>tbody").on("click",".del",function(){
		var userId = $(this).parent().prevAll().last().html();
		$.ajax({
			"url":"delUserInfo.action",
			"type":"post",
			"data":{"userId":userId},
			"dataType":"json",
			"success":function(data){
				if(data){
					window.location.href = "userlist.java.action";
				}else{
					alert("删除时遇到错误，请稍后重试!");
					window.location.href = "userlist.java.action";
				}
			},
			"error":function(){
				alert("服务器繁忙,请稍后再试!");
			},
		});
	});
});