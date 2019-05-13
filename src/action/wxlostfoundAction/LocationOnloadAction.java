package action.wxlostfoundAction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import dao.ClassroomDAO;
import dao.UserInfoDAO;
import entity.Classroom;
import factory.DAOFactory;

public class LocationOnloadAction {
	List<Classroom> list;
	public String execute() {
		HttpServletRequest req=ServletActionContext.getRequest();
		String uid=req.getParameter("uid"),sid="";
		UserInfoDAO userdao=(UserInfoDAO) DAOFactory.getInstance("UserInfoDAO");
		ClassroomDAO roomdao=(ClassroomDAO) DAOFactory.getInstance("ClassroomDAO");
		try {
			sid=userdao.find(uid).getSchoolId();
			list=roomdao.valuesOfSchool(sid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public List<Classroom> getList() {
		return list;
	}
	public void setList(List<Classroom> list) {
		this.list = list;
	}
	
}
