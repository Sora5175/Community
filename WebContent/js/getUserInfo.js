$(function(){
	getSchoolList();
	//变更学校
	$("#userSchool").on("change",function(){
		getDepartmentList(false);
		getGradeList(false);
		getClassList(true);
	});
	//变更院系
	$("#userDepartment").on("change",function(){
		getGradeList(false);
		getClassList(true);
	});
	//变更年级
	$("#userGrade").on("change",function(){
		getClassList(true);
	});
	//获得学校列表
	function getSchoolList(async){
		$.ajax({
			"url":"getSchoolList.action",
			"type":"post",
			"async":async,
			"data":{},
			"dataType":"json",
			"success":function(data){
				$("#userSchool").html("<option>--请选择--</option>");
				for(var i in data){
					$("#userSchool").append("<option value='"+data[i].schoolId+"' >"+data[i].schoolName+"</option>");
				}
			},
			"error":function(){
				alert("服务器繁忙,请稍后再试!");
			},
		});
	};
	//获得院系列表
	function getDepartmentList(async){
		var userSchoolId = $('#userSchool').val();
		$.ajax({
			"url":"getDepartmentList.action",
			"type":"post",
			"async": async,
			"data":{"userSchoolId":userSchoolId},
			"dataType":"json",
			"success":function(data){
				$("#userDepartment").html("<option>--请选择--</option>");
				for(var i in data){
					$("#userDepartment").append("<option value='"+data[i].departmentId+"' >"+data[i].departmentName+"</option>");
				}
			},
			"error":function(){
				alert("服务器繁忙,请稍后再试!");
			},
		});
	};
	//获得年级列表
	function getGradeList(async){
		var userDepartmentId = $('#userDepartment').val();
		$.ajax({
			"url":"getGradeList.action",
			"type":"post",
			"async": async,
			"data":{"userDepartmentId":userDepartmentId},
			"dataType":"json",
			"success":function(data){
				$("#userGrade").html("<option>--请选择--</option>");
				for(var i in data){
					$("#userGrade").append("<option value='"+data[i].gradeId+"' >"+data[i].gradeName+"</option>");
				}
			},
			"error":function(){
				alert("服务器繁忙,请稍后再试!");
			},
		});
	};
	//获得班级列表
	function getClassList(async){
		var userGradeId = $('#userGrade').val();
		$.ajax({
			"url":"getClassList.action",
			"type":"post",
			"async": async,
			"data":{"userGradeId":userGradeId},
			"dataType":"json",
			"success":function(data){
				$("#userClass").html("<option>--请选择--</option>");
				for(var i in data){
					$("#userClass").append("<option value='"+data[i].classId+"' >"+data[i].className+"</option>");
				}
			},
			"error":function(){
				alert("服务器繁忙,请稍后再试!");
			},
		});
	};
});