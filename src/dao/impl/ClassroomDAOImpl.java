package dao.impl;

import java.sql.SQLException;
import java.util.List;

import dao.ClassroomDAO;
import entity.Classroom;

import util.DBUtil;

public class ClassroomDAOImpl implements ClassroomDAO {

	@Override
	public List<Classroom> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Classroom where IsExist = 1";
		return DBUtil.queryBean(sql, Classroom.class, new Object[] {});
	}

	@Override
	public Classroom find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Classroom where IsExist = 1 and ClassroomId = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Classroom.class, params).size()==0?null:DBUtil.queryBean(sql, Classroom.class, params).get(0);
	}

	@Override
	public void add(Classroom obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Classroom (ClassroomId,ClassroomName,BuildingId,IsExist) values(?,?,?,?)";
		Object[] params= {obj.getClassroomId(),obj.getClassroomName(),obj.getBuildingId(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(Classroom obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Classroom set ClassroomName = ? , BuildingId = ? , IsExist = ? where ClassroomId = ?";
		Object[] params= {obj.getClassroomName(),obj.getBuildingId(),obj.getIsExist(),obj.getClassroomId()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Classroom set IsExist = 0 where ClassroomId = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<Classroom> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("Classroom", "ClassroomId", true, pageIndex, size, Classroom.class);
	}

	@Override
	public List<Classroom> valuesOfSchool(String sid) throws SQLException {
		// TODO Auto-generated method stub
		String sql="select * from classroom where BuildingId in (select BuildingId from building where SchoolId = "+sid+
				" and IsExist = 1) and IsExist = 1";
		return DBUtil.queryBean(sql, Classroom.class, new Object[] {});
	}

}
