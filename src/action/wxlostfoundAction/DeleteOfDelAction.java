package action.wxlostfoundAction;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import dao.NoticeLostDAO;
import factory.DAOFactory;

public class DeleteOfDelAction {
	Boolean flag = true;
	public String execute() {
		HttpServletRequest req=ServletActionContext.getRequest();
		String id=req.getParameter("id");
		NoticeLostDAO dao=(NoticeLostDAO) DAOFactory.getInstance("NoticeLostDAO");
		try {
			dao.del(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
