package dao;
import java.util.List;

import entity.Group;

public interface GroupDAO extends GenericDAO<Group>{
	long getMaxId() throws Exception;
	List<Group> findAll(String uId) throws Exception;
}
