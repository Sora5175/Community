package action.wxlostfoundAction;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import dao.NoticeFoundDAO;
import entity.NoticeFound;
import factory.DAOFactory;
import util.BeanUtil;

public class getLostUploadWithoutPicAction {
	Boolean confirm=true;
	public String execute() {
		HttpServletRequest req=ServletActionContext.getRequest();
		String lostloc=req.getParameter("lostloc");
		String lostname=req.getParameter("lostname");
		String color=req.getParameter("color");
		String losttype=req.getParameter("type");
		String publisherno=req.getParameter("uid");
		String fno=req.getParameter("fno");
		String losttime=req.getParameter("time");
		NoticeFoundDAO dao=(NoticeFoundDAO) DAOFactory.getInstance("NoticeFoundDAO");
		NoticeFound nf=new NoticeFound();
		nf.setfNo(fno);
		nf.setLostName(lostname);
    	nf.setColor(color);
    	nf.setType(losttype);
		nf.setId(UUID.randomUUID().toString());
		nf.setLostLoc(lostloc);
		nf.setLostTime(losttime);
		nf.setPublisherId(publisherno);
		nf.setTime(BeanUtil.getNow());
		try {
			dao.add(nf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			confirm=false;
			e.printStackTrace();
		}
		return "success";
	}
	public Boolean getConfirm() {
		return confirm;
	}
	public void setConfirm(Boolean confirm) {
		this.confirm = confirm;
	}
	
}
