package entity;

import java.io.Serializable;

public class Building implements Serializable{
	private static final long serialVersionUID = 1L;
	String buildingId;
	String buildingName;
	String schoolId;
	String isExist;
	public Building(String buildingId, String buildingName, String schoolId, String isExist) {
		super();
		this.buildingId = buildingId;
		this.buildingName = buildingName;
		this.schoolId = schoolId;
		this.isExist = isExist;
	}
	public Building() {
		// TODO Auto-generated constructor stub
	}
	public String getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
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
