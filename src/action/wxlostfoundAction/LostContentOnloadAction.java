package action.wxlostfoundAction;

import java.util.HashMap;

import org.apache.struts2.ServletActionContext;

import dao.ClassroomDAO;
import dao.LostDAO;
import dao.UserInfoDAO;
import entity.Lost;
import entity.UserInfo;
import factory.DAOFactory;

public class LostContentOnloadAction {
	HashMap<String,String> map=new HashMap<>();
	public String execute() {
		String lno=ServletActionContext.getRequest().getParameter("lno");
		LostDAO lostdao=(LostDAO) DAOFactory.getInstance("LostDAO");
		UserInfoDAO userdao=(UserInfoDAO) DAOFactory.getInstance("UserInfoDAO");
		ClassroomDAO locdao=(ClassroomDAO)DAOFactory.getInstance("ClassroomDAO");
		Lost l=null;
		UserInfo user=null;
		try {
			l=lostdao.findNotSolved(lno);
			if(l==null)
				map.put("flag", "0");
			else {
				map.put("flag", "1");
				user=userdao.find(l.getPublisherNo());
				map.put("tel", user.getTel());
				map.put("email", user.getEmail());
				map.put("time", l.getPublisherTime());
				map.put("describe", l.getDescribe());
				map.put("location", locdao.find(l.getLostLocation()).getClassroomName());
				if(l.getPhoto()!=null)
					map.put("photo", l.getPhoto());
				else
					map.put("photo", "none.PNG");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public HashMap<String, String> getMap() {
		return map;
	}
	public void setMap(HashMap<String, String> map) {
		this.map = map;
	}
	
}
