package action.userAction;

import dao.UserInfoDAO;
import factory.DAOFactory;

public class GetUserNumAction {
	int userNum;
	
	//返回未被销户的用户数量
	public String execute() {
		UserInfoDAO u = (UserInfoDAO)DAOFactory.getInstance("UserInfoDAO");
		try {
			userNum = u.getStudentNum() + u.getTeacherNum();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	
}
