package entity;

import java.io.Serializable;

/* @param activityId 活动编号
 * @param content 活动内容
 * @param location 活动地址
 * @param kind 活动类型
 * @param department 活动部门
 * @param sponsor 活动发起者
 * @param isExist 活动是否存在
 * @param startTime 活动报名时间
 * @param endTime 活动举行时间
 * @param singnPeople 活动已报名人员
 * 
 */
public class Activity implements Serializable{
	private static final long serialVersionUID = 1L;
	String activityId;
	String content;
	String location;
	String kind;
	String department;
	String sponsor;
	String isExist;
	String startTime;
	String endTime;
	String signPeople;
	public String setSignPeople;


	public Activity(String activityId, String content, String location, String kind, String department, String sponsor,
			String isExist, String startTime, String endTime, String signPeople) {
		super();
		this.activityId = activityId;
		this.content = content;
		this.location = location;
		this.kind = kind;
		this.department = department;
		this.sponsor = sponsor;
		this.isExist = isExist;
		this.startTime = startTime;
		this.endTime = endTime;
		this.signPeople = signPeople;
	}
	public Activity() {
		
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSponsor() {
		return sponsor;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getSignPeople() {
		return signPeople;
	}
	public void setSignPeople(String signPeople) {
		this.signPeople = signPeople;
	}
	
	
}
