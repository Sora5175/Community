//获取数据并创建图表
var userNumLoginChart = document.getElementById("userLoginNumChart").getContext("2d");
var userProportionChart = document.getElementById("userProportionChart").getContext("2d");
//获取近五天日期字符串
var timeDataStr = [];
for(var i=-4;i<=0;i++){
	timeDataStr.push(GetDateStr(i));
}
/*ajax请求发送日期字符串
 * 返回用户登录数量数据数组
 * 基于获取的数据创建线性图表
 */
$.ajax({
	"url":"getUserLoginNum.action",
	"type":"post",
	"data":{"timeDataStr":timeDataStr},
	"dataType":"json",
	"traditional": true,
	"success":function(data){
		var userLoginNumData = [];
		for(var i in data){
			userLoginNumData.push(Number(data[i]));
		}
		getuserLoginNumChart(userLoginNumData);
	},
	"error":function(){
		alert("服务器繁忙,请稍后再试!");
	},
});
/*ajax请求
 * 获取用户学生和教师数量构成的数组
 * 基于获得的数据创建饼状图表
 */
$.ajax({
	"url":"getUserProportion.action",
	"type":"post",
	"data":{},
	"dataType":"json",
	"success":function(data){
		var userProportionData = [];
		userProportionData.push(Number(data.studentNum));
		userProportionData.push(Number(data.teacherNum));
		getUserProportionChart(userProportionData);
	},
	"error":function(){
		alert("服务器繁忙,请稍后再试!");
	},
});
//创建用户登录数据线性图表
function getuserLoginNumChart(userLoginNumData){
	var chart = new Chart(userLoginNumChart,{
		type:"line",
		data:{
			labels: timeDataStr,
		    datasets: [
		    	{
		    		label: '用户登录数据',
		    		borderderColor:'rgba(181,181,181,1)',
		    		data : userLoginNumData,
	    		}]
		},
	});
};
//创建用户比例数据饼状图表
function getUserProportionChart(userProportionData){
	var chart = new Chart(userProportionChart,{
		type:"pie",
		data:{
			labels: [
		        "学生",
		        "教师",
		    ],
		    datasets: [
		        {
		            data: userProportionData,
		            backgroundColor: [
		            	 "#36A2EB",
		                 "#FFCE56"
		            ],
		            hoverBackgroundColor: [
		            	 "#36A2EB",
		                 "#FFCE56"
		            ]
		        }]
		},
	});
};


