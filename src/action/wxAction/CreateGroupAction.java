package action.wxAction;

import dao.GroupDAO;
import dao.GroupUserDAO;
import entity.Group;
import entity.GroupUser;
import factory.DAOFactory;

public class CreateGroupAction {
	String groupName;
	String groupContent;
	String uId;
	String needNumber;
	String alternateNumber;
	boolean pass = false;
	public String execute() {
		GroupDAO g = (GroupDAO)DAOFactory.getInstance("GroupDAO");
		Group group = new Group(0,groupName,groupContent,uId,Integer.parseInt(needNumber),Integer.parseInt(alternateNumber),"1");
		GroupUserDAO gU = (GroupUserDAO)DAOFactory.getInstance("GroupUserDAO");
		try {
			g.add(group);
			long gId = g.getMaxId();
			gU.add(new GroupUser(gId,uId, "0", "1"));
			pass = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupContent() {
		return groupContent;
	}
	public void setGroupContent(String groupContent) {
		this.groupContent = groupContent;
	}
	public String getUId() {
		return uId;
	}
	public void setUId(String uId) {
		this.uId = uId;
	}
	public String getNeedNumber() {
		return needNumber;
	}
	public void setNeedNumber(String needNumber) {
		this.needNumber = needNumber;
	}
	public String getAlternateNumber() {
		return alternateNumber;
	}
	public void setAlternateNumber(String alternateNumber) {
		this.alternateNumber = alternateNumber;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
}
