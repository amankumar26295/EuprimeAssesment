package nit.mca5.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import nit.mca5.dao.OrderDao;
import nit.mca5.pojo.Order;
import nit.mca5.util.DbUtil;

public class OrderDaoImpl implements OrderDao{

	@Override
	public List<Order> getServedOrder(Integer shop_id) {
		List<Order> list = new ArrayList<Order>();
		
		Connection con=null;
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		
		 try {
			 con  = DbUtil.getConnection();
			 String sql  ="select * from ordertable where shop_id=? and status='served'";
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setInt(1, shop_id);
			
			
			 rs=pstmt.executeQuery();
			 
			 while(rs.next()){
				 Integer request_id=rs.getInt("request_id");
				 Integer user_id=rs.getInt("user_id");
				 String service_name=rs.getString("service_name");
				 Integer time=rs.getInt("time_int");
				 Integer rating = rs.getInt("rating");
			
				Order order = new Order();
				order.setRequest_id(request_id);
				order.setUser_id(user_id);
				order.setService_name(service_name);
				order.setTime_int(time);
				order.setRating(rating);
				
				list.add(order);
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
	public boolean updateOrder(Integer request_id, String status,Integer time,Timestamp t1) {
		boolean a=false;
		
		Connection con=null;
		PreparedStatement  pstmt=null;
		System.out.println(request_id);
		String sql;
		 try {
			 con  = DbUtil.getConnection();
			 if(status.equals("accept")){
				 sql  ="update ordertable set status='waiting', time_int=?, order_time=? where request_id=?";
			 }else{
				 sql  ="update ordertable set status='rejected', time_int=?, order_time=? where request_id=?";
			 }
			 
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setInt(1, time);
			 pstmt.setTimestamp(2, t1);
			 pstmt.setInt(3, request_id);
			
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
	public List<Order> getWaitingOrder(Integer shop_id) {
		List<Order> list = new ArrayList<Order>();
		
		Connection con=null;
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		
		 try {
			 con  = DbUtil.getConnection();
			 String sql  ="select * from ordertable where shop_id=? and status='waiting'";
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setInt(1, shop_id);
			
			
			 rs=pstmt.executeQuery();
			 
			 while(rs.next()){
				 Integer request_id=rs.getInt("request_id");
				 Integer user_id=rs.getInt("user_id");
				 String service_name=rs.getString("service_name");
				 Integer time=rs.getInt("time_int");
				 
				Order order = new Order();
				order.setRequest_id(request_id);
				order.setUser_id(user_id);
				order.setService_name(service_name);
				order.setTime_int(time);
				
				  list.add(order);
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
	public boolean requestOrder(Integer shop_id, Integer user_id,
		String service_name, Integer price) {

		boolean a=false;
		
		Connection con=null;
		PreparedStatement  pstmt=null;
	
		String sql;
		 try {
			 con  = DbUtil.getConnection();
			 sql = "insert into ordertable(request_id,shop_id,user_id,status,service_name,total_price) values(req_sequence.nextval,?,?,'requested',?,?)";
			 
			 
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setInt(1, shop_id);
			 pstmt.setInt(2, user_id);
			 pstmt.setString(3,service_name);
			 pstmt.setInt(4, price);
			
			
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
	public List<Order> getUserServedOrder(Integer user_id) {
		List<Order> list = new ArrayList<Order>();
		
		Connection con=null;
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		
		 try {
			 con  = DbUtil.getConnection();
			 String sql  ="select * from ordertable where user_id=? and status='served'";
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setInt(1, user_id);
			
			
			 rs=pstmt.executeQuery();
			 
			 while(rs.next()){
				 Integer request_id=rs.getInt("request_id");
				 Integer shop_id=rs.getInt("shop_id");
				 String service_name=rs.getString("service_name");
				 Integer price=rs.getInt("total_price");
				 Integer time=rs.getInt("time_int");
				
				 Order order = new Order();
				order.setRequest_id(request_id);
				order.setShop_id(shop_id);
				order.setService_name(service_name);
				order.setPrice(price);
				order.setTime_int(time);
				
				list.add(order);
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
	public List<Order> getUserWaitingOrder(Integer user_id) {
		List<Order> list = new ArrayList<Order>();
		
		Connection con=null;
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		
		 try {
			 con  = DbUtil.getConnection();
			 String sql  ="select * from ordertable where user_id=? and status='requested'";
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setInt(1, user_id);
			
			
			 rs=pstmt.executeQuery();
			 
			 while(rs.next()){
				 Integer request_id=rs.getInt("request_id");
				 Integer shop_id=rs.getInt("shop_id");
				 String service_name=rs.getString("service_name");
				 Integer price=rs.getInt("total_price");
				 Integer time=rs.getInt("time_int");
				
				 Order order = new Order();
				order.setRequest_id(request_id);
				order.setShop_id(shop_id);
				order.setService_name(service_name);
				order.setPrice(price);
				order.setTime_int(time);
				
				list.add(order);
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
	public boolean serviceOrder(Integer request_id) {

			boolean a=false;
			
			Connection con=null;
			PreparedStatement  pstmt=null;
		
			String sql;
			 try {
				 con  = DbUtil.getConnection();
				 sql = "update ordertable set  status='served' where request_id=?";
				 pstmt= con.prepareStatement(sql);
				 
				 pstmt.setInt(1, request_id);
				
				
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
	public boolean rate(Integer rate, Integer request_id) {
		boolean a=false;
		
		Connection con=null;
		PreparedStatement  pstmt=null;
	
		String sql;
		 try {
			 con  = DbUtil.getConnection();
			 sql = "update ordertable set  rating=? where request_id=?";
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setInt(1, rate);
			 pstmt.setInt(2, request_id);
			
			
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
	public float rateSum(Integer shop_id) {
		float sum=0;
		
		Connection con=null;
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		String sql;
		 try {
			 con  = DbUtil.getConnection();
			 sql = "select avg(rating) as avgRate from ordertable where shop_id=? and rating <> 0";
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setInt(1, shop_id);

			 rs=pstmt.executeQuery();
			 
			 if(rs.next()){
				sum=rs.getFloat("avgRate");
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
		
		return sum;
	}


}
