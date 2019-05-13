package action.wxAction;

import dao.CVDAO;
import dao.GroupDAO;
import dao.GroupUserDAO;
import entity.CV;
import entity.Group;
import entity.GroupUser;
import factory.DAOFactory;

public class CVAction {
	String cId;
	String accept;
	boolean pass = false;
	String message = "操作失败";
	public String execute() {
		CVDAO c = (CVDAO)DAOFactory.getInstance("CVDAO");
		GroupUserDAO gu = (GroupUserDAO)DAOFactory.getInstance("GroupUserDAO");
		GroupDAO g = (GroupDAO)DAOFactory.getInstance("GroupDAO");
		if(accept.equals("true")) {
			try {
				CV cv = c.find(cId);
				Group group = g.find(cv.getgId()+"");
				if(group.getAlternateNumber()>gu.findAllAlternate(group.getgId()).size()) {
					cv.setIsChecked("1");
					c.update(cv);
					gu.add(new GroupUser(cv.getgId(), cv.getuId(), "1", "1"));
					message = "已成为团队候补";
				}else if(group.getNeedNumber()>gu.findAllNotAlternate(group.getgId()).size()) {
					cv.setIsChecked("1");
					c.update(cv);
					gu.add(new GroupUser(cv.getgId(), cv.getuId(), "0", "1"));
					message = "已成为团队正选";
				}else {
					message = "团队成员已满";
				}
				pass = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			try {
				CV cv = c.find(cId);
				cv.setIsChecked("1");
				c.update(cv);
				pass = true;
				message = "已退回该简历";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "success";
	}
	public String getCId() {
		return cId;
	}
	public void setCId(String cId) {
		this.cId = cId;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
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
