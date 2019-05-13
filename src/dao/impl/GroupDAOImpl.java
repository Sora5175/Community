package dao.impl;

import java.util.List;

import dao.GroupDAO;
import entity.Group;
import util.DBUtil;

public class GroupDAOImpl implements GroupDAO{

	@Override
	public List<Group> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from `Group` where IsExist = 1";
		return DBUtil.queryBean(sql, Group.class, new Object[] {});
	}

	@Override
	public Group find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from `Group` where IsExist = 1 and GId = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Group.class, params).size()==0?null:DBUtil.queryBean(sql, Group.class, params).get(0);
	}

	@Override
	public void add(Group obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into `Group` (GId,Name,Content,UId,NeedNumber,AlternateNumber,IsExist) "
				+ "values(?,?,?,?,?,?,?)";
		Object[] params= {obj.getgId(),obj.getName(),obj.getContent(),obj.getuId(),obj.getNeedNumber(),obj.getAlternateNumber(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(Group obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update `Group` set Name = ?, Content = ? , UId = ? , NeedNumber = ? , AlternateNumber = ? , IsExist = ? where GId = ?";
		Object[] params= {obj.getName(),obj.getContent(),obj.getuId(),obj.getNeedNumber(),obj.getAlternateNumber(),obj.getIsExist(),obj.getgId()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update `Group` set IsExist = 0 where GId = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<Group> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("Group", "GId", true, pageIndex, size, Group.class);
	}

	@Override
	public long getMaxId() throws Exception {
		String sql="select * from `Group` where IsExist = 1 order by GId DESC limit 1";
		return DBUtil.queryBean(sql, Group.class, new Object[] {})==null?1:DBUtil.queryBean(sql, Group.class, new Object[] {}).get(0).getgId();
	}

	@Override
	public List<Group> findAll(String uId) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from `Group` where IsExist = 1 and UId = ?";
		Object[] params= {uId};
		return DBUtil.queryBean(sql, Group.class, params);
	}

}
