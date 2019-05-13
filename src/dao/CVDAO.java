package dao;

import java.util.List;

import entity.CV;

public interface CVDAO extends GenericDAO<CV>{
	public CV findByGIdUId(long gId,String uId) throws Exception;
	public List<CV> findAllByGId(long gId) throws Exception;
	public List<CV> findAllByUId(String uId) throws Exception;
	public List<CV> findAllNotInByUId(String uId) throws Exception;
	public List<CV> findAllByGIdNotChecked(long gId) throws Exception;
	public List<CV> findAllByUIdChecked(String uId) throws Exception;
	public List<CV> findAllByUIdNotChecked(String uId) throws Exception;
}
