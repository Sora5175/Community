package action.wxcourseAction;

import java.util.ArrayList;
import java.util.List;

import dao.CourseUserDAO;
import dao.UserInfoDAO;
import entity.CourseUser;
import entity.UserInfo;
import factory.DAOFactory;

public class GetSignListAction {
	String courseId;
	List<UserInfo> userInfoList = new ArrayList<UserInfo>();
	List<CourseUser> courseUserList;
	public String execute() {
		CourseUserDAO cud = (CourseUserDAO)DAOFactory.getInstance("CourseUserDAO");
		UserInfoDAO uid = (UserInfoDAO)DAOFactory.getInstance("UserInfoDAO");
		try {
			courseUserList = cud.findAllByCourseId(courseId);
			for(CourseUser courseUser:courseUserList) {
				userInfoList.add(uid.find(courseUser.getuId()));
			}
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
	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}
	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}
	public List<CourseUser> getCourseUserList() {
		return courseUserList;
	}
	public void setCourseUserList(List<CourseUser> courseUserList) {
		this.courseUserList = courseUserList;
	}
}
