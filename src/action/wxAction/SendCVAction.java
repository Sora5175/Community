package action.wxAction;

import dao.CVDAO;
import entity.CV;
import factory.DAOFactory;

public class SendCVAction {
	String gId;
	String uId;
	boolean pass = false;
	public String execute() {
		long groupId = Long.parseLong(gId);
		CVDAO c = (CVDAO)DAOFactory.getInstance("CVDAO");
		try {
			c.add(new CV(0, groupId, uId, "0","1"));
			pass = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public String getGId() {
		return gId;
	}
	public void setGId(String gId) {
		this.gId = gId;
	}
	public String getUId() {
		return uId;
	}
	public void setUId(String uId) {
		this.uId = uId;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
	
}
