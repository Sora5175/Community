package entity;

import java.io.Serializable;

public class SensitiveKey implements Serializable{
	private static final long serialVersionUID = 1L;
	String skNo;
	String content;
	String isExist;
	public SensitiveKey(String skNo, String content, String isExist) {
		super();
		this.skNo = skNo;
		this.content = content;
		this.isExist = isExist;
	}
	public SensitiveKey() {
		// TODO Auto-generated constructor stub
	}
	public String getSkNo() {
		return skNo;
	}
	public void setSkNo(String skNo) {
		this.skNo = skNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
	
}
