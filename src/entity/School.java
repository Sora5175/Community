package entity;

import java.io.Serializable;

public class School implements Serializable{
	private static final long serialVersionUID = 1L;
	String schoolId;
	String schoolName;
	String isExist;
	
	public School(String schoolId, String schoolName, String isExist) {
		super();
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.isExist = isExist;
	}
	
	public School() {
		// TODO Auto-generated constructor stub
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
	
}
