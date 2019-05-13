package action.userAction;

import dao.UserInfoDAO;
import entity.UserInfo;
import factory.DAOFactory;

public class UpdateUserInfoAction {
	String userId;
	String userName;
	String userSex;
	String userTel;
	String userEmail;
	String userSchoolId;
	String userDepartmentId;
	String userGradeId;
	String userClassId;
	String userDeposite;
	boolean pass = false;
	
	/*获取用户信息userId...userDeposite
	 * 返回pass:是否修改成功
	 */
	public String execute() {
		UserInfoDAO u = (UserInfoDAO)DAOFactory.getInstance("UserInfoDAO");
		try {
			UserInfo userInfo = u.find(userId);
			userInfo.setName(userName);
			userInfo.setSex(userSex);
			userInfo.setTel(userTel);
			userInfo.setEmail(userEmail);
			userInfo.setSchoolId(userSchoolId);
			userInfo.setDepartmentId(userDepartmentId);
			userInfo.setGradeId(userGradeId);
			userInfo.setClassId(userClassId);
			userInfo.setDeposite(Float.parseFloat(userDeposite));
			u.update(userInfo);
			pass = true;
		}catch (Exception e) {
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
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
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
	public String getUserDeposite() {
		return userDeposite;
	}
	public void setUserDeposite(String userDeposite) {
		this.userDeposite = userDeposite;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
	
}
