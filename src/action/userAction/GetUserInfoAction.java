package action.userAction;

import dao.UserInfoDAO;
import entity.UserInfo;
import factory.DAOFactory;

public class GetUserInfoAction {
	String userId;
	UserInfo userInfo;
	
	/*获取userId
	 * 返回该userId对应的userInfo
	 */
	public String execute() {
		UserInfoDAO u = (UserInfoDAO)DAOFactory.getInstance("UserInfoDAO");
		try {
			userInfo = u.find(userId);
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
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
}
