package dao;

import java.util.List;
import entity.GroupUser;

public interface GroupUserDAO extends GenericDAO<GroupUser>{
	public GroupUser find(long gId,String uId) throws Exception;
	public void del(long gId,String uId) throws Exception;
	List<GroupUser> findAllNotAlternate() throws Exception;
	List<GroupUser> findAllNotAlternate(long gId) throws Exception;
	List<GroupUser> findAllAlternate() throws Exception;
	List<GroupUser> findAllAlternate(long gId) throws Exception;
	List<GroupUser> findAllByGId(long gId) throws Exception;
	List<GroupUser> findAll(String uId) throws Exception;
	public List<GroupUser> findAllNotIn(String uId) throws Exception;
}
