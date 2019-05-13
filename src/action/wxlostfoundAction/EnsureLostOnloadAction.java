package action.wxlostfoundAction;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import dao.ClassroomDAO;
import dao.NoticeLostDAO;
import dao.UserInfoDAO;
import entity.NoticeLost;
import entity.UserInfo;
import factory.DAOFactory;

public class EnsureLostOnloadAction {
	List<NoticeLost> list;
	public String execute() {
		HttpServletRequest req=ServletActionContext.getRequest();
		String uid=req.getParameter("uid");
		String index=req.getParameter("index");
		NoticeLostDAO dao=(NoticeLostDAO) DAOFactory.getInstance("NoticeLostDAO");
		UserInfoDAO userdao=(UserInfoDAO) DAOFactory.getInstance("UserInfoDAO");
		ClassroomDAO roomdao=(ClassroomDAO) DAOFactory.getInstance("ClassroomDAO");
		NoticeLost obj=null;
		UserInfo user=null;
		try {
			list=dao.LoadByTime(uid, index);
			for(int i=0;i<list.size();i++) {
				obj=list.get(i);
				user=userdao.find(obj.getPublisherId());
				obj.setPublisherId(user.getName());
				obj.setReturnLoc(roomdao.find(obj.getReturnLoc()).getClassroomName());
				obj.setTime(user.getTel());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public List<NoticeLost> getList() {
		return list;
	}
	public void setList(List<NoticeLost> list) {
		this.list = list;
	}
	
}
