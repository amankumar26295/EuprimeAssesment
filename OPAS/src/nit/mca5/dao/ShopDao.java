package nit.mca5.dao;

import java.util.List;

import nit.mca5.pojo.Shop;

public interface ShopDao {
	boolean addShop(Shop shop);
	List<Shop> getAllShop(Integer owner_id);
	List<Shop> getAllSearchShop();
	List<Shop> searchShop(String type,String locality);
	String getName(Integer id);
	boolean rate(Integer shop_id,float rate);
	List<Shop> sort(String type);
	boolean openCloseShop(Integer shop_id,String action);
}
