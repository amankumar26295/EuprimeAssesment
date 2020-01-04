package nit.mca5.pojo;

public class User {
	
	
	String role;
	Integer id;
	String name;
 	String email_id;
  	String password;
  	String mobile_no;
  	String city;
  	String locality ;
	

  	public User(){};
  	
  	public User(Integer id, String name, String email_id, String mobile_no,
			String city, String locality,String role) {
		super();
		this.id = id;
		this.name = name;
		this.email_id = email_id;
		this.mobile_no = mobile_no;
		this.city = city;
		this.locality = locality;
		this.role = role;
	}
	public User(String role, String name, String email_id, String password,
			String mobile_no, String city, String locality) {
		super();
		this.role = role;
		this.name = name;
		this.email_id = email_id;
		this.password = password;
		this.mobile_no = mobile_no;
		this.city = city;
		this.locality = locality;
	}
	
	
	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String phone) {
		this.mobile_no = phone;
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
}	
