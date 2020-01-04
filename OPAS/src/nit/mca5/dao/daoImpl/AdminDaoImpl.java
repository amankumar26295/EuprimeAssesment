package nit.mca5.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nit.mca5.dao.AdminDao;
import nit.mca5.pojo.Admin;
import nit.mca5.util.DbUtil;


public class AdminDaoImpl implements AdminDao {

		public Admin validLogin(String email_id, String password) {
			//System.out.println(logingId + loginPassword);
			Admin admn  = null;
			Connection con  = null;
			 PreparedStatement pstmt  =null;
			 ResultSet rs = null;
			 try {
				 con  = DbUtil.getConnection();
				 String sql ="select * from opas_admin where email_id=? and password=?";
				pstmt= con.prepareStatement(sql);
				pstmt.setString(1, email_id);
				pstmt.setString(2, password);
				//System.out.println(logingId + loginPassword);
				 rs  =pstmt.executeQuery();
				 if(rs.next()) {
					 //System.out.println("aaaaa");
					
					 String name  = rs.getString("name");
					
					 admn = new Admin(name);
				
				 }
				 //System.out.println(logingId + loginPassword);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					DbUtil.closeConnection(con);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				//System.out.println(admn+" dao ");
			return admn;
		}
}

