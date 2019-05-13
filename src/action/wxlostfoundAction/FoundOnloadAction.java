package action.wxlostfoundAction;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import dao.FoundDAO;
import entity.Found;
import factory.DAOFactory;
import util.BeanUtil;

public class FoundOnloadAction {
	List<Found> list;
	Boolean isMore=true;
	public String execute() {
		int size=Integer.parseInt(ServletActionContext.getRequest().getParameter("size"));
		int index=Integer.parseInt(ServletActionContext.getRequest().getParameter("index"));
		FoundDAO dao=(FoundDAO) DAOFactory.getInstance("FoundDAO");
		Found f=null;
		try {
			list=dao.queryByTime(index, size);
			if(list.size()==0)
				isMore=false;
			for(int i=0;i<list.size();i++) {
				f=list.get(i);
				f.setPublisherTime(BeanUtil.subTime(f.getPublisherTime()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public List<Found> getList() {
		return list;
	}
	public void setList(List<Found> list) {
		this.list = list;
	}
	public Boolean getIsMore() {
		return isMore;
	}
	public void setIsMore(Boolean isMore) {
		this.isMore = isMore;
	}
	
}
