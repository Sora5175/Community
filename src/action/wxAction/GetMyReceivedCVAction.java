package action.wxAction;

import java.util.ArrayList;
import java.util.List;

import dao.CVDAO;
import dao.GroupDAO;
import entity.Group;
import factory.DAOFactory;

public class GetMyReceivedCVAction {
	String uId;
	List<Group> groupList;
	List<Integer> CVNumber = new ArrayList<Integer>();
	boolean pass = false;
	public String execute() {
		GroupDAO g = (GroupDAO)DAOFactory.getInstance("GroupDAO");
		CVDAO c = (CVDAO)DAOFactory.getInstance("CVDAO");
		try {
			groupList = g.findAll(uId);
			for(Group group:groupList) {
				CVNumber.add(c.findAllByGIdNotChecked(group.getgId()).size());
			}
			pass = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public String getUId() {
		return uId;
	}
	public void setUId(String uId) {
		this.uId = uId;
	}
	public List<Group> getGroupList() {
		return groupList;
	}
	public void setGroupList(List<Group> groupList) {
		this.groupList = groupList;
	}
	public List<Integer> getCVNumber() {
		return CVNumber;
	}
	public void setCVNumber(List<Integer> cVNumber) {
		CVNumber = cVNumber;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
}
