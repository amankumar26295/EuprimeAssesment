package nit.mca5.dao;

import java.sql.Timestamp;
import java.util.List;

import nit.mca5.pojo.Order;

public interface OrderDao {
	List<Order> getServedOrder(Integer shop_id);
	List<Order> getWaitingOrder(Integer shop_id);
	List<Order> getUserServedOrder(Integer user_id);
	List<Order> getUserWaitingOrder(Integer user_id);
	//List<Order> getServedOrder(Integer shop_id);
	boolean updateOrder(Integer request_id,String status,Integer time,Timestamp t1);
	boolean requestOrder(Integer shop_id,Integer user_id,String service_name,Integer price);
	boolean serviceOrder(Integer request_id);
	boolean rate(Integer rate,Integer request_id);
	float rateSum(Integer shop_id);
}
