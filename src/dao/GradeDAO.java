package dao;

import java.util.List;
import entity.Grade;


public interface GradeDAO extends GenericDAO<Grade>{
	//通过院系Id查找其以下的年级列表
	List<Grade> findAll(String departmentId) throws Exception;
}
