package nit.mca5.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nit.mca5.dao.UserDao;
import nit.mca5.pojo.User;
import nit.mca5.util.DbUtil;

public class UserDaoImpl implements UserDao{
	
	@Override
	public boolean isUserExist(String email_id) {
		boolean isExist=false;
		
		Connection con=null;
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		
		 try {
			 con  = DbUtil.getConnection();
			 String sql  ="select * from opas_user where email_id=?";
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setString(1, email_id);
			
			 rs=pstmt.executeQuery();
			 if(rs.next()) {
				 isExist=true;
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
		
		return isExist;
	}
	
	
	@Override
	public boolean isUserExist(String role, String email_id) {
boolean isExist=false;
		
		Connection con=null;
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		
		 try {
			 con  = DbUtil.getConnection();
			 String sql  ="select * from opas_user where email_id=? and role=?";
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setString(1, email_id);
			 pstmt.setString(2, role);
			
			 rs=pstmt.executeQuery();
			 if(rs.next()) {
				 isExist=true;
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
		
		return isExist;
	}
	
	@Override
	public User validLogin(String logingId, String loginPassword,String role) {
		User user  = null;
		Connection con  = null;
		 PreparedStatement pstmt  =null;
		 ResultSet rs = null;
		 try {
			con  = DbUtil.getConnection();
			String sql ="select * from opas_user where email_id=? and password=? and role=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, logingId);
			pstmt.setString(2, loginPassword);
			pstmt.setString(3, role);
			 rs  =pstmt.executeQuery();
			 if(rs.next()) {
				 role=rs.getString("role");
				 Integer id = rs.getInt("id");
				 String name  = rs.getString("name");
				 String email_id  = rs.getString("email_id");
				 String mobile_no = rs.getString("mobile_no");
				 String city  = rs.getString("city");
				 String locality  = rs.getString("locality");
				
				 user = new User(id, name, email_id, mobile_no, city, locality,role);
				 
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
		 
		return user;
	}
	
	public boolean add(User user) {
		boolean isAdded=false;
		
		 Connection con  = null;
		 PreparedStatement  pstmt  =null;
		 
		 try {
			 con  = DbUtil.getConnection();
			 String sql  ="insert into  opas_user(ID,NAME,EMAIL_id,PASSWORD,mobile_no,city,locality,role) values(user_sequence.nextval,?,?,?,?,?,?,?)";
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setString(1, user.getName());
			 pstmt.setString(2, user.getEmail_id());
			 pstmt.setString(3, user.getPassword());
			 pstmt.setString(4, user.getMobile_no());
			 pstmt.setString(5, user.getCity());
			 pstmt.setString(6, user.getLocality());
			 pstmt.setString(7, user.getRole());
			 
			 if(pstmt.executeUpdate()==1) {
				 isAdded=true;
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
		
		
		return isAdded;
	}
	

	@Override
	public String getUserName(Integer id) {
		
		String name=null;
		
		Connection con  = null;
		 PreparedStatement pstmt  =null;
		 ResultSet rs = null;
		 try {
			 con  = DbUtil.getConnection();
			 String sql ="select name from opas_user where id=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			 rs  =pstmt.executeQuery();
			 if(rs.next()) {
				name=rs.getString("name");
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
	public boolean updatePassword(String email_id, String role, String password) {
		boolean isAdded=false;
		
		 Connection con  = null;
		 PreparedStatement  pstmt  =null;
		 
		 try {
			 con  = DbUtil.getConnection();
			 String sql  ="update table opas_user set password=? where email_id=? and role=?";
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setString(1, password);
			 pstmt.setString(2, email_id);
			 pstmt.setString(3, role);
			
			 if(pstmt.executeUpdate()==1) {
				 isAdded=true;
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
		
		
		return isAdded;
	}

	

	
	
}
