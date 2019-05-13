package action;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

public class BaseAction implements SessionAware,CookiesAware, ServletResponseAware ,ServletRequestAware{
	//模拟session cookie response request
	public Map<String, Object> session;
	public Map<String, String> cookies;
	public HttpServletResponse response;
	public HttpServletRequest request;
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setCookiesMap(Map<String, String> cookies) {
		this.cookies = cookies;
	}

}
