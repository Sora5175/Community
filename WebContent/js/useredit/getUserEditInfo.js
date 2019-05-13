$(function(){
	var userId = $("#userId").val();
	/*ajax请求
	 * 获取用户数据并置于界面
	 */
	$.ajax({
		"url":"getUserInfo.action",
		"type":"post",
		"data":{"userId":userId},
		"dataType":"json",
		"success":function(data){
			$("#userName").val(data.name);
			$("#userSex").val(data.sex);
			$("#userTel").val(data.tel);
			$("#userEmail").val(data.email);
			$("#userDeposite").val(data.deposite);
			$("#userSchool").val(data.schoolId);
			getDepartmentList(false);
			$("#userDepartment").val(data.departmentId);
			getGradeList(false);
			$("#userGrade").val(data.gradeId);
			getClassList(false);
			$("#userClass").val(data.classId);
		
		},
		"error":function(){
			alert("服务器繁忙,请稍后再试!");
		},
	});
});