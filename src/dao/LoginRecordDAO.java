package dao;

import java.util.Date;
import java.util.List;
import entity.LoginRecord;

public interface LoginRecordDAO extends GenericDAO<LoginRecord>{
	List<LoginRecord> getInfoByTime(Date d) throws Exception;
}
