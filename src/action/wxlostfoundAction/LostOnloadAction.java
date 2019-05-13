package action.wxlostfoundAction;


import java.util.List;

import org.apache.struts2.ServletActionContext;
import util.BeanUtil;
import dao.LostDAO;
import entity.Lost;
import factory.DAOFactory;

public class LostOnloadAction {
	List<Lost> list;
	Boolean isMore=true;
	public String execute() {
		int size=Integer.parseInt(ServletActionContext.getRequest().getParameter("size"));
		int index=Integer.parseInt(ServletActionContext.getRequest().getParameter("index"));
		LostDAO dao=(LostDAO) DAOFactory.getInstance("LostDAO");
		Lost l=null;
		try {
			list=dao.queryByTime(index, size);
			if(list.size()==0)
				isMore=false;
			for(int i=0;i<list.size();i++) {
				l=list.get(i);
				if(l.getPhoto()==null)
					l.setPhoto("none.PNG");
				l.setPublisherTime(BeanUtil.subTime(l.getPublisherTime()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public List<Lost> getList() {
		return list;
	}

	public void setList(List<Lost> list) {
		this.list = list;
	}

	public Boolean getIsMore() {
		return isMore;
	}

	public void setIsMore(Boolean isMore) {
		this.isMore = isMore;
	}
}
