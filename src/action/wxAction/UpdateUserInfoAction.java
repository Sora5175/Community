package action.wxAction;

import dao.UserInfoDAO;
import entity.UserInfo;
import factory.DAOFactory;
import net.sf.json.JSONObject;

public class UpdateUserInfoAction {
	String userName;
	String userSex;
	String userSchoolId;
	String userDepartmentId;
	String userGradeId;
	String userClassId;
	String wxUserInfo;
	UserInfo userInfo;
	boolean pass = false;
	/*获取用户信息userId...userDeposite
	 * 返回pass:是否修改成功
	 */
	public String execute() {
		UserInfoDAO u = (UserInfoDAO)DAOFactory.getInstance("UserInfoDAO");
		try {
			JSONObject userInfo_temp = JSONObject.fromObject(wxUserInfo);
			userInfo = (UserInfo)JSONObject.toBean(userInfo_temp,UserInfo.class);
			userInfo.setName(userName);
			userInfo.setSex(userSex);
			userInfo.setSchoolId(userSchoolId);
			userInfo.setDepartmentId(userDepartmentId);
			userInfo.setGradeId(userGradeId);
			userInfo.setClassId(userClassId);
			u.update(userInfo);
			pass = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserSchoolId() {
		return userSchoolId;
	}
	public void setUserSchoolId(String userSchoolId) {
		this.userSchoolId = userSchoolId;
	}
	public String getUserDepartmentId() {
		return userDepartmentId;
	}
	public void setUserDepartmentId(String userDepartmentId) {
		this.userDepartmentId = userDepartmentId;
	}
	public String getUserGradeId() {
		return userGradeId;
	}
	public void setUserGradeId(String userGradeId) {
		this.userGradeId = userGradeId;
	}
	public String getUserClassId() {
		return userClassId;
	}
	public void setUserClassId(String userClassId) {
		this.userClassId = userClassId;
	}
	public String getWxUserInfo() {
		return wxUserInfo;
	}
	public void setWxUserInfo(String wxUserInfo) {
		this.wxUserInfo = wxUserInfo;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
	
}
