package dao.impl;

import java.util.List;

import dao.WxDAO;
import entity.Wx;
import util.DBUtil;

public class WxDAOImpl implements WxDAO {

	@Override
	public List<Wx> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Wx where IsExist = 1";
		return DBUtil.queryBean(sql, Wx.class, new Object[] {});
	}

	@Override
	public Wx find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from Wx where IsExist = 1 and OpenId = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, Wx.class, params).size()==0?null:DBUtil.queryBean(sql, Wx.class, params).get(0);
	}

	@Override
	public void add(Wx obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into Wx (OpenId,UId,IsExist) "
				+ "values(?,?,?)";
		Object[] params= {obj.getOpenId(),obj.getUId(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(Wx obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Users set UId = ? , IsExist = ? where OpenId = ?";
		Object[] params= {obj.getUId(),obj.getIsExist(),obj.getOpenId()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update Wx set IsExist = 0 where OpenId = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<Wx> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("Wx", "OpenId", true, pageIndex, size, Wx.class);
	}

}
 