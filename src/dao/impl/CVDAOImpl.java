package dao.impl;

import java.util.List;

import dao.CVDAO;
import entity.CV;
import util.DBUtil;

public class CVDAOImpl implements CVDAO{

	@Override
	public List<CV> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from `CV` where IsExist = 1";
		return DBUtil.queryBean(sql, CV.class, new Object[] {});
	}

	@Override
	public CV find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from `CV` where IsExist = 1 and CId = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, CV.class, params).size()==0?null:DBUtil.queryBean(sql, CV.class, params).get(0);
	}

	@Override
	public void add(CV obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into `CV` (CId,GId,UId,IsChecked,IsExist) "
				+ "values(?,?,?,?,?)";
		Object[] params= {obj.getcId(),obj.getgId(),obj.getuId(),obj.getIsChecked(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(CV obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update `CV` set GId = ?, UId = ? , IsChecked = ?, IsExist = ? where CId = ?";
		Object[] params= {obj.getgId(),obj.getuId(),obj.getIsChecked(),obj.getIsExist(),obj.getcId()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update `CV` set IsExist = 0 where CId = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<CV> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("CV", "CId", true, pageIndex, size, CV.class);
	}

	@Override
	public List<CV> findAllByGId(long gId) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from `CV` where IsExist = 1 and GId = ? order by CId desc";
		Object[] params= {gId};
		return DBUtil.queryBean(sql, CV.class, params);
	}

	@Override
	public List<CV> findAllByUId(String uId) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from `CV` where IsExist = 1 and UId = ? order by CId desc";
		Object[] params= {uId};
		return DBUtil.queryBean(sql, CV.class, params);
	}
	
	@Override
	public List<CV> findAllNotInByUId(String uId) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from `CV` where IsExist = 1 and UId = ? order by CId desc";
		Object[] params= {uId};
		return DBUtil.queryBean(sql, CV.class, params);
	}

	@Override
	public List<CV> findAllByGIdNotChecked(long gId) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from `CV` where IsExist = 1 and IsChecked = 0 and GId = ? order by CId desc";
		Object[] params= {gId};
		return DBUtil.queryBean(sql, CV.class, params);
	}

	@Override
	public List<CV> findAllByUIdChecked(String uId) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from `CV` where IsExist = 1 and IsChecked = 1 and UId = ? order by CId desc";
		Object[] params= {uId};
		return DBUtil.queryBean(sql, CV.class, params);
	}

	@Override
	public List<CV> findAllByUIdNotChecked(String uId) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from `CV` where IsExist = 1 and IsChecked = 0 and UId = ? order by CId desc";
		Object[] params= {uId};
		return DBUtil.queryBean(sql, CV.class, params);
	}

	@Override
	public CV findByGIdUId(long gId, String uId) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql="select * from `CV` where IsExist = 1 and GId = ? and UId = ? ";
		Object[] params= {gId,uId};
		return DBUtil.queryBean(sql, CV.class, params).size()==0?null:DBUtil.queryBean(sql, CV.class, params).get(0);
	}
}
