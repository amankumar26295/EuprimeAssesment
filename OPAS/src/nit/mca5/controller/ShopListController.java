package nit.mca5.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nit.mca5.dao.daoFactory.DaoFactory;
import nit.mca5.pojo.Shop;
import nit.mca5.pojo.User;

@WebServlet("/shoplist")
public class ShopListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User user = (User)request.getSession().getAttribute("shopkeeper");
		List<Shop> list = DaoFactory.getShopDao().getAllShop(user.getId());
		
		request.getSession().setAttribute("shop_list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("ShopkeeperHome.jsp");
		rd.forward(request, response);
	}

}
