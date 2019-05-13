package action.userAction;

import java.util.Date;
import dao.UserInfoDAO;
import factory.DAOFactory;
import util.BeanUtil;

public class GetUserRegisterNumAction {
	String[] timeDataStr;
	int[] userRegisterNum;
	
	/*获取时间列表json字符串
	 * 返回其对应的注册次数列表
	 */
	public String execute() {
		userRegisterNum = new int[timeDataStr.length];
		UserInfoDAO l = (UserInfoDAO)DAOFactory.getInstance("UserInfoDAO");
		try {
			for(int i=0;i<timeDataStr.length;i++) {
				Date d = BeanUtil.changeToDate(timeDataStr[i]);
				userRegisterNum[i] = l.getInfoByTime(d).size();
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

	public int[] getUserRegisterNum() {
		return userRegisterNum;
	}

	public void setUserRegisterNum(int[] userRegisterNum) {
		this.userRegisterNum = userRegisterNum;
	}
	
	
}
