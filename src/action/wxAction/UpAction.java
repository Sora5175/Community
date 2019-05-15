package action.wxAction;


import dao.AnswerDAO;
import entity.Answer;
import factory.DAOFactory;


public class UpAction {
	int aNo;
	String content;
	int qNo;
	String responderNo;
	String responderTime;
	int upVotedNum;
	int downVotedNum;
	String isAdopted;
	String isExist;
	boolean pass = false;
	public String execute() {
		AnswerDAO a = (AnswerDAO)DAOFactory.getInstance("AnswerDAO");
		System.out.println(upVotedNum);
		System.out.println(aNo);
		try {
			Answer answer = new Answer();
			answer.setANo(aNo);
			answer.setContent("");
			answer.setQNo(0);
			answer.setResponderNo("");
			answer.setResponderTime("");
			answer.setUpVotedNum(upVotedNum);
			answer.setDownVotedNum(0);
			answer.setIsAdopted("");
			answer.setIsExist("");
			a.up(answer);
			pass = true;
			System.out.println(pass);
		}catch (Exception e) {
		e.printStackTrace();
	}
	return "success";
		}
	public int getANo() {
		return aNo;
	}
	public void setANo(int aNo) {
		this.aNo = aNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getQNo() {
		return qNo;
	}
	public void setQNo(int qNo) {
		this.qNo = qNo;
	}
	public String getResponderNo() {
		return responderNo;
	}
	public void setResponderNo(String responderNo) {
		this.responderNo = responderNo;
	}
	public String getResponderTime() {
		return responderTime;
	}
	public void setResponderTime(String responderTime) {
		this.responderTime = responderTime;
	}
	public int getUpVotedNum() {
		return upVotedNum;
	}
	public void setUpVotedNum(int upVotedNum) {
		this.upVotedNum = upVotedNum;
	}
	public int getDownVotedNum() {
		return downVotedNum;
	}
	public void setDownVotedNum(int downVotedNum) {
		this.downVotedNum = downVotedNum;
	}
	public String getIsAdopted() {
		return isAdopted;
	}
	public void setIsAdopted(String isAdopted) {
		this.isAdopted = isAdopted;
	}
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
}
