package dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import entity.UserInfo;

public interface UserInfoDAO extends GenericDAO<UserInfo> {
	//ͨ��userid��ȡ������Ϣ,����һ��map��������=��Ӧ��ֵ
	Map<String,String> getBasicInfo(String userid) throws Exception;
	
	//ͨ��userid��ȡ��չ��Ϣ
	Map<String,String> getExpandInfo(String userid) throws Exception;
	
	//����registerTime������Ϣ
	List<UserInfo> getInfoByTime(Date d) throws Exception;
	
	//获取以时间倒叙的分页数据
	List<UserInfo> pageDivByTime(int pageIndex,int size) throws Exception;
	
	//获取学生数量
	int getStudentNum() throws Exception;
	
	//获取教师数量
	int getTeacherNum() throws Exception;
}
