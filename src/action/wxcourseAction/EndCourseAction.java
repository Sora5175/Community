package action.wxcourseAction;

import dao.CourseDAO;
import factory.DAOFactory;

public class EndCourseAction {
	String courseId;
	boolean pass = false;
	
	public String execute() {
		CourseDAO cd = (CourseDAO)DAOFactory.getInstance("CourseDAO");
		try {
			cd.del(courseId);
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
