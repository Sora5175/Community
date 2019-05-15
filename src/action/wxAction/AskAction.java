package action.wxAction;


import dao.QuestionDAO;
import entity.Question;
import factory.DAOFactory;
import util.BeanUtil;

public class AskAction {
	int qNo;
	String content;
	String qdescribe;
	String publisherNo;
	String publisherTime;
	String isExist;
	String isSolved;
	boolean pass = false;
	public String execute() {
		QuestionDAO q = (QuestionDAO)DAOFactory.getInstance("QuestionDAO");
		System.out.println(content);
		try {
			Question question = new Question();
			question.setContent(content);
			question.setQdescribe(qdescribe);
			question.setPublisherNo(publisherNo); 
			question.setPublisherTime(BeanUtil.getNow());
			question.setIsExist("1");
			question.setIsSolved("0");
			q.add(question);
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
	public String getPublisherNo() {
		return publisherNo;
	}
	public void setPublisherNo(String publisherNo) {
		this.publisherNo = publisherNo;
	}
	public String getPublisherTime() {
		return publisherTime;
	}
	public void setPublisherTime(String publisherTime) {
		this.publisherTime = publisherTime;
	}
	public String getIsExist() {
		return isExist;
	}
	public void setIsExist(String isExist) {
		this.isExist = isExist;
	}
	public String getIsSolved() {
		return isSolved;
	}
	public void setIsSolved(String isSolved) {
		this.isSolved = isSolved;
	}
	public boolean isPass() {
		return pass;
	}
	public void setPass(boolean pass) {
		this.pass = pass;
	}
}
