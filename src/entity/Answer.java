package entity;

import java.io.Serializable;

public class Answer implements Serializable{
	private static final long serialVersionUID = 1L;
	String aNo;
	String content;
	String qNo;
	String responderNo;
	String responderTime;
	int upVotedNum;
	int downVotedNum;
	String isAdopted;
	String isExist;
	public Answer(String aNo, String content, String qNo, String responderNo, String responderTime, int upVotedNum,
			int downVotedNum, String isAdopted, String isExist) {
		super();
		this.aNo = aNo;
		this.content = content;
		this.qNo = qNo;
		this.responderNo = responderNo;
		this.responderTime = responderTime;
		this.upVotedNum = upVotedNum;
		this.downVotedNum = downVotedNum;
		this.isAdopted = isAdopted;
		this.isExist = isExist;
	}
	public Answer() {
		
	}
	public String getaNo() {
		return aNo;
	}
	public void setaNo(String aNo) {
		this.aNo = aNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getqNo() {
		return qNo;
	}
	public void setqNo(String qNo) {
		this.qNo = qNo;
	}
	public String getResponderNo() {
		return responderNo;
	}
	public void setResponderNo(String responderNo) {
		this.responderNo = responderNo;
	}
	public String getResponderTime() {
		return responderTime;
	}
	public void setResponderTime(String responderTime) {
		this.responderTime = responderTime;
	}
	public int getUpVotedNum() {
		return upVotedNum;
	}
	public void setUpVotedNum(int upVotedNum) {
		this.upVotedNum = upVotedNum;
	}
	public int getDownVotedNum() {
		return downVotedNum;
	}
	public void setDownVotedNum(int downVotedNum) {
		this.downVotedNum = downVotedNum;
	}
	public String getIsAdopted() {
		return isAdopted;
	}
	public void setIsAdopted(String isAdopted) {
		this.isAdopted = isAdopted;
	}
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
	
}
