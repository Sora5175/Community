package entity;

public class GroupUser {
	long gId;
	String uId;
	String isAlternate;
	String isExist;
	public GroupUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GroupUser(long gId, String uId, String isAlternate, String isExist) {
		super();
		this.gId = gId;
		this.uId = uId;
		this.isAlternate = isAlternate;
		this.isExist = isExist;
	}
	public long getgId() {
		return gId;
	}
	public void setgId(long gId) {
		this.gId = gId;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getIsAlternate() {
		return isAlternate;
	}
	public void setIsAlternate(String isAlternate) {
		this.isAlternate = isAlternate;
	}
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
}
