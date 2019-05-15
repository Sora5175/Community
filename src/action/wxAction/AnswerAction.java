package action.wxAction;


import dao.AnswerDAO;
import entity.Answer;
import factory.DAOFactory;
import util.BeanUtil;

public class AnswerAction {
	int qNo;
	int aNo;
	String content;
	String responderNo;
	String responderTime;
	int upVotedNum;
	int downVotedNum;
	String isExist; 
	String isAdopted;
	boolean pass = false;
	public String execute() {
		AnswerDAO a = (AnswerDAO)DAOFactory.getInstance("AnswerDAO");
		System.out.println(content);
		try {
			Answer answer = new Answer();
			answer.setQNo(qNo);
			answer.setContent(content); 
			answer.setResponderNo(responderNo); 
			answer.setResponderTime(BeanUtil.getNow());
			answer.setUpVotedNum(0);
			answer.setDownVotedNum(0); 
			answer.setIsExist("1");
			answer.setIsAdopted("0"); 
			a.add(answer);
			pass = true;
			System.out.println(pass);
		}catch (Exception e) {
		e.printStackTrace();
	}
	return "success";
		}
	public int getQNo() {
		return qNo;
	}
	public void setQNo(int qNo) {
		this.qNo = qNo;
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
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
	public String getIsAdopted() {
		return isAdopted;
	}
	public void setIsSolved(String isAdopted) {
		this.isAdopted = isAdopted;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
}
