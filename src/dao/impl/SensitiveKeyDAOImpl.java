package dao.impl;

import java.util.List;

import dao.SensitiveKeyDAO;
import entity.SensitiveKey;

import util.DBUtil;

public class SensitiveKeyDAOImpl implements SensitiveKeyDAO {

	@Override
	public List<SensitiveKey> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from SensitiveKey where IsExist = 1";
		return DBUtil.queryBean(sql, SensitiveKey.class, new Object[] {});
	}

	@Override
	public SensitiveKey find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from SensitiveKey where IsExist = 1 and SKNO = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, SensitiveKey.class, params).size()==0?null:DBUtil.queryBean(sql, SensitiveKey.class, params).get(0);
	}

	@Override
	public void add(SensitiveKey obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into SensitiveKey (SKNO,Content,IsExist) values(?,?,?)";
		Object[] params= {obj.getSkNo(),obj.getContent(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(SensitiveKey obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update SensitiveKey set Content = ? , IsExist = ? where  SKNO = ?";
		Object[] params= {obj.getContent(),obj.getIsExist(),obj.getSkNo()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update SensitiveKey set IsExist = 0 where SKNO = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<SensitiveKey> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("SensitiveKey", "SKNO", true, pageIndex, size, SensitiveKey.class);
	}

}
