package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Lost;

public interface LostDAO extends GenericDAO<Lost> {
	public List<Lost> queryByTime(int index,int size) throws SQLException;
	public List<Lost> findAllNotSolved() throws SQLException;
	public Lost findNotSolved(String key) throws SQLException;
	public void lostAdd(Lost obj) throws SQLException;
}
