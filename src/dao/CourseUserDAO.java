package dao;

import java.util.List;

import entity.CourseUser;

public interface CourseUserDAO extends GenericDAO<CourseUser>{
	CourseUser find(String courseId,String uId) throws Exception;
	
	void startSign(String courseId) throws Exception;
	
	List<CourseUser> findAllByCourseId(String courseId) throws Exception;
}
