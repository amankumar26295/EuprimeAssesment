package nit.mca5.dao;

import java.util.List;

import nit.mca5.pojo.Menu;

public interface MenuDao {
	String getMenuName(Integer id);
	List<Menu> getMenuList(String menu_type,Integer shop_id);
	boolean addMenuPrice(List<Menu> list,Integer shop_id);
	List<Menu> searchResulMenuList(Integer shop_id);
}
