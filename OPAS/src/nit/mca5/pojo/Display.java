package nit.mca5.pojo;

public class Display {
	
	String shop_name;
	String user_name;
	String service_name;
	Integer request_id;
	String status;
	Integer time_int;
	Integer price;
	Integer rating;
	
	public Display(String user_name, String service_name, Integer request_id,String status,Integer time_int) {
		super();
		this.user_name = user_name;
		this.service_name = service_name;
		this.request_id = request_id;
		this.status = status;
		this.time_int = time_int;
	}
	
	public Display(String shop_name, String service_name, Integer request_id,
			Integer time_int,Integer price) {
		super();
		this.shop_name = shop_name;
		this.service_name = service_name;
		this.request_id = request_id;
		this.time_int = time_int;
		this.price=price;
	}

	public String getShop_name() {
		return shop_name;
	}

	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public Integer getRequest_id() {
		return request_id;
	}
	public void setRequest_id(Integer request_id) {
		this.request_id = request_id;
	}
	public String getStatus() {
		return status;
	}

	public Integer getTime_int() {
		return time_int;
	}

	public void setTime_int(Integer time_int) {
		this.time_int = time_int;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
}
