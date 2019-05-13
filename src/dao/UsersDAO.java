package dao;


import entity.Users;

public interface UsersDAO extends GenericDAO<Users>{
	public boolean pass(Users user) throws Exception ;
}
