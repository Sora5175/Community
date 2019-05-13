package action.wxAction;

import java.util.List;
import dao.GradeDAO;
import entity.Grade;
import factory.DAOFactory;

public class GetGradeListAction {
	String userDepartmentId;
	List<Grade> gradeList;
	
	/*获取用户院系Id
	 * 返回该院系Id以下的年级列表
	 */
	public String execute() {
		GradeDAO g = (GradeDAO)DAOFactory.getInstance("GradeDAO");
		try {
			gradeList = g.findAll(userDepartmentId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "success";
	}

	public String getUserDepartmentId() {
		return userDepartmentId;
	}

	public void setUserDepartmentId(String userDepartmentId) {
		this.userDepartmentId = userDepartmentId;
	}

	public List<Grade> getGradeList() {
		return gradeList;
	}

	public void setGradeList(List<Grade> gradeList) {
		this.gradeList = gradeList;
	}
	
	
}
