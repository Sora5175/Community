package dao.impl;

import java.util.List;

import dao.NoticeDAO;
import entity.Notice;

import util.DBUtil;

public class NoticeDAOImpl implements NoticeDAO {

	@Override
	public List<Notice> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Notice where IsExist = 1";
		return DBUtil.queryBean(sql, Notice.class, new Object[] {});
	}

	@Override
	public Notice find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Notice where IsExist = 1 and NNo = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Notice.class, params).size()==0?null:DBUtil.queryBean(sql, Notice.class, params).get(0);
	}

	@Override
	public void add(Notice obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Notice (NNo,Content,Photo,PublisherNo,PublisherTime,IsExist) values(?,?,?,?,?,?)";
		Object[] params= {obj.getnNo(),obj.getContent(),obj.getPhoto(),obj.getPublisherNo(),obj.getPublisherTime(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(Notice obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Notice set Content = ? , Photo = ? , PublisherNo = ? , PublisherTime = ? , IsExist = ? where NNo = ?";
		Object[] params= {obj.getContent(),obj.getPhoto(),obj.getPublisherNo(),obj.getPublisherTime(),obj.getIsExist(),obj.getnNo()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Notice set IsExist = 0 where NNo = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<Notice> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("Notice", "NNo", true, pageIndex, size, Notice.class);
	}

}
