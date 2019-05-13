package util;

import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
	//��properties�ļ��ж�ȡ����
	static Properties p = new Properties();
	static {
		ClassLoader loader = ConfigUtil.class.getClassLoader();
		InputStream in = loader.getResourceAsStream("daoConfig.properties");
		try {
			p.load(in);
		} catch (Exception e) {
			// TODO: handl exception
			e.printStackTrace();
		}
	}
	
	//��ȡĳһ������
	public static String getValue(String key) { 
		return p.getProperty(key);
	}
}
