package nit.mca5.pojo;

public class Menu {
	
	public Menu(String menu_name, Integer price) {
		super();
		this.menu_name = menu_name;
		this.price = price;
	}

	public Menu(Integer menu_id, String menu_name, Integer price) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.price = price;
	}

	Integer menu_id;
	String menu_name;
	String menu_type;
	Integer price;
	
	
	public Menu() {
		super();
	}
	
	public Menu(Integer menu_id, String menu_name, String menu_type) {
		super();
		this.menu_id = menu_id;
		this.menu_name = menu_name;
		this.menu_type = menu_type;
	}
	
	public Menu(Integer menu_id,Integer price) {
		super();
		this.menu_id = menu_id;
		this.price = price;
	}

	
	public Integer getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_type() {
		return menu_type;
	}

	public void setMenu_type(String menu_type) {
		this.menu_type = menu_type;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
}
