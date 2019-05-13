package action.wxlostfoundAction;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import dao.FoundDAO;
import dao.LostDAO;
import dao.NoticeLostDAO;
import entity.Found;
import entity.Lost;
import entity.NoticeLost;
import factory.DAOFactory;
import util.BeanUtil;

public class LostUploadWithoutPicAction {
	Boolean confirm=true;
	public String execute() {
		HttpServletRequest req=ServletActionContext.getRequest();
		String lostname=req.getParameter("lostname");
		String lostlocation=req.getParameter("lostlocid");
		String describe=req.getParameter("describe");
		String publisherno=req.getParameter("uid");
		String losttype=req.getParameter("type");
		String lostdate=req.getParameter("time");
		String time=BeanUtil.getNow(),lno=UUID.randomUUID().toString();
		LostDAO lostdao=(LostDAO) DAOFactory.getInstance("LostDAO");
		Lost lost=new Lost();
		lost.setDescribe(describe);
    	lost.setlName(lostname);
    	lost.setlNo(lno);
    	lost.setLostLocation(lostlocation);
    	lost.setPublisherNo(publisherno);
    	lost.setPublisherTime(time);
    	lost.setType(losttype);
    	lost.setLostTime(lostdate);
    	
    	FoundDAO founddao=(FoundDAO) DAOFactory.getInstance("FoundDAO");
    	NoticeLostDAO noticelostdao=(NoticeLostDAO) DAOFactory.getInstance("NoticeLostDAO");
    	Found f=null;
    	NoticeLost obj=null;
    	List<Found> randomlist;
    	try {
			lostdao.lostAdd(lost);
			randomlist=founddao.randomReturn(lostlocation, lostdate, losttype, 3);
			for(int i=0;i<randomlist.size();i++) {
				f=randomlist.get(i);
				obj=new NoticeLost();
				obj.setId(UUID.randomUUID().toString());
				obj.setIsExist("1");
				obj.setlNo(lno);
				obj.setPic(f.getPhoto());
				obj.setPublisherId(f.getPublisherNo());
				obj.setReturnLoc(f.getReturnLocation());
				obj.setTime(f.getPublisherTime());
				noticelostdao.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
