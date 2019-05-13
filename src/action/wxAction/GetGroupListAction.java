package action.wxAction;

import java.util.ArrayList;
import java.util.List;

import dao.CVDAO;
import dao.GroupDAO;
import dao.GroupUserDAO;
import dao.UserInfoDAO;
import entity.Group;
import entity.UserInfo;
import factory.DAOFactory;

public class GetGroupListAction {
	String uId;
	List<Group> groupList = new ArrayList<Group>();
	List<UserInfo> groupPublisher = new ArrayList<UserInfo>();
	List<Boolean> isSended = new ArrayList<Boolean>();
	boolean pass = false;
	public String execute() {
		GroupDAO g = (GroupDAO)DAOFactory.getInstance("GroupDAO");
		GroupUserDAO gu = (GroupUserDAO)DAOFactory.getInstance("GroupUserDAO");
		UserInfoDAO u = (UserInfoDAO)DAOFactory.getInstance("UserInfoDAO");
		CVDAO c = (CVDAO)DAOFactory.getInstance("CVDAO");
		try {
			for(Group group:g.findAll()) {
				if(gu.find(group.getgId(), uId)==null&&!
					(group.getAlternateNumber()<=gu.findAllAlternate(group.getgId()).size()&&
					group.getNeedNumber()<=gu.findAllNotAlternate(group.getgId()).size())) {
					groupList.add(g.find(group.getgId()+""));
				}
			}
			for(Group group:groupList) {
				groupPublisher.add(u.find(group.getuId()));
				isSended.add(c.findByGIdUId(group.getgId(), uId)!=null);
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
	public List<UserInfo> getGroupPublisher() {
		return groupPublisher;
	}
	public void setGroupPublisher(List<UserInfo> groupPublisher) {
		this.groupPublisher = groupPublisher;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
	public List<Boolean> getIsSended() {
		return isSended;
	}
	public void setIsSended(List<Boolean> isSended) {
		this.isSended = isSended;
	}
}
