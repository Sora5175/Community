package dao.impl;

import java.util.List;

import dao.CourseUserDAO;
import entity.Course;
import entity.CourseUser;
import util.DBUtil;

public class CourseUserDAOImpl implements CourseUserDAO{

	@Override
	public List<CourseUser> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Course_User where IsExist = 1";
		return DBUtil.queryBean(sql, CourseUser.class, new Object[] {});
	}

	@Override
	public CourseUser find(String key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(CourseUser obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Course_User (courseId,uId,absenceNum,attendanceNum,IsExist) values(?,?,?,?,?)";
		Object[] params= {obj.getCourseId(),obj.getuId(),obj.getAbsenceNum(),obj.getAttendanceNum(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(CourseUser obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Course_User set absenceNum = ?,attendanceNum = ?,endTime = ?,IsExist = ? where courseId = ? and uId = ?";
		Object[] params= {obj.getAbsenceNum(),obj.getAttendanceNum(),obj.getEndTime(),obj.getIsExist(),obj.getCourseId(),obj.getuId()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CourseUser> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseUser find(String courseId, String uId) throws Exception {
		String sql="select * from Course_User where IsExist = 1 and courseId = ? and uId = ?";
		Object[] params= {courseId,uId};
		return DBUtil.queryBean(sql, CourseUser.class, params).size()==0?null:DBUtil.queryBean(sql, CourseUser.class, params).get(0);
	}

	@Override
	public void startSign(String courseId) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Course_User set absenceNum = absenceNum+1 where courseId = ?";
		Object[] params= {courseId};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<CourseUser> findAllByCourseId(String courseId) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Course_User where IsExist = 1 and CourseId = ? order by absenceNum desc";
		Object[] params = {courseId};
		return DBUtil.queryBean(sql, CourseUser.class, params);
	}

}
