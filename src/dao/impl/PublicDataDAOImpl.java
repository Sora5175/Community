package dao.impl;

import java.util.List;

import dao.PublicDataDAO;
import entity.PublicData;

import util.DBUtil;

public class PublicDataDAOImpl implements PublicDataDAO {

	@Override
	public List<PublicData> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from PublicData where IsExist = 1";
		return DBUtil.queryBean(sql, PublicData.class, new Object[] {});
	}

	@Override
	public PublicData find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from PublicData where IsExist = 1 and DNo = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, PublicData.class, params).size()==0?null:DBUtil.queryBean(sql, PublicData.class, params).get(0);
	}

	@Override
	public void add(PublicData obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into PublicData (DNo,IsExist) values(?,?)";
		Object[] params= {obj.getdNo(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(PublicData obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update PublicData IsExist = ? where DNo = ?,";
		Object[] params= {obj.getIsExist(),obj.getdNo()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update PublicData set IsExist = 0 where DNo = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<PublicData> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("PublicData", "DNo", true, pageIndex, size, PublicData.class);
	}

}
