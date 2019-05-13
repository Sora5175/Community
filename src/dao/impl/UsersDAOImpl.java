package dao.impl;

import java.util.List;

import dao.UsersDAO;
import entity.Users;

import util.DBUtil;
public class UsersDAOImpl implements UsersDAO{

	@Override
	public List<Users> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Users where IsExist = 1";
		return DBUtil.queryBean(sql, Users.class, new Object[] {});
	}

	@Override
	public Users find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Users where IsExist = 1 and UserId = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Users.class, params).size()==0?null:DBUtil.queryBean(sql, Users.class, params).get(0);
	}

	@Override
	public void add(Users obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Users (UserId,Pwd,IsAdmin,IsExist) values(?,?,?,?)";
		Object[] params= {obj.getUserId(),obj.getPwd(),obj.getIsAdmin(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(Users obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Users set Pwd = ?,IsAdmin=?,IsExist = ? where UserId = ?";
		Object[] params= {obj.getPwd(),obj.getIsAdmin(),obj.getIsExist(),obj.getUserId()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Users set IsExist = 0 where UserId = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<Users> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("Users", "UserId", true, pageIndex, size, Users.class);
	}
	
	@Override
	//�ж��Ƿ���Ե�¼
	public boolean pass(Users user) throws Exception {
		Users u = this.find(user.getUserId());
		if(u!=null&u.getPwd().equals(user.getPwd())&u.getIsAdmin().equals("1"))
			return true;
		return false;
	}
}
