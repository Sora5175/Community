package dao.impl;

import java.util.List;

import dao.VerificationCodeDAO;
import entity.VerificationCode;

import util.DBUtil;

public class VerificationCodeDAOImpl implements VerificationCodeDAO {

	@Override
	public List<VerificationCode> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from VerificationCode where IsExist = 1";
		return DBUtil.queryBean(sql, VerificationCode.class, new Object[] {});
	}

	@Override
	public VerificationCode find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from VerificationCode where IsExist = 1 and CNo = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, VerificationCode.class, params).size()==0?null:DBUtil.queryBean(sql, VerificationCode.class, params).get(0);
	}

	@Override
	public void add(VerificationCode obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into VerificationCode (CNo,UNo,Content,PublisherTime,IsExist) values(?,?,?,?,?)";
		Object[] params= {obj.getcNo(),obj.getuNo(),obj.getContent(),obj.getPublisherTime(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(VerificationCode obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update VerificationCode set UNo = ? , Content = ? , PublisherTime = ? , IsExist = ? where CNo = ?";
		Object[] params= {obj.getuNo(),obj.getContent(),obj.getPublisherTime(),obj.getIsExist(),obj.getcNo()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update VerificationCode set IsExist = 0 where CNo = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<VerificationCode> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("VerificationCode", "CNo", true, pageIndex, size, VerificationCode.class);
	}
}
