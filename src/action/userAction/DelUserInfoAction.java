package action.userAction;

import dao.UserInfoDAO;
import factory.DAOFactory;

public class DelUserInfoAction {
	String userId;
	boolean pass = false;
	/*获取userId并将其IsExist修改为false
	 * 返回pass：修改是否成功
	 */
	public String execute() {
		try {
			UserInfoDAO u = (UserInfoDAO)DAOFactory.getInstance("UserInfoDAO");
			u.del(userId);
			pass = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
	
}
