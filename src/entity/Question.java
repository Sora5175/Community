package entity;

import java.io.Serializable;

public class Question implements Serializable{
	private static final long serialVersionUID = 1L;
	String qNo;
	String content;
	String publisherNo;
	String publisherTime;
	String isExist;
	String isSolved;
	public Question(String qNo, String content, String publisherNo, String publisherTime, String isExist,
			String isSolved) {
		super();
		this.qNo = qNo;
		this.content = content;
		this.publisherNo = publisherNo;
		this.publisherTime = publisherTime;
		this.isExist = isExist;
		this.isSolved = isSolved;
	}
	public Question() {
		// TODO Auto-generated constructor stub
	}
	public String getqNo() {
		return qNo;
	}
	public void setqNo(String qNo) {
		this.qNo = qNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getIsSolved() {
		return isSolved;
	}
	public void setIsSolved(String isSolved) {
		this.isSolved = isSolved;
	}
	
}
