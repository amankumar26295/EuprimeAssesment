package nit.mca5.pojo;

import java.util.List;

public class Shop {
	
	Integer id;
	String shop_type;
	String shop_name;
	Integer owner_id;
   	String email_id ;
	String mobile_number;
 	String city ;
   	String locality;
   	String gst_no;
   	Float rating;
   	String open;
   	List<User> service_list;
   	
   	public Shop() {
		super();
	}
   	public Shop(Integer id, String shop_type, String shop_name, String city,
			String locality, Float rating) {
		super();
		this.id = id;
		this.shop_type = shop_type;
		this.shop_name = shop_name;
		this.city = city;
		this.locality = locality;
		this.rating = rating;
	}
   	public Shop(Integer id, String shop_type, String shop_name,
			Integer owner_id, String email_id, String mobile_number,
			String city, String locality, String gst_no,Float rating,String open) {
		super();
		this.id = id;
		this.shop_type = shop_type;
		this.shop_name = shop_name;
		this.owner_id = owner_id;
		this.email_id = email_id;
		this.mobile_number = mobile_number;
		this.city = city;
		this.locality = locality;
		this.gst_no = gst_no;
		this.rating=rating;
		this.open=open;
	}
   	
   	public Shop(String shop_type, String shop_name,
			Integer owner_id, String email_id, String mobile_number,
			String city, String locality, String gst_no,String open) {
		super();
		this.shop_type = shop_type;
		this.shop_name = shop_name;
		this.owner_id = owner_id;
		this.email_id = email_id;
		this.mobile_number = mobile_number;
		this.city = city;
		this.locality = locality;
		this.gst_no = gst_no;
		this.open=open;
	}
	
	public Shop(Integer id, String shop_type, String shop_name,
			String email_id,String locality, String mobile_number,Float rating) {
		this.id=id;
		this.shop_type=shop_type;
		this.shop_name=shop_name;
		this.email_id=email_id;
		this.mobile_number=mobile_number;
		this.locality=locality;
		this.rating=rating;
	}

	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getShop_type() {
		return shop_type;
	}
	public void setShop_type(String shop_type) {
		this.shop_type = shop_type;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public Integer getOwner_id() {
		return owner_id;
	}
	public void setOwner_id(Integer owner_id) {
		this.owner_id = owner_id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getGst_no() {
		return gst_no;
	}
	public void setGst_no(String gst_no) {
		this.gst_no = gst_no;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}
	public List<User> getService_list() {
		return service_list;
	}
	public void setService_list(List<User> service_list) {
		this.service_list = service_list;
	}
	
}
