package dao.impl;

import java.util.List;
import dao.GroupUserDAO;
import entity.GroupUser;
import util.DBUtil;

public class GroupUserDAOImpl implements GroupUserDAO{

	@Override
	public List<GroupUser> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from GroupUser where IsExist = 1";
		return DBUtil.queryBean(sql, GroupUser.class, new Object[] {});
	}

	@Override
	public GroupUser find(String key) throws Exception {
		return null;
	}

	@Override
	public void add(GroupUser obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into GroupUser (GId,UId,isAlternate,IsExist) "
				+ "values(?,?,?,?)";
		Object[] params= {obj.getgId(),obj.getuId(),obj.getIsAlternate(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(GroupUser obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update GroupUser set isAlternate = ? , IsExist = ? where GId = ? and UId = ?";
		Object[] params= {obj.getIsAlternate(),obj.getIsExist(),obj.getgId(),obj.getuId()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public List<GroupUser> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupUser find(long gId, String uId) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from `GroupUser` where IsExist = 1 and GId = ? and UId = ?";
		Object[] params= {gId,uId};
		return DBUtil.queryBean(sql, GroupUser.class, params).size()==0?null:DBUtil.queryBean(sql, GroupUser.class, params).get(0);
	}

	@Override
	public void del(long gId, String uId) throws Exception {
		String sql="update `GroupUser` set IsExist = 0 where GId = ? and UId = ?";
		Object[] params= {gId,uId};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<GroupUser> findAllNotAlternate() throws Exception {
		String sql="select * from GroupUser where IsExist = 1 and IsAlternate = 0";
		return DBUtil.queryBean(sql, GroupUser.class, new Object[] {});
	}
	
	@Override
	public List<GroupUser> findAllNotAlternate(long gId) throws Exception {
		String sql="select * from GroupUser where IsExist = 1 and IsAlternate = 0 and GId = ?";
		Object[] params= {gId};
		return DBUtil.queryBean(sql, GroupUser.class, params);
	}

	@Override
	public List<GroupUser> findAllAlternate() throws Exception {
		String sql="select * from GroupUser where IsExist = 1 and IsAlternate = 1";
		return DBUtil.queryBean(sql, GroupUser.class, new Object[] {});
	}
	
	@Override
	public List<GroupUser> findAllAlternate(long gId) throws Exception {
		String sql="select * from GroupUser where IsExist = 1 and IsAlternate = 1 and GId = ?";
		Object[] params= {gId};
		return DBUtil.queryBean(sql, GroupUser.class, params);
	}

	@Override
	public List<GroupUser> findAll(String uId) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from GroupUser where IsExist = 1 and UId = ?";
		Object[] params= {uId};
		return DBUtil.queryBean(sql,GroupUser.class, params);
	}
	@Override
	public List<GroupUser> findAllNotIn(String uId) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from GroupUser where IsExist = 1 and UId != ?";
		Object[] params= {uId};
		return DBUtil.queryBean(sql,GroupUser.class, params);
	}

	@Override
	public List<GroupUser> findAllByGId(long gId) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from GroupUser where IsExist = 1 and GId = ?";
		Object[] params= {gId};
		return DBUtil.queryBean(sql,GroupUser.class, params);
	}
}
