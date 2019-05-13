package dao;

import java.util.*;

public interface GenericDAO<T> {
	List<T> findAll() throws Exception;
	
	T find(String key) throws Exception;
	
	void add(T obj) throws Exception;
	
	void update(T obj) throws Exception;
	
	void del(String key) throws Exception;
	
	List<T> pageDiv(int pageIndex,int size) throws Exception;
}
