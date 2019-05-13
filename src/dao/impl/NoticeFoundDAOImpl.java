package dao.impl;

import java.sql.SQLException;
import java.util.List;

import dao.NoticeFoundDAO;
import entity.NoticeFound;
import util.DBUtil;

public class NoticeFoundDAOImpl implements NoticeFoundDAO{

	@Override
	public List<NoticeFound> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeFound find(String key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(NoticeFound obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into noticefound (Id,FNo,Pic,time,IsExist,PublisherId,LostLoc,LostTime,LostName,color,`type`) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params= {obj.getId(),obj.getfNo(),obj.getPic(),obj.getTime(),true,obj.getPublisherId(),obj.getLostLoc(),obj.getLostTime(),obj.getLostName(),obj.getColor(),obj.getType()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(NoticeFound obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="UPDATE noticefound SET IsExist = 0 WHERE Id = '"+key+"'";
		DBUtil.changeTable(sql, new Object[] {});
	}

	@Override
	public List<NoticeFound> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeFound> LoadByTime(String key, String index) throws SQLException {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM noticefound where FNo IN(SELECT FNo FROM found where PublisherNo = '"+key+"') AND IsExist = 1 ORDER BY time DESC limit "+index+",5";
		return DBUtil.queryBean(sql, NoticeFound.class, new Object[] {});
	}

	@Override
	public void deleteByFNo(String fno) throws SQLException {
		// TODO Auto-generated method stub
		String sql="UPDATE noticefound SET IsExist = 0 WHERE FNo = '"+fno+"'";
		DBUtil.changeTable(sql, new Object[] {});
	}
	
}
