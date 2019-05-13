package action.userAction;

import dao.UserInfoDAO;
import factory.DAOFactory;

public class GetUserProportionAction {
	int studentNum;
	int teacherNum;
	
	//返回未被销户的学生用户和教师用户的数量
	public String execute() {
		UserInfoDAO u = (UserInfoDAO)DAOFactory.getInstance("UserInfoDAO");
		try {
			studentNum = u.getStudentNum();
			teacherNum = u.getTeacherNum();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";
	}
	public int getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	public int getTeacherNum() {
		return teacherNum;
	}
	public void setTeacherNum(int teacherNum) {
		this.teacherNum = teacherNum;
	}
	
	
	
}
