package dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import dao.FoundDAO;
import entity.Found;
import entity.Lost;
import util.DBUtil;

public class FoundDAOImpl implements FoundDAO {

	@Override
	public List<Found> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Found where IsExist = 1";
		return DBUtil.queryBean(sql, Found.class, new Object[] {});
	}

	@Override
	public Found find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Found where IsExist = 1 and FNo = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Found.class, params).size()==0?null:DBUtil.queryBean(sql, Found.class, params).get(0);
	}

	@Override
	public void add(Found obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Found (FNo,FName,Photo,`Describe`,FoundLocation,ReturnLocation,PublisherNo,PublisherTime,IsSolved,IsExist)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params= {obj.getfNo(),obj.getfName(),obj.getPhoto(),obj.getDescribe(),obj.getFoundLocation(),obj.getReturnLocation()
				,obj.getPublisherNo(),obj.getPublisherTime(),obj.getIsSolved(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(Found obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Found set FName = ? , Photo = ? , `Describe` = ? , FoundLocation = ? , ReturnLocation = ? , PublisherNo = ? , PublisherTime = ? , IsSolved = ?"
				+ " , IsExist = ?  where FNo = ?";
		Object[] params= {obj.getfName(),obj.getPhoto(),obj.getDescribe(),obj.getFoundLocation(),obj.getReturnLocation()
				,obj.getPublisherNo(),obj.getPublisherTime(),obj.getIsSolved(),obj.getIsExist(),obj.getfNo()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Found set IsExist = 0 where FNo = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<Found> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("Found", "FNo", true, pageIndex, size, Found.class);
	}

	@Override
	public List<Found> randomReturn(String loc, String time, String type,int size) throws SQLException {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM found WHERE FoundLocation = "+loc+" and `Type` = '"+type+"' and PublisherTime > '"+time+"' and IsSolved = 0 and IsExist = 1";
		List<Found> list=DBUtil.queryBean(sql, Found.class, new Object[] {});
		int cup=list.size(),sub=cup-size;
		Random rand=new Random();
		if(cup>size) {
			for(int i=0;i<sub;i++) {
				list.remove(rand.nextInt(cup));
			}
		}
		return list;
	}

	@Override
	public List<Found> queryByTime(int index,int size) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from Found where IsExist = 1 and IsSolved = 0 order by PublisherTime desc limit "+index+","+size;
		return DBUtil.queryBean(sql, Found.class, new Object[] {});
	}

	@Override
	public Found findNotSolved(String key) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from Found where IsExist = 1 and FNo = ? and IsSolved = 0";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Found.class, params).size()==0?null:DBUtil.queryBean(sql, Found.class, params).get(0);
	}

	@Override
	public void foundAdd(Found obj) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into Found (FNo,FName,Photo,`Describe`,FoundLocation,ReturnLocation,PublisherNo,PublisherTime,IsSolved,IsExist,`Type`)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params= {obj.getfNo(),obj.getfName(),obj.getPhoto(),obj.getDescribe(),obj.getFoundLocation(),obj.getReturnLocation()
				,obj.getPublisherNo(),obj.getPublisherTime(),false,true,obj.getType()};
		DBUtil.changeTable(sql, params);
	}
	public static void main(String[] args) throws SQLException {
		FoundDAOImpl dao=new FoundDAOImpl();
		List<Found> list=dao.randomReturn("1", "2018-11-30 00:00:00", "图书", 3);
		System.out.println(list);
	}
}
