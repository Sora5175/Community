package dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.CourseDAO;
import entity.Course;
import util.DBUtil;

public class CourseDAOImpl implements CourseDAO{

	@Override
	public List<Course> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Course where IsExist = 1";
		return DBUtil.queryBean(sql, Course.class, new Object[] {});
	}

	@Override
	public Course find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Course where IsExist = 1 and courseId = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Course.class, params).size()==0?null:DBUtil.queryBean(sql, Course.class, params).get(0);
	}

	@Override
	public void add(Course obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Course (uId,name,IsExist) values(?,?,?)";
		Object[] params= {obj.getuId(),obj.getName(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(Course obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Course set uId = ?,name=?,IsExist = ? where courseId = ?";
		Object[] params= {obj.getuId(),obj.getName(),obj.getIsExist(),obj.getCourseId()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Course set IsExist = 0 where courseId = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
		
	}

	@Override
	public List<Course> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAllByUserId(String userId) throws Exception{
		// TODO Auto-generated method stub
		String sql="select * from Course where IsExist = 1 and uId = ? order by courseId desc";
		Object[] params= {userId};
		return DBUtil.queryBean(sql, Course.class, params);
	}

	@Override
	public void startSign(String courseId) throws Exception {
		// TODO Auto-generated method stub
		Date date=new Date();
		date.setMinutes(date.getMinutes()+10);
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time = sdf.format(date);
		String sql="update Course set endTime = ? where courseId = ?";
		Object[] params= {time,courseId};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<Course> findAllByUserIdAndCheck(String check, String userId) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Course where IsExist = 1 and uId != ?  "
				+ "and name like '%"+check+"%' and courseId  not in "
				+ "(select courseId from Course_User where uId = ? and IsExist = 1) "
				+ "order by courseId desc";
		Object[] params= {userId,userId};
		return DBUtil.queryBean(sql, Course.class, params);
	}
}
