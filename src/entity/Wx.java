package entity;

import java.io.Serializable;

public class Wx implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String openId;
	String uId;
	String isExist;
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getUId() {
		return uId;
	}
	public void setUId(String uId) {
		this.uId = uId;
	}
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
	
}
