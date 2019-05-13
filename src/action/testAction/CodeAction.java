package action.testAction;
import java.io.InputStream;
import java.util.Map;

import action.BaseAction;
import util.pythonUtil;

public class CodeAction extends BaseAction{
	InputStream ins;
	public String execute() {
		String host = "http://202.119.160.5/";
		Map<String, String> value = pythonUtil.getValue(host);
		ins = pythonUtil.getCodeImg(host, value.get("cookie"));
		session.put("map", value);
		return "success";
	}
	public InputStream getIns() {
		return ins;
	}
	public void setIns(InputStream ins) {
		this.ins = ins;
	}
}
