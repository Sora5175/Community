package dao.impl;

import java.util.List;

import dao.ClassDAO;
import entity.Class;
import util.DBUtil;

public class ClassDAOImpl implements ClassDAO {

	@Override
	public List<Class> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Class where IsExist = 1";
		return DBUtil.queryBean(sql, Class.class, new Object[] {});
	}

	@Override
	public Class find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Class where IsExist = 1 and ClassId = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Class.class, params).size()==0?null:DBUtil.queryBean(sql, Class.class, params).get(0);
	}

	@Override
	public void add(Class obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Class (ClassId,ClassName,DepartmentId,IsExist) values(?,?,?,?)";
		Object[] params= {obj.getClassId(),obj.getClassName(),obj.getGradeId(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(Class obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Class set ClassName = ? , DepartmentId = ? , IsExist = ? where ClassId = ?";
		Object[] params= {obj.getClassName(),obj.getGradeId(),obj.getIsExist(),obj.getClassId()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Class set IsExist = 0 where ClassId = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<Class> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("Class", "ClassId", true, pageIndex, size, Class.class);
	}
	
	@Override
	public List<Class> findAll(String gradeId) throws Exception {
		String sql="select * from Class where IsExist = 1 and GradeId = ?";
		Object[] params= {gradeId};
		return DBUtil.queryBean(sql, Class.class, params);
	}
}
