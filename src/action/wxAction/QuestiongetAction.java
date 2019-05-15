package action.wxAction;
import java.util.List;

import dao.QuestionDAO;
import entity.Question;
import factory.DAOFactory;
public class QuestiongetAction {
	String qinput;
	int aNo;
	int qNo;
	String qt;
	String at;
	int upVotedNum;
	int downVotedNum;
	List<Question> questionList;
	public String execute() {
		QuestionDAO a = (QuestionDAO)DAOFactory.getInstance("QuestionDAO");

		try {
			questionList = a.search(qinput);
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
	
	public String getQinput() {
		return qinput;
	}
	public void setQinput(String qinput) {
		this.qinput = qinput;
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
	public String getAt() {
		return at;
	}
	public void setAt(String at) {
		this.at = at;
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
	public List<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

}
