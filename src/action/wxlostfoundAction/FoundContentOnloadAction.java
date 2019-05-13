package action.wxlostfoundAction;

import java.util.HashMap;

import org.apache.struts2.ServletActionContext;

import dao.FoundDAO;
import dao.UserInfoDAO;
import entity.Found;
import entity.UserInfo;
import factory.DAOFactory;

public class FoundContentOnloadAction {
	HashMap<String,String> map=new HashMap<>();
	public String execute() {
		String fno=ServletActionContext.getRequest().getParameter("fno");
		FoundDAO founddao=(FoundDAO) DAOFactory.getInstance("FoundDAO");
		UserInfoDAO userdao=(UserInfoDAO) DAOFactory.getInstance("UserInfoDAO");
		Found l=null;
		UserInfo user=null;
		try {
			l=founddao.findNotSolved(fno);
			if(l==null)
				map.put("flag", "0");
			else {
				map.put("flag", "1");
				user=userdao.find(l.getPublisherNo());
				map.put("tel", user.getTel());
				map.put("email", user.getEmail());
				map.put("time", l.getPublisherTime());
				map.put("describe", l.getDescribe());
				map.put("photo", l.getPhoto());
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
