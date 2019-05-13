package dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import dao.LoginRecordDAO;
import entity.LoginRecord;
import util.DBUtil;

public class LoginRecordDAOImpl implements LoginRecordDAO{

	@Override
	public List<LoginRecord> findAll() throws Exception {
		String sql="select * from LoginRecord where IsExist = 1";
		return DBUtil.queryBean(sql, LoginRecord.class, new Object[] {});
	}

	@Override
	public LoginRecord find(String key) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(LoginRecord obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into LoginRecord (UserId,LoginTime,IsExist) values(?,?,?)";
		Object[] params= {obj.getUserId(),obj.getLoginTime(),obj.getIsExist()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(LoginRecord obj) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public List<LoginRecord> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("LoginRecord", "LoginRecordId", true, pageIndex, size, LoginRecord.class);
	}
	
	@Override
	public List<LoginRecord> getInfoByTime(Date d) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String sql="select * from LoginRecord where DATEDIFF("+"'"+sdf.format(d)+"'"+",LoginTime) = 0" ;
		return DBUtil.queryBean(sql, LoginRecord.class, new Object[] {});
	}
}
