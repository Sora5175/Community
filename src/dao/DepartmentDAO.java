package dao;

import java.util.List;

import entity.Department;

public interface DepartmentDAO extends GenericDAO<Department> {
	//通过学校Id查找其以下的院系列表
	List<Department> findAll(String schoolId) throws Exception;
}
