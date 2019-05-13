package dao.impl;

import java.util.List;

import dao.DepartmentDAO;
import entity.Department;

import util.DBUtil;

public class DepartmentDAOImpl implements DepartmentDAO {

	@Override
	public List<Department> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Department where IsExist = 1";
		return DBUtil.queryBean(sql, Department.class, new Object[] {});
	}

	@Override
	public Department find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Department where IsExist = 1 and DepartmentId = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Department.class, params).size()==0?null:DBUtil.queryBean(sql, Department.class, params).get(0);
	}

	@Override
	public void add(Department obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Department (DepartmentId,DepartmentName,SchoolId,IsExist) values(?,?,?,?)";
		Object[] params= {obj.getDepartmentId(),obj.getDepartmentName(),obj.getSchoolId(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(Department obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Department set DepartmentName = ? , SchoolId = ? , IsExist = ? where DepartmentId = ?";
		Object[] params= {obj.getDepartmentName(),obj.getSchoolId(),obj.getIsExist(),obj.getDepartmentId()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Department set IsExist = 0 where DepartmentId = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<Department> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("Department", "DepartmentId", true, pageIndex, size, Department.class);
	}
	
	@Override
	public List<Department> findAll(String schoolId) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Department where IsExist = 1 and SchoolId = ?";
		Object[] params= {schoolId};
		return DBUtil.queryBean(sql, Department.class, params);
	}
}
