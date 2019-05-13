package dao;

import entity.Sign;

public interface SignDAO extends GenericDAO<Sign>{
	public void del(Sign obj) throws Exception;
}
