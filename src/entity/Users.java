package entity;

import java.io.Serializable;

public class Users implements Serializable{
	private static final long serialVersionUID = 1L;
	String userId;
	String pwd;
	String isAdmin;
	String isExist;
	
	public Users(String userId, String pwd, String isAdmin, String isExist) {
		super();
		this.userId = userId;
		this.pwd = pwd;
		this.isAdmin = isAdmin;
		this.isExist = isExist;
	}
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
	
}