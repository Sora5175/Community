package action.userAction;

public class UserExitAction extends BaseAction{
	
	public String execute() {
		session.remove("username");
		return "success";
	}
}
