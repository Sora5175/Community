package entity;

import java.io.Serializable;

public class VerificationCode implements Serializable{
	private static final long serialVersionUID = 1L;
	String cNo;
	String content;
	String uNo;
	String publisherTime;
	String isExist;
	public VerificationCode(String cNo, String content, String uNo, String publisherTime, String isExist) {
		super();
		this.cNo = cNo;
		this.content = content;
		this.uNo = uNo;
		this.publisherTime = publisherTime;
		this.isExist = isExist;
	}
	public VerificationCode() {
		// TODO Auto-generated constructor stub
	}
	public String getcNo() {
		return cNo;
	}
	public void setcNo(String cNo) {
		this.cNo = cNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getuNo() {
		return uNo;
	}
	public void setuNo(String uNo) {
		this.uNo = uNo;
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
