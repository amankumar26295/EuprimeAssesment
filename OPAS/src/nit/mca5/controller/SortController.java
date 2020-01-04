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

@WebServlet("/sortController")
public class SortController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		
		ShopDao dao = DaoFactory.getShopDao();
		
		List<Shop> list = dao.sort(type);
		
		if(list!=null){
			RequestDispatcher rd= request.getRequestDispatcher("seachResult.jsp");
			request.setAttribute("search_shop_list", list);
			rd.include(request, response);
		}
	}

}
