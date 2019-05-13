package action.userAction;

import action.BaseAction;
import dao.UsersDAO;
import entity.Users;
import factory.DAOFactory;
import util.CookieUtil;

public class CheckPassAction extends BaseAction{
	String username;
	String pwd;
	String autologin;
	boolean pass = false;
	
	public String execute() {
		UsersDAO u = (UsersDAO)DAOFactory.getInstance("UsersDAO");
		Users user = new Users(username, pwd, "0","1");
		try {
			//判断管理员登录通过
			pass = u.pass(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//登录成功
		if(pass) {
			//session中存储登录信息
			session.put("username",username);
			try {
				//判断是否自动登录，在Cookie中存储一个1天的登录信息
				if(autologin.equals("1"))
					CookieUtil.addCookie("username", username, 60*60*24, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
			}
		}
		return "success";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAutologin() {
		return autologin;
	}
	public void setAutologin(String autologin) {
		this.autologin = autologin;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
	
}
