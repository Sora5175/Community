package action.wxAction;
import java.util.List;

import dao.AnswerDAO;
import entity.Answer;
import factory.DAOFactory;
public class UpgetAction {
	int aNo;
	String qt;
	String content;
	int qNo;
	String responderNo;
	String responderName;
	String responderTime;
	int upVotedNum;
	int downVotedNum;
	String isAdopted;
	String isExist;
	Answer up;
	public String execute() {
		AnswerDAO a = (AnswerDAO)DAOFactory.getInstance("AnswerDAO");
		String s = String.valueOf(aNo);
		try {
			up = a.find(s);
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
	public String getQt() {
		return qt;
	}
	public void setQt(String qt) {
		this.qt = qt;
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
	public String getResponderName() {
		return responderName;
	}
	public void setResponderName(String responderName) {
		this.responderName = responderName;
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
	public Answer getUp() {
		return up;
	}

	public void setUp(Answer up) {
		this.up = up;
	}
}
