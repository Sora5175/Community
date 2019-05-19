package action.wxcourseAction;

import java.text.SimpleDateFormat;
import java.util.Date;

import dao.CourseUserDAO;
import entity.CourseUser;
import factory.DAOFactory;

public class SignAction {
	String uId;
	String courseId;
	String endTime;
	boolean pass = false;
	boolean timeout = true;
	public String execute() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date end;
		try {
			end = sdf.parse(endTime);
			if(end.getTime() - now.getTime()>0) {
				CourseUserDAO cud= (CourseUserDAO)DAOFactory.getInstance("CourseUserDAO");
				CourseUser courseUser = cud.find(courseId, uId);
				if(!courseUser.getEndTime().equals(endTime)) {
					int attendanNum = courseUser.getAttendanceNum()+1;
					int absenceNum = courseUser.getAbsenceNum()-1;
					courseUser.setAttendanceNum(attendanNum);
					courseUser.setAbsenceNum(absenceNum);
					courseUser.setEndTime(endTime);
					cud.update(courseUser);
					pass = true;
				}else {
					pass = false;
				}
				timeout = false;
			}else {
				timeout = true;
			}
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
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
	public boolean isTimeout() {
		return timeout;
	}
	public void setTimeout(boolean timeout) {
		this.timeout = timeout;
	}
	
}
