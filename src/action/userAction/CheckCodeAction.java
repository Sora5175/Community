package action.userAction;

import action.BaseAction;

public class CheckCodeAction extends BaseAction{
	String code_input;
	boolean flag = false;
	
	public String execute() {
		//从session中取得正确验证码
		String ConnectCode = (String) session.get("ConnectCode");
		if(code_input.equalsIgnoreCase(ConnectCode)){
			flag = true;
		}
		return "success";
	}
	
	public String getCode_input() {
		return code_input;
	}
	public void setCode_input(String code_input) {
		this.code_input = code_input;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
