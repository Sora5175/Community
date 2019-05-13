package action.wxAction;

import java.util.ArrayList;
import java.util.List;

import dao.GroupDAO;
import dao.GroupUserDAO;
import entity.Group;
import entity.GroupUser;
import factory.DAOFactory;

public class GetMyGroupListAction {
	String uId;
	List<Group> groupList = new ArrayList<Group>();
	List<Boolean> isFull = new ArrayList<Boolean>();
	List<Boolean> isOwner = new ArrayList<Boolean>();
	public String execute() {
		GroupDAO g = (GroupDAO)DAOFactory.getInstance("GroupDAO");
		GroupUserDAO gu = (GroupUserDAO)DAOFactory.getInstance("GroupUserDAO");
		try {
			for(GroupUser groupUser:gu.findAll(uId)) {
				groupList.add(g.find(groupUser.getgId()+""));
			}
			for(Group group:groupList) {
				isFull.add(group.getAlternateNumber()<=gu.findAllAlternate(group.getgId()).size()
						&&group.getNeedNumber()<=gu.findAllNotAlternate(group.getgId()).size());
				isOwner.add(group.getuId().equals(uId));
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
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public List<Boolean> getIsFull() {
		return isFull;
	}
	public void setIsFull(List<Boolean> isFull) {
		this.isFull = isFull;
	}
	public List<Boolean> getIsOwner() {
		return isOwner;
	}
	public void setIsOwner(List<Boolean> isOwner) {
		this.isOwner = isOwner;
	}
}
