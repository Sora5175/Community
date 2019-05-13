package entity;

import java.io.Serializable;

public class Grade implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String GradeId;
	String GradeName;
	String DepartmentId;
	String IsExist;
	public String getGradeId() {
		return GradeId;
	}
	public void setGradeId(String gradeId) {
		GradeId = gradeId;
	}
	public String getGradeName() {
		return GradeName;
	}
	public void setGradeName(String gradeName) {
		GradeName = gradeName;
	}
	public String getDepartmentId() {
		return DepartmentId;
	}
	public void setDepartmentId(String departmentId) {
		DepartmentId = departmentId;
	}
	public String getIsExist() {
		return IsExist;
	}
	public void setIsExist(String isExist) {
		IsExist = isExist;
	}
}
