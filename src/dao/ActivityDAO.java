package dao;
import java.util.List;

import entity.Activity;

public interface ActivityDAO extends GenericDAO<Activity> {

	public List<Activity> findAllWithName(String key) throws Exception;


}
