package action.wxAction;

import java.util.Map;

import action.BaseAction;
import dao.UserInfoDAO;
import dao.WxDAO;
import entity.UserInfo;
import entity.Wx;
import factory.DAOFactory;
import util.WxUtil;

public class LoginAction extends BaseAction{
	String code;
	String openId;
	UserInfo userInfo;
	String sessionKey;
	public String execute() {
		Map<String,String> getLogin = WxUtil.getLogin(code);
		openId = getLogin.get("openId");
		sessionKey = getLogin.get("sessionKey");
		WxDAO w = (WxDAO)DAOFactory.getInstance("WxDAO");
		UserInfoDAO u = (UserInfoDAO)DAOFactory.getInstance("UserInfoDAO");
		Wx wx = null;
		try {
			wx = w.find(openId);
			if(wx != null) {
				userInfo = u.find(wx.getUId());
			}else {
				userInfo= null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getSessionKey() {
		return sessionKey;
	}
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
}
