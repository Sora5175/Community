package action.wxAction;

import java.util.ArrayList;
import java.util.List;

import dao.GroupUserDAO;
import dao.UserInfoDAO;
import entity.GroupUser;
import entity.UserInfo;
import factory.DAOFactory;

public class GetMemberListAction {
	String gId;
	List<UserInfo> memberList = new ArrayList<UserInfo>();
	List<UserInfo> alternateMemberList = new ArrayList<UserInfo>();
	public String execute() {
		GroupUserDAO gu = (GroupUserDAO)DAOFactory.getInstance("GroupUserDAO");
		UserInfoDAO u = (UserInfoDAO)DAOFactory.getInstance("UserInfoDAO");
		try {
			for(GroupUser groupUser:gu.findAllByGId(Long.parseLong(gId))) {
				if(groupUser.getIsAlternate().equals("0")) {
					memberList.add(u.find(groupUser.getuId()));
				}else {
					alternateMemberList.add(u.find(groupUser.getuId()));
				}
			}
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
	public List<UserInfo> getMemberList() {
		return memberList;
	}
	public void setMemberList(List<UserInfo> memberList) {
		this.memberList = memberList;
	}
	public List<UserInfo> getAlternateMemberList() {
		return alternateMemberList;
	}
	public void setAlternateMemberList(List<UserInfo> alternateMemberList) {
		this.alternateMemberList = alternateMemberList;
	}
}
