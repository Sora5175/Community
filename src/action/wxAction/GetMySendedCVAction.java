package action.wxAction;

import java.util.ArrayList;
import java.util.List;

import dao.CVDAO;
import dao.GroupDAO;
import entity.CV;
import entity.Group;
import factory.DAOFactory;

public class GetMySendedCVAction {
	String uId;
	List<Group> groupList = new ArrayList<Group>();
	List<CV> CVList = new ArrayList<CV>();
	public String execute() {
		CVDAO c = (CVDAO)DAOFactory.getInstance("CVDAO");
		GroupDAO g = (GroupDAO)DAOFactory.getInstance("GroupDAO");
		try {
			CVList = c.findAllByUId(uId);
			for(CV cv:CVList) {
				groupList.add(g.find(cv.getgId()+""));
			}
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
	public List<CV> getCVList() {
		return CVList;
	}
	public void setCVList(List<CV> cVList) {
		CVList = cVList;
	}
}
