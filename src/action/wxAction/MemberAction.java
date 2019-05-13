package action.wxAction;

import dao.GroupDAO;
import dao.GroupUserDAO;
import entity.Group;
import entity.GroupUser;
import factory.DAOFactory;

public class MemberAction {
	String gId;
	String uId;
	String isUp;
	String isRemove;
	boolean pass = false;
	String message = "操作失败";
	public String execute() {
		GroupUserDAO gu = (GroupUserDAO)DAOFactory.getInstance("GroupUserDAO");
		GroupDAO g = (GroupDAO)DAOFactory.getInstance("GroupDAO");
		try {
			GroupUser groupUser = gu.find(Long.parseLong(gId),uId);
			Group group = g.find(gId);
			if(isRemove.equals("true")) {
				groupUser.setIsExist("0");
				gu.update(groupUser);
				message = "操作成功";
				pass = true;
			}else if(isUp.equals("true")) {
				if(group.getNeedNumber()>gu.findAllNotAlternate(Long.parseLong(gId)).size()) {
					groupUser.setIsAlternate("0");
					gu.update(groupUser);
					message = "操作成功";
					pass = true;
				}
			}else{
				if(group.getAlternateNumber()>gu.findAllAlternate(Long.parseLong(gId)).size()) {
					groupUser.setIsAlternate("1");
					gu.update(groupUser);
					message = "操作成功";
					pass = true;
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
	public String getUId() {
		return uId;
	}
	public void setUId(String uId) {
		this.uId = uId;
	}
	public String getIsUp() {
		return isUp;
	}
	public void setIsUp(String isUp) {
		this.isUp = isUp;
	}
	public String getIsRemove() {
		return isRemove;
	}
	public void setIsRemove(String isRemove) {
		this.isRemove = isRemove;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
