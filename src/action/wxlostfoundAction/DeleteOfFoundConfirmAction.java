package action.wxlostfoundAction;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import dao.FoundDAO;
import dao.NoticeFoundDAO;
import entity.Found;
import factory.DAOFactory;

public class DeleteOfFoundConfirmAction {
	Boolean flag = true;
	public String execute() {
		HttpServletRequest req=ServletActionContext.getRequest();
		String fno=req.getParameter("fno");
		NoticeFoundDAO dao=(NoticeFoundDAO) DAOFactory.getInstance("NoticeFoundDAO");
		FoundDAO founddao=(FoundDAO) DAOFactory.getInstance("FoundDAO");
		Found f=null;
		try {
			f=founddao.find(fno);
			f.setIsSolved(true);
			founddao.update(f);
			dao.deleteByFNo(fno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag=false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
