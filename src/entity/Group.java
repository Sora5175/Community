package entity;

public class Group {
	long gId;
	String name;
	String content;
	String uId;
	int needNumber;
	int alternateNumber;
	String isExist;
	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Group(long gId, String name, String content, String uId, int needNumber, int alternateNumber, String isExist) {
		super();
		this.gId = gId;
		this.name = name;
		this.content = content;
		this.uId = uId;
		this.needNumber = needNumber;
		this.alternateNumber = alternateNumber;
		this.isExist = isExist;
	}
	public long getgId() {
		return gId;
	}
	public void setgId(long gId) {
		this.gId = gId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public int getNeedNumber() {
		return needNumber;
	}
	public void setNeedNumber(int needNumber) {
		this.needNumber = needNumber;
	}
	public int getAlternateNumber() {
		return alternateNumber;
	}
	public void setAlternateNumber(int alternateNumber) {
		this.alternateNumber = alternateNumber;
	}
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
	
}
