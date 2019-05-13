package dao.impl;

import java.sql.SQLException;
import java.util.List;


import dao.LostDAO;
import entity.Lost;
import util.BeanUtil;
import util.DBUtil;

public class LostDAOImpl implements LostDAO {

	@Override
	public List<Lost> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Lost where IsExist = 1";
		return DBUtil.queryBean(sql, Lost.class, new Object[] {});
	}

	@Override
	public Lost find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Lost where IsExist = 1 and LNo = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Lost.class, params).size()==0?null:DBUtil.queryBean(sql, Lost.class, params).get(0);
	}

	@Override
	public void add(Lost obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Lost (LNo,LName,Photo,Describe,LostLocation,ReturnLocation,PublisherNo,PublisherTime,IsSolved,IsExist) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params= {obj.getlNo(),obj.getlName(),obj.getPhoto(),obj.getDescribe(),obj.getLostLocation(),obj.getReturnLocation()
				,obj.getPublisherNo(),obj.getPublisherTime(),obj.getIsSolved(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(Lost obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Lost set LName = ? , Photo = ? , `Describe` = ? , LostLocation = ? , ReturnLocation = ? , PublisherNo = ? , PublisherTime = ? , IsSolved = ?"
				+ " , IsExist = ? where LNo = ?";
		Object[] params= {obj.getlName(),obj.getPhoto(),obj.getDescribe(),obj.getLostLocation(),obj.getReturnLocation()
				,obj.getPublisherNo(),obj.getPublisherTime(),obj.getIsSolved(),obj.getIsExist(),obj.getlNo()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Lost set IsExist = 0 where LNo = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<Lost> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("Lost", "LNo", true, pageIndex, size, Lost.class);
	}

	@Override
	public List<Lost> queryByTime(int index,int size) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from Lost where IsExist = 1 and IsSolved = 0 order by PublisherTime desc limit "+index+","+size;
		return DBUtil.queryBean(sql, Lost.class, new Object[] {});
	}

	@Override
	public List<Lost> findAllNotSolved() throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from Lost where IsExist = 1 and IsSolved = 0";
		return DBUtil.queryBean(sql, Lost.class, new Object[] {});
	}

	@Override
	public Lost findNotSolved(String key) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from Lost where IsExist = 1 and LNo = ? and IsSolved = 0";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Lost.class, params).size()==0?null:DBUtil.queryBean(sql, Lost.class, params).get(0);
	}

	@Override
	public void lostAdd(Lost obj) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into Lost (LNo,LName,Photo,`Describe`,LostLocation,ReturnLocation,PublisherNo,PublisherTime,IsSolved,IsExist,`Type`,LostTime) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params= {obj.getlNo(),obj.getlName(),obj.getPhoto(),obj.getDescribe(),obj.getLostLocation(),obj.getReturnLocation()
				,obj.getPublisherNo(),obj.getPublisherTime(),false,true,obj.getType(),obj.getLostTime()};
		DBUtil.changeTable(sql, params);
	}
	public static void main(String[] args) throws SQLException {

	}
}
