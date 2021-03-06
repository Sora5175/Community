package action.userAction;

import java.util.List;
import dao.UserInfoDAO;
import entity.UserInfo;
import factory.DAOFactory;

public class GetUserInfoListAction {
	private String currentPage;
	private String pageSize;
	private List<UserInfo> userInfoList;
	private int pageTotalNum;
	
	/*获得当前页和显示行
	 * 返回总页数以及用户信息表
	 */
	public String execute() {
		int pagesize = Integer.parseInt(pageSize);
		int currentpage = Integer.parseInt(currentPage);
		try {
			UserInfoDAO userInfo = (UserInfoDAO)DAOFactory.getInstance("UserInfoDAO");
			userInfoList = userInfo.pageDiv(currentpage, pagesize);
			int resultNum = userInfo.findAll().size();
			pageTotalNum = resultNum%pagesize==0?resultNum/pagesize:resultNum/pagesize+1;
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}
	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}
	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}
	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}
	public int getPageTotalNum() {
		return pageTotalNum;
	}
	public void setPageTotalNum(int pageTotalNum) {
		this.pageTotalNum = pageTotalNum;
	}
	
	
}
