package entity;

public class CV {
	long cId;
	long gId;
	String uId;
	String isChecked;
	String isExist;
	public CV() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CV(long cId,long gId, String uId, String isChecked, String isExist) {
		super();
		this.cId = cId;
		this.gId = gId;
		this.uId = uId;
		this.isChecked = isChecked;
		this.isExist = isExist;
	}
	public long getcId() {
		return cId;
	}
	public void setcId(long cId) {
		this.cId = cId;
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
	public String getIsChecked() {
		return isChecked;
	}
	public void setIsChecked(String isChecked) {
		this.isChecked = isChecked;
	}
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
}
