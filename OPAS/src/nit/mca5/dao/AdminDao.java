package nit.mca5.dao;

import nit.mca5.pojo.Admin;

public interface AdminDao {
	Admin validLogin(String logingId,String loginPassword);
//	List<employee> getAllUsers();
//	public employee  getEmployee(long id);
//	//public abstract		List<employee>  getAll();
//	public abstract	boolean add(employee emp);
//	public abstract	boolean update(employee emp);
//	public abstract	boolean delete(long id);
//	/*public abstract	boolean deleteAll();*/
}
