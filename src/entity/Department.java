package entity;

import java.io.Serializable;

public class Department implements Serializable{
	private static final long serialVersionUID = 1L;
	String departmentId;
	String departmentName;
	String schoolId;
	String isExist;
	
	public Department(String departmentId, String departmentName, String schoolId, String isExist) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.schoolId = schoolId;
		this.isExist = isExist;
	}
	
	public Department() {}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
	
}
