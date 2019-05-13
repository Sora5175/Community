package entity;

import java.io.Serializable;

public class NoticeLost implements Serializable{
	private static final long serialVersionUID = 1L;
	String id;
	String lNo;
	String pic;
	String returnLoc;
	String time;
	String isExist;
	String publisherId;
	public NoticeLost(String id, String lNo, String pic, String returnLoc, String time, String isExist, String publisherId) {
		super();
		this.id = id;
		this.lNo = lNo;
		this.pic = pic;
		this.returnLoc = returnLoc;
		this.time = time;
		this.isExist = isExist;
		this.publisherId=publisherId;
	}
	public NoticeLost() {}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getlNo() {
		return lNo;
	}
	public void setlNo(String lNo) {
		this.lNo = lNo;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getReturnLoc() {
		return returnLoc;
	}
	public void setReturnLoc(String returnLoc) {
		this.returnLoc = returnLoc;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	
}
