package dao.impl;

import java.util.List;

import dao.BuildingDAO;
import entity.Building;
import util.DBUtil;

public class BuildingDAOImpl implements BuildingDAO {

	@Override
	public List<Building> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Building where IsExist = 1";
		return DBUtil.queryBean(sql, Building.class, new Object[] {});
	}

	@Override
	public Building find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Building where IsExist = 1 and BuildingId = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Building.class, params).size()==0?null:DBUtil.queryBean(sql, Building.class, params).get(0);
	}

	@Override
	public void add(Building obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Building (BuildingId,BuildingName,SchoolId,IsExist) values(?,?,?,?)";
		Object[] params= {obj.getBuildingId(),obj.getBuildingName(),obj.getSchoolId(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(Building obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Building set BuildingName = ? , SchoolId = ? , IsExist = ? where  BuildingId = ?";
		Object[] params= {obj.getBuildingName(),obj.getSchoolId(),obj.getIsExist(),obj.getBuildingId()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Building set IsExist = 0 where BuildingId = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<Building> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("Building", "BuildingId", true, pageIndex, size, Building.class);
	}

}
