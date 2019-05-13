package dao.impl;

import java.util.List;

import dao.ReplyDAO;
import entity.Reply;

import util.DBUtil;

public class ReplyDAOImpl implements ReplyDAO {

	@Override
	public List<Reply> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Reply where IsExist = 1";
		return DBUtil.queryBean(sql, Reply.class, new Object[] {});
	}

	@Override
	public Reply find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Reply where IsExist = 1 and ReNo = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Reply.class, params).size()==0?null:DBUtil.queryBean(sql, Reply.class, params).get(0);
	}

	@Override
	public void add(Reply obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Reply (ReNo,Content,DNo,PReNo,PublisherNo,PublisherTime,IsExist) values(?,?,?,?,?,?,?)";
		Object[] params= {obj.getReNo(),obj.getContent(),obj.getPreNo(),obj.getPublisherNo(),obj.getPublisherTime(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(Reply obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Reply set Content = ? , DNo = ? , PReNo = ? , PublisherNo = ? , PublisherTime = ? , IsExist = ? where ReNo = ?";
		Object[] params= {obj.getContent(),obj.getPreNo(),obj.getPublisherNo(),obj.getPublisherTime(),obj.getIsExist(),obj.getReNo()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Reply set IsExist = 0 where ReNo = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<Reply> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("Reply", "ReNo", true, pageIndex, size, Reply.class);
	}

}
