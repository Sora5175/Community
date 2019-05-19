package dao;

import java.util.List;

import entity.Course;

public interface CourseDAO extends GenericDAO<Course>{
	List<Course> findAllByUserId(String userId) throws Exception;
	
	List<Course> findAllByUserIdAndCheck(String check,String userId) throws Exception;
	
	void startSign(String courseId) throws Exception;
}
