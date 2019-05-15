package dao.impl;

import java.util.List;

import dao.QuestionDAO;
import entity.Question;

import util.DBUtil;

public class QuestionDAOImpl implements QuestionDAO {

	@Override
	public List<Question> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Question where IsExist = 1";
		return DBUtil.queryBean(sql, Question.class, new Object[] {});
	}  

	@Override
	public Question find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Question where IsExist = 1 and QNo = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Question.class, params).size()==0?null:DBUtil.queryBean(sql, Question.class, params).get(0);
	}
	
	@Override
	public List<Question> search(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select question.Qno,newT.ano,question.content as Qt,left(newT.Content,54) as At,UpVotednum,Downvotednum\r\n" + 
				"from question, (select * from answer where upvotednum in(select MAX(upvotednum) as upvotednum from answer group by qno)) newT\r\n" + 
				"where question.qno = newT.qno and question.content like ? ";
		Object[] params= {'%'+key+'%'};//只有这样传参才可以把百分号加进去
		return DBUtil.queryBean(sql, Question.class, params).size()==0?null:DBUtil.queryBean(sql, Question.class, params);
	}

	@Override
	public void add(Question obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Question (QNo,Content,Qdescribe,PublisherNo,PublisherTime,IsExist,IsSolved) values(0,?,?,?,?,?,?)";
		Object[] params= {obj.getContent(),obj.getQdescribe(),obj.getPublisherNo(),obj.getPublisherTime(),obj.getIsExist(),obj.getIsSolved()};
		DBUtil.changeTable(sql, params); 
	}

	@Override
	public void update(Question obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Question set Content = ? , PublisherNo = ? , PublisherTime = ? , IsExist = ? , IsSolved = ? where QNo = ?";
		Object[] params= {obj.getContent(),obj.getPublisherNo(),obj.getPublisherTime(),obj.getIsExist(),obj.getIsSolved(),obj.getQNo()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Question set IsExist = 0 where QNo = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<Question> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("Question", "QNo", true, pageIndex, size, Question.class);
	}

}
