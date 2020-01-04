package nit.mca5.controller;

import java.io.IOException;




import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nit.mca5.dao.ShopDao;
import nit.mca5.dao.daoFactory.DaoFactory;
import nit.mca5.pojo.Shop;

@WebServlet("/intialSearch")
public class InitialSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShopDao dao = DaoFactory.getShopDao();
		
		List<Shop> list = dao.getAllSearchShop();
		
		if(list!=null){
			RequestDispatcher rd = request.getRequestDispatcher("seachResult.jsp");
			request.setAttribute("search_shop_list", list);
			rd.forward(request, response);
		}
	}

	

}
