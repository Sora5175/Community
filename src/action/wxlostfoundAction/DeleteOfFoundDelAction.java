package action.wxlostfoundAction;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import dao.NoticeFoundDAO;
import factory.DAOFactory;

public class DeleteOfFoundDelAction {
	Boolean flag = true;
	public String execute() {
		HttpServletRequest req=ServletActionContext.getRequest();
		String id=req.getParameter("id");
		NoticeFoundDAO dao=(NoticeFoundDAO) DAOFactory.getInstance("NoticeFoundDAO");
		try {
			dao.del(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag=false;
		}
		return "success";
	}
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
}
