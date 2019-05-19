package action.wxcourseAction;

import dao.CourseDAO;
import dao.CourseUserDAO;
import factory.DAOFactory;

public class StartSignAction {
	String courseId;
	boolean pass = true;
	public String execute() {
		CourseDAO cd = (CourseDAO)DAOFactory.getInstance("CourseDAO");
		CourseUserDAO cud = (CourseUserDAO)DAOFactory.getInstance("CourseUserDAO");
		try {
			cd.startSign(courseId);
			cud.startSign(courseId);
			pass = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
	
}
