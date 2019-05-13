package action.wxAction;


import dao.UserInfoDAO;
import dao.UsersDAO;
import dao.WxDAO;
import entity.UserInfo;
import entity.Users;
import entity.Wx;
import factory.DAOFactory;
import util.BeanUtil;

public class RegisterAction {
	String openId;
	String userId;
	String userName;
	String userSex;
	String userSchoolId;
	String userDepartmentId;
	String userGradeId;
	String userClassId;
	UserInfo userInfo;
	boolean pass = false;
	
	/*获取用户信息userId...userDeposite
	 * 返回pass:是否修改成功
	 */
	public String execute() {
		UserInfoDAO u = (UserInfoDAO)DAOFactory.getInstance("UserInfoDAO");
		UsersDAO us = (UsersDAO)DAOFactory.getInstance("UsersDAO");
		WxDAO w = (WxDAO)DAOFactory.getInstance("WxDAO");
		try {
			Users users = new Users();
			users.setUserId(userId);
			users.setPwd("");
			users.setIsAdmin("0");
			users.setIsExist("1");
			us.add(users);
			userInfo = new UserInfo();
			userInfo.setUserId(userId);
			userInfo.setName(userName);
			userInfo.setSex(userSex);
			userInfo.setTel(null);
			userInfo.setEmail(null);
			userInfo.setSchoolId(userSchoolId);
			userInfo.setDepartmentId(userDepartmentId);
			userInfo.setGradeId(userGradeId);
			userInfo.setClassId(userClassId);
			userInfo.setDeposite(0);
			userInfo.setIsStu("1");
			userInfo.setIsExist("1");
			userInfo.setRegisterTime(BeanUtil.getNow());
			u.add(userInfo);
			Wx wx = new Wx();
			wx.setOpenId(openId);
			wx.setUId(userId);
			wx.setIsExist("1");
			w.add(wx);
			pass = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
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

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
