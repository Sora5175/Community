package util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	//��ȡCookie·��
	public static final String path = "/Community";
	//���Cookie
	public static void addCookie(String name,String value,int maxage,HttpServletResponse response) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name, URLEncoder.encode(value, "UTF-8"));
		c.setMaxAge(maxage);
		c.setPath(path);
		response.addCookie(c);
	}
	//ɾ��Cookie
	public static void delCookie(String name) {
		Cookie c = new Cookie(name, "");
		c.setMaxAge(0);
	}
	//����Cookie��������valueֵ
	public static String findCookie(HttpServletRequest request,String name) {
		Cookie[] cs = request.getCookies();
		if(cs != null) {
			for(Cookie c:cs) {
				if(c.getName().equals(name))
					return c.getValue();
			}
		}
		return null;
	}
}
