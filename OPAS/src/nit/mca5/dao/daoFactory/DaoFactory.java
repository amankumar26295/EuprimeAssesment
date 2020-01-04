package nit.mca5.dao.daoFactory;

import nit.mca5.dao.AdminDao;
import nit.mca5.dao.MenuDao;
import nit.mca5.dao.OrderDao;
import nit.mca5.dao.ShopDao;
import nit.mca5.dao.UserDao;
import nit.mca5.dao.daoImpl.AdminDaoImpl;
import nit.mca5.dao.daoImpl.MenuDaoImpl;
import nit.mca5.dao.daoImpl.OrderDaoImpl;
import nit.mca5.dao.daoImpl.ShopDaoImpl;
import nit.mca5.dao.daoImpl.UserDaoImpl;


public class DaoFactory {
	private DaoFactory() {}
	
	private static UserDao userDao = null;
	public static UserDao getUserDao() {
		if(userDao==null) {
			userDao =new UserDaoImpl();
		}
		return userDao;
	}
	
	private static AdminDao adminDao = null;
	public static AdminDao getAdminDao() {
		if(adminDao==null) {
			adminDao =new AdminDaoImpl();
		}
		return adminDao;
	}
	
	private static ShopDao shopdao = null;
	public static ShopDao getShopDao() {
		if(shopdao==null) {
			shopdao =new ShopDaoImpl();
		}
		return shopdao;
	}
	
	private static OrderDao orderdao = null;
	public static OrderDao getOrderDao() {
		if(orderdao==null) {
			orderdao =new OrderDaoImpl();
		}
		return orderdao;
	}
	
	private static MenuDao menudao = null;
	public static MenuDao getMenuDao() {
		if(menudao==null) {
			menudao =new MenuDaoImpl();
		}
		return menudao;
	}
}
