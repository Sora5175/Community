package entity;

import java.io.Serializable;

public class Class implements Serializable{
	private static final long serialVersionUID = 1L;
	String classId;
	String className;
	String gradeId;
	String isExist;
	
	public Class(String classId, String className, String gradeId, String isExist) {
		super();
		this.classId = classId;
		this.className = className;
		this.gradeId = gradeId;
		this.isExist = isExist;
	}
	
	public Class() {
		
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getGradeId() {
		return gradeId;
	}
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
	
}
