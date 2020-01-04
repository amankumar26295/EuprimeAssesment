package nit.mca5.dao;

import nit.mca5.pojo.User;

public interface UserDao {
	boolean isUserExist(String email_id);
	User validLogin(String logingId,String loginPassword,String role);
	public abstract	boolean add(User user);
	String getUserName(Integer id);
	boolean isUserExist(String role,String email_id);
	boolean updatePassword(String email_id,String role,String password);
}
