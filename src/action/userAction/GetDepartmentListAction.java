package action.userAction;

import java.util.List;
import dao.DepartmentDAO;
import entity.Department;
import factory.DAOFactory;

public class GetDepartmentListAction {
	String userSchoolId;
	List<Department> departmentList;
	
	/*获取用户的学校Id
	 * 返回该学校Id以下的院系列表
	 */
	public String execute() {
		DepartmentDAO d = (DepartmentDAO)DAOFactory.getInstance("DepartmentDAO");
		try {
			departmentList = d.findAll(userSchoolId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	public String getUserSchoolId() {
		return userSchoolId;
	}
	
	public void setUserSchoolId(String userSchoolId) {
		this.userSchoolId = userSchoolId;
	}

	public List<Department> getDepartmentList() {
		return departmentList;
	}
	
	public void setDepartmentList(List<Department> departmentList) {
		this.departmentList = departmentList;
	}
	
	
}
