package entity;

import java.io.Serializable;

public class PublicData implements Serializable{
	private static final long serialVersionUID = 1L;
	String dNo;
	String isExist;
	public PublicData(String dNo, String isExist) {
		super();
		this.dNo = dNo;
		this.isExist = isExist;
	}
	public PublicData() {
		// TODO Auto-generated constructor stub
	}
	public String getdNo() {
		return dNo;
	}
	public void setdNo(String dNo) {
		this.dNo = dNo;
	}
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
	
}
