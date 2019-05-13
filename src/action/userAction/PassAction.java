package action.userAction;

import dao.UsersDAO;
import entity.Users;
import factory.DAOFactory;

public class PassAction {
	String Usersname;
	String pwd;
	boolean pass = false;
	/*获取输入的用户名和密码
	 * 返回pass：登录是否成功
	 */
	public String execute() {
		UsersDAO u = (UsersDAO)DAOFactory.getInstance("UsersDAO");
		Users Users = new Users(Usersname, pwd,"0","1");
		try {
			pass = u.pass(Users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String getUsersname() {
		return Usersname;
	}
	public void setUsersname(String Usersname) {
		this.Usersname = Usersname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
}
