package entity;

import java.io.Serializable;

public class Found implements Serializable{
	private static final long serialVersionUID = 1L;
	String fNo;
	String fName;
	String photo;
	String describe;
	String foundLocation;
	String returnLocation;
	String publisherNo;
	String publisherTime;
	String type;
	Boolean isExist;
	Boolean isSolved;
	public Found(String fNo, String fName, String photo, String describe, String foundLocation, String returnLocation,
			String publisherNo, String publisherTime, Boolean isExist, Boolean isSolved, String type) {
		super();
		this.fNo = fNo;
		this.fName = fName;
		this.photo = photo;
		this.describe = describe;
		this.foundLocation = foundLocation;
		this.returnLocation = returnLocation;
		this.publisherNo = publisherNo;
		this.publisherTime = publisherTime;
		this.isExist = isExist;
		this.isSolved = isSolved;
		this.type = type;
	}
	public Found() {
		// TODO Auto-generated constructor stub
	}
	public String getfNo() {
		return fNo;
	}
	public void setfNo(String fNo) {
		this.fNo = fNo;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
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
	public String getFoundLocation() {
		return foundLocation;
	}
	public void setFoundLocation(String foundLocation) {
		this.foundLocation = foundLocation;
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
	public Boolean getIsExist() {
		return isExist;
	}
	public void setIsExist(Boolean isExist) {
		this.isExist = isExist;
	}
	public Boolean getIsSolved() {
		return isSolved;
	}
	public void setIsSolved(Boolean isSolved) {
		this.isSolved = isSolved;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
