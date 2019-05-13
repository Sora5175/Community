package action.userAction;

import java.util.List;
import dao.ClassDAO;
import entity.Class;
import factory.DAOFactory;

public class GetClassListAction {
	String userGradeId;
	List<Class> classList;
	
	/*获取用户的年级Id
	 * 返回该年级Id以下的班级列表
	 */
	public String execute() {
		ClassDAO c = (ClassDAO)DAOFactory.getInstance("ClassDAO");
		try {
			classList = c.findAll(userGradeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public List<Class> getClassList() {
		return classList;
	}

	public void setClassList(List<Class> classList) {
		this.classList = classList;
	}
	public String getUserGradeId() {
		return userGradeId;
	}

	public void setUserGradeId(String userGradeId) {
		this.userGradeId = userGradeId;
	}
}
