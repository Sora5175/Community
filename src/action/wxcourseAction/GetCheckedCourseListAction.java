package action.wxcourseAction;

import java.util.ArrayList;
import java.util.List;

import dao.CourseDAO;
import dao.UserInfoDAO;
import entity.Course;
import factory.DAOFactory;

public class GetCheckedCourseListAction {
	String check;
	String uId;
	List<Course> courseList;
	List<String> nameList = new ArrayList<String>();
	
	public String execute() {
		CourseDAO cd = (CourseDAO)DAOFactory.getInstance("CourseDAO");
		UserInfoDAO uid = (UserInfoDAO)DAOFactory.getInstance("UserInfoDAO");
		try {
			courseList = cd.findAllByUserIdAndCheck(check, uId);
			for(Course course:courseList) {
				nameList.add(uid.find(course.getuId()).getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public String getUId() {
		return uId;
	}

	public void setUId(String uId) {
		this.uId = uId;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}
}
