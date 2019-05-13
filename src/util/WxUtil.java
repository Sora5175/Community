package util;

import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONObject;

public class WxUtil {
	public static Map<String, String> getLogin(String code){
		Map<String,String> getLogin = new HashMap<String, String>();
		String WX_URL = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
		String requestUrl = WX_URL.replace("APPID", "wx2519a52f42bf9ce7").//填写自己的appid
				replace("SECRET", "bd89462ffd1d917faa84a18211aa3819").replace("JSCODE", code).//填写自己的appsecret，
				replace("authorization_code", "authorization_code");
		String  returnValue=GET(requestUrl);
		//定义一个json对象。 
		JSONObject convertValue=new JSONObject();
		//将得到的字符串转换为json
		convertValue=JSONObject.fromObject(returnValue);
		//把openid和sessionkey分别赋值给openid和sessionkey
		String openId=(String) convertValue.get("openid");
		String sessionKey = (String) convertValue.get("session_key");//定义两个变量存储得到的openid和session_key.
	    getLogin.put("openId", openId);
	    getLogin.put("sessionKey", sessionKey);
	    return getLogin;
	}

	public static String GET(String url) {
		String result = "";
		BufferedReader in = null;
		InputStream is = null;
		InputStreamReader isr = null;
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.connect();
			is = conn.getInputStream();
			isr = new InputStreamReader(is);
			in = new BufferedReader(isr);
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			// 异常记录
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (is != null) {
					is.close();
				}
				if (isr != null) {
					isr.close();
				}
			} catch (Exception e2) {
				// 异常记录
			}
		}
		return result;
	}
}
