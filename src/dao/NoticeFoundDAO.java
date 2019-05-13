package dao;

import java.sql.SQLException;
import java.util.List;

import entity.NoticeFound;

public interface NoticeFoundDAO extends GenericDAO<NoticeFound>{
	public List<NoticeFound> LoadByTime(String key,String index) throws SQLException;
	public void deleteByFNo(String fno) throws SQLException;
}
