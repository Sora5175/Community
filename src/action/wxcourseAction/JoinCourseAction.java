package action.wxcourseAction;

import dao.CourseUserDAO;
import entity.CourseUser;
import factory.DAOFactory;

public class JoinCourseAction {
	String courseId;
	String uId;
	boolean pass = false;
	
	public String execute() {
		CourseUserDAO cud = (CourseUserDAO)DAOFactory.getInstance("CourseUserDAO");
		CourseUser courseUser = new CourseUser(Long.parseLong(courseId), uId, 0, 0, "1970-01-01 00:00:00","1");
		try {
			cud.add(courseUser);
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

	public String getUId() {
		return uId;
	}

	public void setUId(String uId) {
		this.uId = uId;
	}

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}
	
}
