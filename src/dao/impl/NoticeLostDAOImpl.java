package dao.impl;

import java.sql.SQLException;
import java.util.List;

import dao.NoticeLostDAO;
import entity.NoticeLost;
import util.DBUtil;

public class NoticeLostDAOImpl implements NoticeLostDAO{

	@Override
	public List<NoticeLost> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NoticeLost find(String key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(NoticeLost obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into NoticeLost (Id,LNo,Pic,ReturnLoc,time,IsExist,PublisherId) "
				+ "values(?,?,?,?,?,?,?)";
		Object[] params= {obj.getId(),obj.getlNo(),obj.getPic(),obj.getReturnLoc(),obj.getTime(),true,obj.getPublisherId()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(NoticeLost obj) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="UPDATE noticelost SET IsExist = 0 WHERE Id = '"+key+"'";
		DBUtil.changeTable(sql, new Object[] {});
	}

	@Override
	public List<NoticeLost> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeLost> LoadByTime(String key,String index) throws SQLException {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM noticelost where LNo IN(SELECT LNo FROM lost where PublisherNo = '"+key+"') AND IsExist = 1 ORDER BY time DESC limit "+index+",5";
		return DBUtil.queryBean(sql, NoticeLost.class, new Object[] {});
	}

	@Override
	public void deleteByLNo(String lno) throws SQLException {
		// TODO Auto-generated method stub
		String sql="UPDATE noticelost SET IsExist = 0 WHERE LNo = '"+lno+"'";
		DBUtil.changeTable(sql, new Object[] {});
	}
}
