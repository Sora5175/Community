package action.wxAction;

import java.util.ArrayList;
import java.util.List;

import dao.CVDAO;
import dao.UserInfoDAO;
import entity.CV;
import entity.UserInfo;
import factory.DAOFactory;

public class GetCVSListAction {
	String gId;
	List<CV> CVSList = new ArrayList<CV>();
	List<UserInfo> userInfoList = new ArrayList<UserInfo>();
	boolean pass = false;
	public String execute() {
		long groupId = Long.parseLong(gId);
		CVDAO c = (CVDAO)DAOFactory.getInstance("CVDAO");
		UserInfoDAO u = (UserInfoDAO)DAOFactory.getInstance("UserInfoDAO");
		try {
			CVSList = c.findAllByGIdNotChecked(groupId);
			for(CV cv:CVSList) {
				userInfoList.add(u.find(cv.getuId()));
			}
			pass = true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public String getGId() {
		return gId;
	}
	public void setGId(String gId) {
		this.gId = gId;
	}
	public List<CV> getCVSList() {
		return CVSList;
	}
	public void setCVSList(List<CV> cVSList) {
		CVSList = cVSList;
	}
	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}
	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
}
