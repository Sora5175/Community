package entity;

import java.io.Serializable;

public class Lost implements Serializable{
	private static final long serialVersionUID = 1L;
	String lNo;
	String lName;
	String photo;
	String describe;
	String lostLocation;
	String returnLocation;
	String publisherNo;
	String publisherTime;
	String type;
	String lostTime;
	Boolean isSolved;
	Boolean isExist;
	public Lost(String lNo, String lName, String photo, String describe, String lostLocation, String returnLocation,
			String publisherNo, String publisherTime, Boolean isSolved, Boolean isExist, String type, String lostTime) {
		super();
		this.lNo = lNo;
		this.lName = lName;
		this.photo = photo;
		this.describe = describe;
		this.lostLocation = lostLocation;
		this.returnLocation = returnLocation;
		this.publisherNo = publisherNo;
		this.publisherTime = publisherTime;
		this.isSolved = isSolved;
		this.isExist = isExist;
		this.type=type;
		this.lostTime=lostTime;
	}
	public Lost() {
		// TODO Auto-generated constructor stub
	}
	public String getlNo() {
		return lNo;
	}
	public void setlNo(String lNo) {
		this.lNo = lNo;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getLostLocation() {
		return lostLocation;
	}
	public void setLostLocation(String lostLocation) {
		this.lostLocation = lostLocation;
	}
	public String getReturnLocation() {
		return returnLocation;
	}
	public void setReturnLocation(String returnLocation) {
		this.returnLocation = returnLocation;
	}
	public String getPublisherNo() {
		return publisherNo;
	}
	public void setPublisherNo(String publisherNo) {
		this.publisherNo = publisherNo;
	}
	public String getPublisherTime() {
		return publisherTime;
	}
	public void setPublisherTime(String publisherTime) {
		this.publisherTime = publisherTime;
	}
	public Boolean getIsSolved() {
		return isSolved;
	}
	public void setIsSolved(Boolean isSolved) {
		this.isSolved = isSolved;
	}
	public Boolean getIsExist() {
		return isExist;
	}
	public void setIsExist(Boolean isExist) {
		this.isExist = isExist;
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
	
}
