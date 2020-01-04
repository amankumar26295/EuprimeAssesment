package nit.mca5.dao.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nit.mca5.pojo.Menu;
import nit.mca5.dao.MenuDao;
import nit.mca5.util.DbUtil;

public  class MenuDaoImpl implements MenuDao {

	@Override
	public String getMenuName(Integer id) {

		String name=null;
		
		Connection con  = null;
		 PreparedStatement pstmt  =null;
		 ResultSet rs = null;
		 try {
			 con  = DbUtil.getConnection();
			 String sql ="select menu_name from menutable where menu_id=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			 rs  =pstmt.executeQuery();
			 if(rs.next()) {
				name=rs.getString("menu_name");
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
	public List<Menu> getMenuList(String menu_type,Integer shop_id) {
		
		List<Menu> list = new ArrayList<Menu>();
		
		Connection con=null;
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		String sql=null;
		 try {
			 con  = DbUtil.getConnection();
			 if(menu_type.equals("both")){
				 menu_type="women";
				 sql = "select a.menu_id,a.menu_name,b.price from menutable a left join (select * from menutable2  where shop_id=?) b on a.menu_id=b.menu_id where a.menu_type='men' or menu_type=?";
			 }else{
				 sql = "select a.menu_id,a.menu_name,b.price from menutable a left join (select * from menutable2  where shop_id=?) b on a.menu_id=b.menu_id where a.menu_type=?";
			 }
			
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setInt(1, shop_id);
			 pstmt.setString(2, menu_type);
			
			 rs=pstmt.executeQuery();
			 
			 while(rs.next()){
				 
				 	Integer id=rs.getInt("menu_id");
					String menu_name=rs.getString("menu_name");
					Integer price=rs.getInt("price");
				   	
				   	Menu menu = new Menu(id,menu_name,price);
				   	list.add(menu);
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
	public boolean addMenuPrice(List<Menu> list,Integer shop_id) {
		boolean a=false;
		
		Connection con=null;
		PreparedStatement  pstmt=null;
		
		 try {
			 con  = DbUtil.getConnection();
			 String sql = "delete from menutable2 where shop_id=?";
			 pstmt = con.prepareStatement(sql);
			 pstmt.setInt(1, shop_id);
			 pstmt.executeUpdate();
			 
			 sql  ="insert into menutable2 values(?,?,?)";
			 pstmt= con.prepareStatement(sql);
			 
			 for(Menu m:list){
				 pstmt.setInt(1, shop_id);
				 pstmt.setInt(2, m.getMenu_id());
				 pstmt.setInt(3,m.getPrice());
				 pstmt.addBatch();
			 }
			 
			 int[] i = pstmt.executeBatch();
			 
			
			
		 } catch (Exception e) {
			 e.printStackTrace();
		}finally {
			try {
				DbUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public List<Menu> searchResulMenuList(Integer shop_id) {
		List<Menu> list = new ArrayList<Menu>();
		
		Connection con=null;
		PreparedStatement  pstmt=null;
		ResultSet rs=null;
		
		 try {
			 con  = DbUtil.getConnection();
			 String sql  ="select a.menu_name,b.price from menutable a left join menutable2 b on a.menu_id=b.menu_id where b.shop_id=?";
			 pstmt= con.prepareStatement(sql);
			 
			 pstmt.setInt(1, shop_id);
			
			 rs=pstmt.executeQuery();
			 
			 while(rs.next()){
				 
					String menu_name=rs.getString("menu_name");
					Integer price=rs.getInt("price");
				   	
				   	Menu menu = new Menu(menu_name,price);
				   	list.add(menu);
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

}
