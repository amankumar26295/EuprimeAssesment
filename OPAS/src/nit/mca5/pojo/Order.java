package nit.mca5.pojo;

import java.sql.Timestamp;


public class Order {
	
	Integer request_id;
	Integer user_id;
	Integer shop_id;
	Integer time_int;
	String 	status;
	Integer service_id;
	Integer price;
	String Service_name;
	Timestamp t1;
	String shop_name;
	Integer rating;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(Integer request_id, Integer shop_id, Integer time_int,
			Integer price, String service_name) {
		super();
		this.request_id = request_id;
		this.shop_id = shop_id;
		this.time_int = time_int;
		this.price = price;
		Service_name = service_name;
	}
	

	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getService_name() {
		return Service_name;
	}
	public void setService_name(String service_name) {
		Service_name = service_name;
	}
	public Integer getRequest_id() {
		return request_id;
	}
	public void setRequest_id(Integer request_id) {
		this.request_id = request_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getShop_id() {
		return shop_id;
	}
	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	public Integer getTime_int() {
		return time_int;
	}
	public void setTime_int(Integer time_int) {
		this.time_int = time_int;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getService_id() {
		return service_id;
	}
	public void setService_id(Integer service_id) {
		this.service_id = service_id;
	}

	public Timestamp getT1() {
		return t1;
	}

	public void setT1(Timestamp t1) {
		this.t1 = t1;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
