package action.wxlostfoundAction;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import dao.LostDAO;
import dao.NoticeLostDAO;
import entity.Lost;
import factory.DAOFactory;

public class DeleteOfConfirmAction {
	Boolean flag = true;
	public String execute() {
		HttpServletRequest req=ServletActionContext.getRequest();
		String lno=req.getParameter("lno");
		NoticeLostDAO dao=(NoticeLostDAO) DAOFactory.getInstance("NoticeLostDAO");
		LostDAO lostdao=(LostDAO) DAOFactory.getInstance("LostDAO");
		try {
			dao.deleteByLNo(lno);
			Lost l=lostdao.find(lno);
			l.setIsSolved(true);
			lostdao.update(l);
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
