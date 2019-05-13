package action.testAction;

import java.util.Map;
import action.BaseAction;
import util.pythonUtil;

public class CheckLoginAction extends BaseAction{
	String username;
	String password;
	String check;
	String html;
	public String execute(){
		String host = "http://202.119.160.5/";
		Map<String,String> value = (Map<String, String>) session.get("map");
		html = pythonUtil.get(host, value, username, password, check);
		return "success";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
}
