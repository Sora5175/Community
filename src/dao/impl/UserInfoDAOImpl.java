package dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.UserInfoDAO;
import entity.Class;
import entity.Department;
import entity.School;
import entity.UserInfo;

import util.DBUtil;

public class UserInfoDAOImpl implements UserInfoDAO {

	@Override
	public List<UserInfo> findAll() throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from UserInfo where IsExist = 1";
		return DBUtil.queryBean(sql, UserInfo.class, new Object[] {});
	}

	@Override
	public UserInfo find(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="select * from UserInfo where IsExist = 1 and UserId = ?";
		Object[] params= {key};
		return DBUtil.queryBean(sql, UserInfo.class, params).size()==0?null:DBUtil.queryBean(sql, UserInfo.class, params).get(0);
	}

	@Override
	public void add(UserInfo obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into UserInfo (UserId,Name,DepartmentId,ClassId,Tel,Email,Deposite,IsExist,IsStu,SchoolId,RegisterTime,Sex,GradeId) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] params= {obj.getUserId(),obj.getName(),obj.getDepartmentId(),obj.getClassId(),obj.getTel(),obj.getEmail(),obj.getDeposite(),
				obj.getIsExist(),obj.getIsStu(),obj.getSchoolId(),obj.getRegisterTime(),obj.getSex(),obj.getGradeId()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void update(UserInfo obj) throws Exception {
		// TODO Auto-generated method stub
		String sql="update UserInfo set Name = ? , DepartmentId = ? , ClassId = ? , Tel = ? , Email = ? , Deposite = ? , IsExist = ? , IsStu = ? , SchoolId = ? , RegisterTime = ? , Sex = ? , GradeId = ? where UserId = ?";
		Object[] params= {obj.getName(),obj.getDepartmentId(),obj.getClassId(),obj.getTel(),obj.getEmail(),obj.getDeposite(),
				obj.getIsExist(),obj.getIsStu(),obj.getSchoolId(),obj.getRegisterTime(),obj.getSex(),obj.getGradeId(),obj.getUserId()};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public void del(String key) throws Exception {
		// TODO Auto-generated method stub
		String sql="update UserInfo set IsExist = 0 where UserId = ?";
		Object[] params= {key};
		DBUtil.changeTable(sql, params);
	}

	@Override
	public List<UserInfo> pageDiv(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("UserInfo", "UserId", true, pageIndex, size, UserInfo.class);
	}

	@Override
	public Map<String, String> getBasicInfo(String userid) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String,String> map=new HashMap<>();
		UserInfo user=find(userid);
		map.put("UserId", user.getUserId());
		map.put("Name", user.getName());
		map.put("Sex", user.getSex());
		map.put("Tel", user.getTel());
		map.put("Email", user.getEmail());
		return map;
	}

	@Override
	public Map<String, String> getExpandInfo(String userid) throws Exception {
		// TODO Auto-generated method stub
		HashMap<String,String> map=new HashMap<>();
		UserInfo user=find(userid);
		//��ȡѧУ��
		School school=new SchoolDAOImpl().find(user.getSchoolId());
		map.put("School", school.getSchoolName());
		//��ȡԺϵ
		Department department=new DepartmentDAOImpl().find(user.getDepartmentId());
		map.put("Department", department.getDepartmentName());
		//��ȡ�꼶
		map.put("Grade", user.getGradeId());
		//��ȡ�༶
		Class c=new ClassDAOImpl().find(user.getClassId());
		map.put("Class", c.getClassName());
		//��ȡ���
		map.put("Deposite", user.getDeposite()+"");
		return map;
	}

	@Override
	public List<UserInfo> getInfoByTime(Date d) throws Exception {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String sql="select * from UserInfo where DATEDIFF("+"'"+sdf.format(d)+"'"+",RegisterTime) = 0" ;
		return DBUtil.queryBean(sql, UserInfo.class, new Object[] {});
	}

	@Override
	public List<UserInfo> pageDivByTime(int pageIndex, int size) throws Exception {
		// TODO Auto-generated method stub
		return DBUtil.pageQuery("UserInfo", "RegisterTime",false, pageIndex, size, UserInfo.class);
	}
	
	@Override
	public int getStudentNum() throws Exception {
		String sql="select * from UserInfo where IsExist = 1 and IsStu = 1";
		return DBUtil.queryBean(sql, UserInfo.class, new Object[] {}).size();
	}

	@Override
	public int getTeacherNum() throws Exception {
		String sql="select * from UserInfo where IsExist = 1 and IsStu = 0";
		return DBUtil.queryBean(sql, UserInfo.class, new Object[] {}).size();
	}
	
}
