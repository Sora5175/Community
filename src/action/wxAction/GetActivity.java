package action.wxAction;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import dao.ActivityDAO;
import entity.Activity;
import factory.DAOFactory;


/*
 * @param name 活动已报名人员
 */
public class GetActivity {
	String name;
	List<Activity> list=null;
	public String execute() {
		//从微信端获取用户名
		ActivityDAO a = (ActivityDAO)DAOFactory.getInstance("ActivityDAO");
		try {
			list = a.findAllWithName(name);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Activity> getList() {
		return list;
	}
	public void setList(List<Activity> list) {
		this.list = list;
	}
	
}
