package dao.impl;

import java.util.List;

import dao.GradeDAO;
import entity.Grade;

import util.DBUtil;

public class GradeDAOImpl implements GradeDAO{

	@Override
	public List<Grade> findAll() throws Exception {
		String sql="select * from Grade where IsExist = 1";
		return DBUtil.queryBean(sql, Grade.class, new Object[] {});
	}

	@Override
	public Grade find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Grade where IsExist = 1 and GradeId = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Grade.class, params).size()==0?null:DBUtil.queryBean(sql, Grade.class, params).get(0);
	}

	@Override
	public void add(Grade obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Grade (GradeId,GradeName,DepartmentId,IsExist) values(?,?,?,?)";
		Object[] params= {obj.getGradeId(),obj.getGradeName(),obj.getDepartmentId(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(Grade obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Grade set GradeName = ? , DepartmentId = ? , IsExist = ? where GradeId = ?";
		Object[] params= {obj.getGradeName(),obj.getDepartmentId(),obj.getIsExist(),obj.getGradeId()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Grade set IsExist = 0 where GradeId = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<Grade> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("Grade", "GradeId", true, pageIndex, size, Grade.class);
	}


	@Override
	public List<Grade> findAll(String departmentlId) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Grade where IsExist = 1 and DepartmentId = ?";
		Object[] params= {departmentlId};
		return DBUtil.queryBean(sql, Grade.class, params);
	}
	
}
