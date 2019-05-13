package interceptor;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import util.CookieUtil;

public class LoginInterceptor implements Interceptor {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void init() {
		// TODO Auto-generated method stub
	}

	//拦截非法访问
	public String intercept(ActionInvocation ai) throws Exception {
		//获取session中的登录信息
		Map<String,Object> session = ActionContext.getContext().getSession();
		Object obj = session.get("username");
		//sesion中不存在登录信息
		if(obj == null) {
			//cookie中查找登录信息
			HttpServletRequest request = ServletActionContext.getRequest();
			String value = CookieUtil.findCookie(request, "username");
			//cookie中也不存在登录信息
			if(value == null) {
				//登录失败，返回拦截字符串
				return "java/interceptor";
			}else {
				//cookie中存在，登录成功	
				ai.invokeActionOnly();
				return "success";
			}
		}else {
			//session中存在，登录成功
			ai.invokeActionOnly();
			return "success";
		}
	}
}
