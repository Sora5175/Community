package entity;

import java.io.Serializable;

public class Question implements Serializable{
	private static final long serialVersionUID = 1L;
	int qNo;
	int aNo;
	String qt;
	String at;
	int upVotedNum;
	int downVotedNum;
	String content;
	String qdescribe;
	String publisherNo;
	String publisherTime;
	String isExist;
	String isSolved;
	public Question(int qNo, int aNo,String qt,String at,int upVotedNum,int downVotedNum,String content,String qdescribe, String publisherNo, String publisherTime, String isExist,
			String isSolved) {
		super();
		this.qNo = qNo;
		this.aNo = aNo;
		this.qt = qt;
		this.at = at;
		this.upVotedNum = upVotedNum;
		this.downVotedNum = downVotedNum;
		this.content = content;
		this.qdescribe = qdescribe;
		this.publisherNo = publisherNo;
		this.publisherTime = publisherTime;
		this.isExist = isExist;
		this.isSolved = isSolved;
	}
	public Question() {
		// TODO Auto-generated constructor stub
	}
	public int getANo() {
		return aNo;
	}
	public void setANo(int aNo) {
		this.aNo = aNo;
	}
	public String getQt() {
		return qt;
	}
	public void setQt(String qt) {
		this.qt = qt;
	}
	public String getAt() {
		return at;
	}
	public void setAt(String at) {
		this.at = at;
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
	public int getQNo() {
		return qNo;
	}
	public void setQNo(int qNo) {
		this.qNo = qNo;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getQdescribe() {
		return qdescribe;
	}
	public void setQdescribe(String qdescribe) {
		this.qdescribe = qdescribe;
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
