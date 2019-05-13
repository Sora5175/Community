$(function(){
	//按钮事件
	//确认修改
	$("#edit_ok").on("click",function(){
		var userId = $("#userId").val();
		var userName = $("#userName").val();
		var userSex = $("#userSex").val();
		var userTel = $("#userTel").val();
		var userEmail = $("#userEmail").val();
		var userSchoolId = $("#userSchool").val();
		var userDepartmentId = $("#userDepartment").val();
		var userGradeId = $("#userGrade").val();
		var userClassId = $("#userClass").val();
		var userDeposite = $("#userDeposite").val();
		$.ajax({
			"url":"updateUserInfo.action",
			"type":"post",
			"data":{"userId":userId,"userName":userName,"userSex":userSex,"userTel":userTel,"userEmail":userEmail,"userSchoolId":userSchoolId,"userDepartmentId":userDepartmentId,"userGradeId":userGradeId,"userClassId":userClassId,"userDeposite":userDeposite},
			"dataType":"json",
			"success":function(data){
				if(data){
					window.location.href="userlist.java.action";
				}else{
					alert("修改时遇到错误，请稍后再试!");
				}
			},
			"error":function(){
				alert("服务器繁忙,请稍后再试!");
			},
		});
	});
	//取消修改
	$("#edit_cancel").on("click",function(){
		window.location.href = "userlist.java.action";
	});
	
	//确认添加
	$("#add_ok").on("click",function(){
		var userId = $("#userId").val();
		var userName = $("#userName").val();
		var userSex = $("#userSex").val();
		var userTel = $("#userTel").val();
		var userEmail = $("#userEmail").val();
		var userSchoolId = $("#userSchool").val();
		var userDepartmentId = $("#userDepartment").val();
		var userGradeId = $("#userGrade").val();
		var userClassId = $("#userClass").val();
		var userDeposite = $("#userDeposite").val();
		var userPwd = $("#userPwd").val();
		var userRePwd = $("#userRePwd").val();
		$.ajax({
			"url":"addUser.action",
			"type":"post",
			"data":{"userId":userId,"userName":userName,"userSex":userSex,"userTel":userTel,"userEmail":userEmail,"userSchoolId":userSchoolId,"userDepartmentId":userDepartmentId,"userGradeId":userGradeId,"userClassId":userClassId,"userDeposite":userDeposite},
			"dataType":"json",
			"success":function(data){
				if(data){
					window.location.href="userlist.java.action";
				}else{
					alert("添加时遇到错误，请稍后再试!");
				}
			},
			"error":function(){
				alert("服务器繁忙,请稍后再试!");
			},
		});
	});
	//取消添加
	$("#add_cancel").on("click",function(){
		window.location.href = "userlist.java.action";
	});
});