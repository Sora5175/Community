package dao.impl;

import java.util.List;

import dao.SchoolDAO;
import entity.School;

import util.DBUtil;

public class SchoolDAOImpl implements SchoolDAO {

	@Override
	public List<School> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from School where IsExist = 1";
		return DBUtil.queryBean(sql, School.class, new Object[] {});
	}

	@Override
	public School find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from School where IsExist = 1 and SchoolId = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, School.class, params)==null?null:DBUtil.queryBean(sql, School.class, params).get(0);
	}

	@Override
	public void add(School obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into School (SchoolId,SchoolName,IsExist) values(?,?,?)";
		Object[] params= {obj.getSchoolId(),obj.getSchoolName(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(School obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update School set SchoolName = ? , IsExist = ? where SchoolId = ?";
		Object[] params= {obj.getSchoolName(),obj.getIsExist(),obj.getSchoolId()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update School set IsExist = 0 where SchoolId = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<School> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("School", "SchoolId", true, pageIndex, size, School.class);
	}

}
