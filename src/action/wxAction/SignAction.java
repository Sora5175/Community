package action.wxAction;

import java.util.Date;

import dao.SignDAO;
import entity.Sign;
import factory.DAOFactory;

public class SignAction {
	String uId;
	String planId;
	Date signInTime;
	boolean success = false;
	boolean timeout = false;
	
	public String execute() {
		Date now = new Date();
		int interval = (int)((now.getTime()-signInTime.getTime())/1000+1);
		if(interval>60) {
			timeout = true;
		}else {
			Sign sign = new Sign(uId, planId, signInTime, "1");
			SignDAO s = (SignDAO)DAOFactory.getInstance("SignDAO");
			try {
				s.add(sign);
				success = true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "success";
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
		return signInTime;
	}

	public void setSignInTime(Date signInTime) {
		this.signInTime = signInTime;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isTimeout() {
		return timeout;
	}

	public void setTimeout(boolean timeout) {
		this.timeout = timeout;
	}
	
}
