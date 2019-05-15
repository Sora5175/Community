package dao.impl;

import java.util.List;

import dao.ActivityDAO;
import entity.Activity;
import util.DBUtil;


public  class ActivityDAOImpl implements ActivityDAO {

	@Override
	public List<Activity> findAll() throws Exception {
		return null;
		// TODO Auto-generated method stub
	}

	
	@Override
	public Activity find(String key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	
	
	public List<Activity> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("Answer", "ANo", true, pageIndex, size, Activity.class);
	}

	@Override
	public void add(Activity obj) throws Exception {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void update(Activity obj) throws Exception {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void del(String key) throws Exception {
		// TODO 自动生成的方法存根
		
	}


	@Override
	public List<Activity> findAllWithName(String key) throws Exception {
		// TODO 自动生成的方法存根
		//String sql="select * from Activitied where IsExist = 1 and SignPeople = ?";
	//String sql="select * from Activitied where IsExist = 1 and SignPeople = ? and StartTime >getdate() order by StartTime ";
		String sql="select * from Activitied where IsExist = 1 and SignPeople = ? and StartTime > now() order by StartTime ";
		
		Object[] params= {key};
		return DBUtil.queryBean(sql, Activity.class, params).size()==0?null:DBUtil.queryBean(sql, Activity.class, params);
	}

	
	

}
 