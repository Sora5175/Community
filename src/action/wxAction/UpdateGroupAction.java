package action.wxAction;

import dao.GroupDAO;
import dao.GroupUserDAO;
import entity.Group;
import factory.DAOFactory;

public class UpdateGroupAction {
	String gId;
	String name;
	String content;
	String needNumber;
	String alternateNumber;
	boolean pass = false;
	String message = "操作失败";
	public String execute() {
		GroupDAO g = (GroupDAO)DAOFactory.getInstance("GroupDAO");
		GroupUserDAO gu = (GroupUserDAO)DAOFactory.getInstance("GroupUserDAO");
		try {
			if(Integer.parseInt(alternateNumber)<=gu.findAllAlternate(Long.parseLong(gId)).size()
					&&Integer.parseInt(needNumber)<=gu.findAllNotAlternate(Long.parseLong(gId)).size()) {
				message = "当前团队人数大于修改数目";
			}else {
				Group group = g.find(gId);
				group.setContent(content);
				group.setName(name);
				group.setNeedNumber(Integer.parseInt(needNumber));
				group.setAlternateNumber(Integer.parseInt(alternateNumber));
				g.update(group);
				message = "修改成功";
				pass = true;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
