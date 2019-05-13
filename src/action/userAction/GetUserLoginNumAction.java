package action.userAction;

import java.util.Date;
import dao.LoginRecordDAO;
import factory.DAOFactory;
import util.BeanUtil;

public class GetUserLoginNumAction {
	String[] timeDataStr;
	int[] userLoginNum;
	
	/*获取时间列表json字符串
	 * 返回其对应的登录次数列表
	 */
	public String execute() {
		userLoginNum = new int[timeDataStr.length];
		LoginRecordDAO l = (LoginRecordDAO)DAOFactory.getInstance("LoginRecordDAO");
		try {
			for(int i=0;i<timeDataStr.length;i++) {
				Date d = BeanUtil.changeToDate(timeDataStr[i]);
				userLoginNum[i] = l.getInfoByTime(d).size();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "success";
	}
	public String[] getTimeDataStr() {
		return timeDataStr;
	}
	public void setTimeDataStr(String[] timeDataStr) {
		this.timeDataStr = timeDataStr;
	}
	public int[] getUserLoginNum() {
		return userLoginNum;
	}
	public void setUserLoginNum(int[] userLoginNum) {
		this.userLoginNum = userLoginNum;
	}
	
}
