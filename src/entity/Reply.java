package entity;

import java.io.Serializable;

public class Reply implements Serializable{
	private static final long serialVersionUID = 1L;
	String reNo;
	String content;
	String dNo;
	String preNo;
	String publisherNo;
	String publisherTime;
	String isExist;
	public Reply(String reNo, String content, String dNo, String preNo, String publisherNo, String publisherTime,
			String isExist) {
		super();
		this.reNo = reNo;
		this.content = content;
		this.dNo = dNo;
		this.preNo = preNo;
		this.publisherNo = publisherNo;
		this.publisherTime = publisherTime;
		this.isExist = isExist;
	}
	public Reply() {
		// TODO Auto-generated constructor stub
	}
	public String getReNo() {
		return reNo;
	}
	public void setReNo(String reNo) {
		this.reNo = reNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getdNo() {
		return dNo;
	}
	public void setdNo(String dNo) {
		this.dNo = dNo;
	}
	public String getPreNo() {
		return preNo;
	}
	public void setPreNo(String preNo) {
		this.preNo = preNo;
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
