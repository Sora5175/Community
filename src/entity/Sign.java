package entity;

import java.util.Date;

public class Sign {
	String uId;
	String planId;
	Date SignInTime;
	String IsExist;
	public Sign(String uId, String planId, Date signInTime, String isExist) {
		super();
		this.uId = uId;
		this.planId = planId;
		SignInTime = signInTime;
		IsExist = isExist;
	}
	public String getUId() {
		return uId;
	}
	public void setUId(String uId) {
		this.uId = uId;
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public Date getSignInTime() {
		return SignInTime;
	}
	public void setSignInTime(Date signInTime) {
		SignInTime = signInTime;
	}
	public String getIsExist() {
		return IsExist;
	}
	public void setIsExist(String isExist) {
		IsExist = isExist;
	}
	
}
