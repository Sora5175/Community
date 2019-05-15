package action.wxAction;
import java.util.List;

import dao.AnswerDAO;
import entity.Answer;
import factory.DAOFactory;
public class AnswergetAction {
	int aNo;
	String content;
	String qdescribe;
	int qNo;
	String qt;
	String responderNo;
	String responderName;
	String responderTime;
	int upVotedNum;
	int downVotedNum;
	String isAdopted;
	String isExist;
	List<Answer> answerList;
	public String execute() {
		AnswerDAO a = (AnswerDAO)DAOFactory.getInstance("AnswerDAO");
		String s = String.valueOf(qNo);
		try {
			answerList = a.findqa(s);

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
	public String getQdescribe() {
		return qdescribe;
	}
	public void setQdescribe(String qdescribe) {
		this.qdescribe = qdescribe;
	}
	public int getQNo() {
		return qNo;
	}
	public void setQNo(int qNo) {
		this.qNo = qNo;
	}
	public String getQt() {
		return qt;
	}
	public void setQt(String qt) {
		this.qt = qt;
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
	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
}
