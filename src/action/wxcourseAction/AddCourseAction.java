package action.wxcourseAction;

import java.text.SimpleDateFormat;
import java.util.Date;

import dao.CourseDAO;
import entity.Course;
import factory.DAOFactory;

public class AddCourseAction {
	String uId;
	String name;
	boolean pass = false;
	public String execute() {
		Date date=new Date();
	    date.setTime(0);
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time = sdf.format(date);
		Course course = new Course(0, uId, name, time,"1");
		CourseDAO cd = (CourseDAO)DAOFactory.getInstance("CourseDAO");
		try {
			cd.add(course);
			pass = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public String getUId() {
		return uId;
	}

	public void setUId(String uId) {
		this.uId = uId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
}
