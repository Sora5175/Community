package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Found;

public interface FoundDAO extends GenericDAO<Found> {
	public List<Found> randomReturn(String loc,String time,String type,int size) throws SQLException;
	public List<Found> queryByTime(int index,int size) throws SQLException;
	public Found findNotSolved(String key) throws SQLException;
	public void foundAdd(Found obj) throws SQLException;
}
