package entity;

import java.io.Serializable;

public class Classroom implements Serializable{
	private static final long serialVersionUID = 1L;
	String classroomId;
	String classroomName;
	String isExist;
	String buildingId;
	public Classroom(String classroomId, String classroomName, String isExist, String buildingId) {
		super();
		this.classroomId = classroomId;
		this.classroomName = classroomName;
		this.isExist = isExist;
		this.buildingId = buildingId;
	}
	public Classroom() {
		// TODO Auto-generated constructor stub
	}
	public String getClassroomId() {
		return classroomId;
	}
	public void setClassroomId(String classroomId) {
		this.classroomId = classroomId;
	}
	public String getClassroomName() {
		return classroomName;
	}
	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
	public String getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	
}
