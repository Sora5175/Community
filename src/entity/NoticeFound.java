package entity;

import java.io.Serializable;

public class NoticeFound implements Serializable{
	private static final long serialVersionUID = 1L;
	String id;
	String fNo;
	String pic;
	String time;
	String isExist;
	String publisherId;
	String lostName;
	String color;
	String type;
	String lostTime;
	String lostLoc;
	public NoticeFound(String id, String fNo, String pic, String time, String isExist, String publisherId,
			String describe, String lostTime, String lostLoc, String color, String lostName, String type) {
		super();
		this.id = id;
		this.fNo = fNo;
		this.pic = pic;
		this.time = time;
		this.isExist = isExist;
		this.publisherId = publisherId;
		this.lostTime = lostTime;
		this.lostLoc = lostLoc;
		this.color = color;
		this.lostName = lostName;
		this.type = type;
	}
	public NoticeFound() {}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getfNo() {
		return fNo;
	}
	public void setfNo(String fNo) {
		this.fNo = fNo;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
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
	public String getLostName() {
		return lostName;
	}
	public void setLostName(String lostName) {
		this.lostName = lostName;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLostTime() {
		return lostTime;
	}
	public void setLostTime(String lostTime) {
		this.lostTime = lostTime;
	}
	public String getLostLoc() {
		return lostLoc;
	}
	public void setLostLoc(String lostLoc) {
		this.lostLoc = lostLoc;
	}
	
}
