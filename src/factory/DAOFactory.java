package factory;

import util.ConfigUtil;

public class DAOFactory {
	//ͨ��type�ӿڷ�������õ���
	public static Object getInstance(String type) { 
		Object obj = null;
		String classname = ConfigUtil.getValue(type);
		try {
			obj = Class.forName(classname).newInstance();	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return obj;
	}
}
