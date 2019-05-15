package dao.impl;

import java.util.List;

import dao.AnswerDAO;
import entity.Answer;
import util.DBUtil;

public class AnswerDAOImpl implements AnswerDAO {

	@Override
	public List<Answer> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Answer where IsExist = 1";
		return DBUtil.queryBean(sql, Answer.class, new Object[] {});
	}

	@Override
	public Answer find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select Answer.*,Userinfo.Name as responderName,Question.Content as Qt from Answer,Userinfo,Question where Answer.IsExist = 1 and ANo = ? and Answer.QNo=Question.QNo and Answer.ResponderNo=Userinfo.UserId";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Answer.class, params).size()==0?null:DBUtil.queryBean(sql, Answer.class, params).get(0);
	}
	
	@Override
	public List<Answer> findqa(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select Answer.*,Userinfo.Name as responderName,Question.Content as Qt,Qdescribe from Answer,Userinfo,Question where Answer.IsExist = 1 and Answer.QNo = ? and Answer.QNo=Question.QNo and Answer.ResponderNo=Userinfo.UserId";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Answer.class, params).size()==0?null:DBUtil.queryBean(sql, Answer.class, params);
	}

	@Override
	public void add(Answer obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Answer (ANo,Content,QNo,ResponderNo,ResponderTime,UpVotedNum,DownVotedNum,IsAdopted,IsExist) "
				+ "values(0,?,?,?,?,?,?,?,?)";
		Object[] params= {obj.getContent(),obj.getQNo(),obj.getResponderNo(),obj.getResponderTime(),obj.getUpVotedNum(),
				obj.getDownVotedNum(),obj.getIsAdopted(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(Answer obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Answer set Content = ? , QNo = ? , ResponderNo = ? , ResponderTime = ? , UpVotedNum = ? , DownVotedNum = ? , IsAdoptedNum = ? , IsExist = ? where ANo = ?";
		Object[] params= {obj.getContent(),obj.getQNo(),obj.getResponderNo(),obj.getResponderTime(),obj.getUpVotedNum(),
				obj.getDownVotedNum(),obj.getIsAdopted(),obj.getIsExist(),obj.getANo()};
		DBUtil.changeTable(sql, params);
	}
	public void up(Answer obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Answer set UpVotedNum = ? where ANo = ?";
		Object[] params= {obj.getUpVotedNum(),obj.getANo()};
		DBUtil.changeTable(sql, params);
	}
	public void down(Answer obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Answer set DownVotedNum = ? where ANo = ?";
		Object[] params= {obj.getDownVotedNum(),obj.getANo()};
		DBUtil.changeTable(sql, params);
	}
	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Answer set IsExist = 0 where ANo = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<Answer> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("Answer", "ANo", true, pageIndex, size, Answer.class);
	}
	

}
 