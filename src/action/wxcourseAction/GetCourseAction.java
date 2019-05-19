package action.wxcourseAction;


import java.text.SimpleDateFormat;
import java.util.Date;

import dao.CourseDAO;
import dao.UserInfoDAO;
import entity.Course;
import factory.DAOFactory;

public class GetCourseAction {
	String courseId;
	String name;
	boolean inSign = false;
	Course course;
	
	public String execute() {
		CourseDAO cd = (CourseDAO)DAOFactory.getInstance("CourseDAO");
		UserInfoDAO ud = (UserInfoDAO)DAOFactory.getInstance("UserInfoDAO");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			course = cd.find(courseId);
			Date endTime = sdf.parse(course.getEndTime());
			Date now = new Date();
			inSign = (endTime.getTime() - now.getTime())>0;
			name = ud.find(course.getuId()).getName();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isInSign() {
		return inSign;
	}

	public void setInSign(boolean inSign) {
		this.inSign = inSign;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
