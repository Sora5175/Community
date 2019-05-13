package dao;

import java.sql.SQLException;
import java.util.List;

import entity.NoticeLost;

public interface NoticeLostDAO extends GenericDAO<NoticeLost>{
	public List<NoticeLost> LoadByTime(String key,String index) throws SQLException;
	public void deleteByLNo(String lno) throws SQLException;
}
