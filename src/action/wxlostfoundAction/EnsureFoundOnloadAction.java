package action.wxlostfoundAction;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import dao.ClassroomDAO;
import dao.NoticeFoundDAO;
import dao.UserInfoDAO;
import entity.NoticeFound;
import entity.UserInfo;
import factory.DAOFactory;

public class EnsureFoundOnloadAction {
	List<NoticeFound> list;
	public String execute() {
		HttpServletRequest req=ServletActionContext.getRequest();
		String uid=req.getParameter("uid");
		String index=req.getParameter("index");
		NoticeFoundDAO dao=(NoticeFoundDAO) DAOFactory.getInstance("NoticeFoundDAO");
		UserInfoDAO userdao=(UserInfoDAO) DAOFactory.getInstance("UserInfoDAO");
		ClassroomDAO roomdao=(ClassroomDAO) DAOFactory.getInstance("ClassroomDAO");
		NoticeFound obj=null;
		UserInfo user=null;
		try {
			list=dao.LoadByTime(uid, index);
			for(int i=0;i<list.size();i++) {
				obj=list.get(i);
				user=userdao.find(obj.getPublisherId());
				obj.setPublisherId(user.getName());
				obj.setLostLoc(roomdao.find(obj.getLostLoc()).getClassroomName());
				obj.setTime(user.getTel());
				if(obj.getPic()==null) {
					obj.setPic("none.PNG");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public List<NoticeFound> getList() {
		return list;
	}
	public void setList(List<NoticeFound> list) {
		this.list = list;
	}
	
}
