package util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class BeanUtil {
	public static Date changeToDate(String dateStr){
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(dateStr);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return date;
	}
	public static String getNow() {
		String now = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		now = sdf.format(new Date());
		return now;
	}
	public static String subTime(String str) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal=Calendar.getInstance();
		long before=0,now=new Date().getTime(),sub=0;
		try {
			date = sdf.parse(str);
			str="";
			cal.setTime(date);
			before=cal.getTimeInMillis();
		} catch (Exception e) {
			// TODO: handle exception
		}
		sub=now-before;
		if(sub>86400000l) {
			str=sub/86400000l+"天前";
		}else if(sub>3600000l) {
			str=sub/3600000l+"小时前";
		}else if(sub>60000l) {
			str=sub/60000l+"分钟前";
		}else if(sub>1000l) {
			str=sub/1000l+"秒前";
		}
		return str;
	}
}
