package dao;
import java.util.List;
import entity.Class;

public interface ClassDAO extends GenericDAO<Class>{
	//通过年级Id查找其以下的班级列表
	List<Class> findAll(String gradeId) throws Exception;
}
