package nit.mca5.pojo;

public class Admin {
	
	String name;
	String email_id;
	String password;
	//String mobile_number;
	
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String name) {
		super();
		this.name = name;
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
}
