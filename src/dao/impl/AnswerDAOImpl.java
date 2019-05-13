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
		String sql="select * from Answer where IsExist = 1 and ANo = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Answer.class, params).size()==0?null:DBUtil.queryBean(sql, Answer.class, params).get(0);
	}

	@Override
	public void add(Answer obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Answer (ANo,Content,QNo,ResponderNo,ResponderTime,UpVotedNum,DownVotedNum,IsAdopted,IsExist) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		Object[] params= {obj.getaNo(),obj.getContent(),obj.getqNo(),obj.getResponderNo(),obj.getResponderTime(),obj.getUpVotedNum(),
				obj.getDownVotedNum(),obj.getIsAdopted(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(Answer obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Users set Content = ? , QNo = ? , ResponderNo = ? , ResponderTime = ? , UpVotedNum = ? , DownVotedNum = ? , IsAdoptedNum = ? , IsExist = ? where ANo = ?";
		Object[] params= {obj.getContent(),obj.getqNo(),obj.getResponderNo(),obj.getResponderTime(),obj.getUpVotedNum(),
				obj.getDownVotedNum(),obj.getIsAdopted(),obj.getIsExist(),obj.getaNo()};
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
 