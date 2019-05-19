package action.wxcourseAction;

import java.util.List;

import dao.CourseDAO;
import entity.Course;
import factory.DAOFactory;

public class GetCourseListAction {
	List<Course> courseList;
	String uId;
	
	public String execute() {
		CourseDAO cd = (CourseDAO)DAOFactory.getInstance("CourseDAO");
		try {
			courseList = cd.findAllByUserId(uId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public String getUId() {
		return uId;
	}

	public void setUId(String uId) {
		this.uId = uId;
	}

	
}
