package dao.impl;

import java.util.List;

import dao.SignDAO;
import entity.Sign;

import util.DBUtil;

public class SignDAOImpl implements SignDAO{

	@Override
	public List<Sign> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Sign where IsExist = 1";
		return DBUtil.queryBean(sql, Sign.class, new Object[] {});
	}

	@Override
	public Sign find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Sign where IsExist = 1 and UserId = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Sign.class, params).size()==0?null:DBUtil.queryBean(sql, Sign.class, params).get(0);
	}

	@Override
	public void add(Sign obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Sign (UId,PlanId,SignInTime,IsExist) values(?,?,?,?)";
		Object[] params= {obj.getUId(),obj.getPlanId(),obj.getSignInTime(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(Sign obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Sign set SignInTime = ? , IsExist = ? where UId = ? and PlanId = ?";
		Object[] params= {obj.getSignInTime(),obj.getIsExist(),obj.getUId(),obj.getPlanId()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void del(Sign obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Sign set IsExist = 0 where UId = ? and PlanId = ? and  SignInTime = ?";
		Object[] params= {obj.getUId(),obj.getPlanId(),obj.getSignInTime()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<Sign> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("Sign", "SignInTime", false, pageIndex, size, Sign.class);
	}
}
