package entity;

import java.io.Serializable;

public class Notice implements Serializable{
	private static final long serialVersionUID = 1L;
	String nNo;
	String content;
	String photo;
	String publisherNo;
	String publisherTime;
	String isExist;
	public Notice(String nNo, String content, String photo, String publisherNo, String publisherTime, String isExist) {
		super();
		this.nNo = nNo;
		this.content = content;
		this.photo = photo;
		this.publisherNo = publisherNo;
		this.publisherTime = publisherTime;
		this.isExist = isExist;
	}
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	public String getnNo() {
		return nNo;
	}
	public void setnNo(String nNo) {
		this.nNo = nNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
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
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
	
}
