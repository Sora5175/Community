//获取时间
function GetDateStr(AddDayCount) { 
	var date = new Date(); 
	date.setDate(date.getDate()+AddDayCount);
	var year = date.getFullYear(); 
	var month = date.getMonth()+1; 
	var day = date.getDate(); 
	return year+"-"+month+"-"+day; 
};

//修改带T的时间
function ChangeDateStr(date){
	return date.replace("T", " ");
}