package nit.mca5.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nit.mca5.dao.ShopDao;
import nit.mca5.pojo.Shop;
import nit.mca5.util.DbUtil;


public class ShopDaoImpl implements ShopDao {

	@Override
	public boolean addShop(Shop shop) {
		
		boolean added=false;
		
		Connection con=null;
		PreparedStatement  pstmt=null;

		 try {
			 con  = DbUtil.getConnection();
			 String sql  ="insert into opas_shop(id,shop_type,shop_name,owner_id,email_id,mobile_no,city,locality,gst_no,open)values(shop_sequence.nextval,?,?,?,?,?,?,?,?,?)";
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setString(1, shop.getShop_type());
			 pstmt.setString(2, shop.getShop_name().toLowerCase());
			 pstmt.setInt(3, shop.getOwner_id());
			 pstmt.setString(4, shop.getEmail_id());
			 pstmt.setString(5, shop.getMobile_number());
			 pstmt.setString(6, shop.getCity());
			 pstmt.setString(7, shop.getLocality().toLowerCase());
			 pstmt.setString(8, shop.getGst_no());
			 pstmt.setString(9, shop.getOpen());
			
			 int i=pstmt.executeUpdate();
			 
			 if(i==1) {
				added=true;
			 }else{
				 System.out.println("error adding shop");
			 }
		 
		 } catch (Exception e) {
			 e.printStackTrace();
		}finally {
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return added;
	}

	@Override
	public List<Shop> getAllShop(Integer owner_id) {
		List<Shop> list = new ArrayList<Shop>();
		
		Connection con=null;
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		
		 try {
			 con  = DbUtil.getConnection();
			 String sql  ="select * from opas_shop where owner_id=?";
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setInt(1, owner_id);
			
			
			 rs=pstmt.executeQuery();
			 
			 while(rs.next()){
				 Integer id=rs.getInt("id");
					String shop_type=rs.getString("shop_type");
					String shop_name=rs.getString("shop_name");
				   	String email_id=rs.getString("email_id");
					String mobile_number=rs.getString("mobile_no");
				 	String city=rs.getString("city");
				   	String locality=rs.getString("locality");
				   	String gst_no=rs.getString("gst_no");
				   	Float rating=rs.getFloat("rating");
				   	String open=rs.getString("open");
				   	
				   	Shop shop = new Shop(id,shop_type, shop_name, owner_id, email_id, mobile_number, city, locality, gst_no,rating,open);
				   	list.add(shop);
			 }
			
		 } catch (Exception e) {
			 e.printStackTrace();
		}finally {
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Shop> searchShop(String type, String locality) {
		List<Shop> list = new ArrayList<Shop>();
		
		Connection con=null;
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		
		 try {
			 con  = DbUtil.getConnection();
			 String sql  ="select * from opas_shop where shop_type like lower(?) and locality like lower(?) or shop_type='both' and locality like lower(?)";
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setString(1, type);
			 pstmt.setString(2, locality);
			 pstmt.setString(3, locality);
			
			
			 rs=pstmt.executeQuery();
			 
			 while(rs.next()){
				 System.out.println("done");
				 	Integer id=rs.getInt("id");
					String shop_type=rs.getString("shop_type");
					String shop_name=rs.getString("shop_name");
				   	String email_id=rs.getString("email_id");
					String mobile_number=rs.getString("mobile_no");
					Float rate = rs.getFloat("rating");
				   	
				   	Shop shop = new Shop(id,shop_type, shop_name,email_id, locality,mobile_number,rate);
				   	list.add(shop);
			 }
			
		 } catch (Exception e) {
			 e.printStackTrace();
		}finally {
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public String getName(Integer id) {
		

		String name=null;
		
		Connection con  = null;
		 PreparedStatement pstmt  =null;
		 ResultSet rs = null;
		 try {
			 con  = DbUtil.getConnection();
			 String sql ="select shop_name from opas_shop where id=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			 rs  =pstmt.executeQuery();
			 if(rs.next()) {
				name=rs.getString("shop_name");
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		 
		return name;
	}

	@Override
	public boolean rate(Integer shop_id, float rate) {
		boolean a=false;
		
		Connection con=null;
		PreparedStatement  pstmt=null;
	
		String sql;
		 try {
			 con  = DbUtil.getConnection();
			 sql = "update opas_shop set  rating=? where id=?";
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setFloat(1,rate);
			 pstmt.setInt(2, shop_id);

			 int i=pstmt.executeUpdate();
			 
			 if(i==1){
				a=true;
			 }
			
		 } catch (Exception e) {
			 e.printStackTrace();
		}finally {
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return a;
	}
	
	

	@Override
	public List<Shop> getAllSearchShop() {
		List<Shop> list = new ArrayList<Shop>();
		
		Connection con=null;
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		
		 try {
			 con  = DbUtil.getConnection();
			 String sql  ="select * from opas_shop";
			 pstmt= con.prepareStatement(sql);
			
			 rs=pstmt.executeQuery();
			 
			 while(rs.next()){
				 	Integer shop_id=rs.getInt("id");
					String shop_type=rs.getString("shop_type");
					String shop_name=rs.getString("shop_name");
				 	String city=rs.getString("city");
				   	String locality=rs.getString("locality");
				   	Float rating=rs.getFloat("rating");
				   	
				   	Shop shop = new Shop(shop_id,shop_type, shop_name,city, locality,rating);
				   	list.add(shop);
			 }
			
		 } catch (Exception e) {
			 e.printStackTrace();
		}finally {
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}

	@Override
	public List<Shop> sort(String type) {
		List<Shop> list = new ArrayList<Shop>();

		
		Connection con=null;
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		String sql;
		 try {
			 con  = DbUtil.getConnection();
			 
			 if(type.equals("high")){
				 sql  ="select * from opas_shop order by rating desc";
			 }else{
				 sql  ="select * from opas_shop order by rating asc";
			 }
			 
			 pstmt= con.prepareStatement(sql);
			
			 rs=pstmt.executeQuery();
			 
			 while(rs.next()){
				 	Integer shop_id=rs.getInt("id");
					String shop_type=rs.getString("shop_type");
					String shop_name=rs.getString("shop_name");
				 	String city=rs.getString("city");
				   	String locality=rs.getString("locality");
				   	Float rating=rs.getFloat("rating");
				   	
				   	Shop shop = new Shop(shop_id,shop_type, shop_name,city, locality,rating);
				   	list.add(shop);
			 }
			
		 } catch (Exception e) {
			 e.printStackTrace();
		}finally {
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public boolean openCloseShop(Integer shop_id, String action) {
		
		boolean a=false;
		
		Connection con=null;
		PreparedStatement  pstmt=null;
	
		String sql;
		 try {
			 con  = DbUtil.getConnection();
			 sql = "update opas_shop set  open=? where id=?";
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setString(1,action);
			 pstmt.setInt(2, shop_id);

			 int i=pstmt.executeUpdate();
			 
			 if(i==1){
				a=true;
			 }
			
		 } catch (Exception e) {
			 e.printStackTrace();
		}finally {
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return a;
	}
	
	
}
