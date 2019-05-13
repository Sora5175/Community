$(function(){
	//新建分页
	getPages(1,5,1);
	//显示行更改
	$("#pageSize").on("change",function(){
		//当前页回滚到第一页
		$("#currentPage").val(1);
		getList($("#pageSize option:selected").val(),$("#currentPage").val());
	});
	//转到
	$("#toPage").on("click",function(){
		//判断页码是否合法
		if(Number($("#currentPage").val())<=Number($("#pageTotalNum").html()))
		{
			getList($("#pageSize option:selected").val(),$("#currentPage").val());
		}else {
			alert("页码超出范围或不存在！");
		}
	});
	//当前页键盘事件
	$("#currentPage").on("keydown",function(event){
		if(event.which == 13){
			//判断页码是否合法
			if(Number($("#currentPage").val())<=Number($("#pageTotalNum").html()))
			{
				getList($("#pageSize option:selected").val(),$("#currentPage").val());
			}else {
				alert("页码超出范围或不存在！");
			}
		}
	});
	//分页方法
	function getPages(totalPages,visiblePages,currentPage){
		$.jqPaginator('#pages',{
		    totalPages: totalPages,
		    visiblePages: visiblePages,
		    currentPage: currentPage,
		    first: '<input type="button" class="first" value="首页"/>',
		    prev: '<input type="button" class="first" value="上一页"/>',
		    next: '<input type="button" class="first" value="下一页"/>',
		    page: '<input type="button" class="first" value="{{page}}"/>',
		    last: '<input type="button" class="first" value="尾页"/>',
		    onPageChange: function (num) {
		        $('#currentPage').val(num);
		        getList($("#pageSize option:selected").val(),$('#currentPage').val());
		    }
		});
	};
	//分页更新方法
	function updatePages(totalPages,visiblePages,currentPage){
		$('#pages').jqPaginator('option', {
			totalPages: totalPages,
		    visiblePages: visiblePages,
		    currentPage: currentPage,
		});
	};
	//数据获取方法
	function getList(pageSize,currentPage){
		var user = $("#user>tbody");
		var pageTotalNum = $("#pageTotalNum");
		var pages = $("#pages");
		//列表和分页清空
		user.html('<tr class="table_top"><th>编号</th><th>姓名</th><th>性别</th><th>电话</th><th>邮箱</th><th>操作</th></tr>');
		pageTotalNum.html('1');
		pages.html('');
		//ajax
		$.ajax({
			"url":"getUserInfoList.action",
			"type":"post",
			"data":{"pageSize":pageSize,"currentPage":currentPage},
			"dataType":"json",
			"success":function(data){
				/*添加数据
				 * 添加总页数
				 * 分页更新
				 */
				for(var i in data.userInfoList){
					var u = data.userInfoList[i];
					user.append('<tr><td>'+u.userId+'</td><td>'+u.name+'</td><td>'+u.sex+'</td><td>'+u.tel+'</td><td>'+u.email+'</td><td><img class="edit" src="../images/Edit.png" title="修改"/><img class="del" src="../images/Delete.png" title="删除" /></td></tr>');
				}
				pageTotalNum.html(data.pageTotalNum);
				updatePages(Number(data.pageTotalNum),5,Number(currentPage));
			},
			"error":function(data){
				alert("系统繁忙,请稍后再试");
			}
		});
	};
});