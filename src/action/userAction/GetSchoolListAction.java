package action.userAction;

import java.util.List;
import dao.SchoolDAO;
import entity.School;
import factory.DAOFactory;

public class GetSchoolListAction {
	List<School> schoolList;
	
	//返回所有的学校列表
	public String execute() {
		SchoolDAO s = (SchoolDAO)DAOFactory.getInstance("SchoolDAO");
		try {
			schoolList = s.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public List<School> getSchoolList() {
		return schoolList;
	}

	public void setSchoolList(List<School> schoolList) {
		this.schoolList = schoolList;
	}
	
	
}
