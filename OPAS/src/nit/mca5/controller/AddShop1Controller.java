package nit.mca5.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nit.mca5.dao.ShopDao;
import nit.mca5.dao.daoFactory.DaoFactory;
import nit.mca5.pojo.Shop;
import nit.mca5.pojo.User;


@WebServlet("/addShop1")
public class AddShop1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String shop_type = request.getParameter("shop_type");
		 String shop_name = request.getParameter("shop_name");
		 String email_id = request.getParameter("shop_email_id");
		 String mobile_no = request.getParameter("shop_mobile_no");
		 String city = request.getParameter("city");
		 String locality = request.getParameter("locality");
		 String gst_no = request.getParameter("gst_no");
		 String open="n";
		 User user = (User)request.getSession().getAttribute("shopkeeper");
		 Integer owner_id=user.getId();
		 
		 Shop shop = new Shop(shop_type,shop_name,owner_id,email_id,mobile_no,city, locality, gst_no,open);
		 
		 ShopDao shopdao = DaoFactory.getShopDao();
		 
		
		 
		 if(shopdao.addShop(shop)){
			 /*RequestDispatcher rd = request.getRequestDispatcher("shoplist");
			 rd.forward(request, response);*/
			 response.sendRedirect("shoplist");
		 }else{
			 System.out.println("error");
		 }
		 
	}

}
