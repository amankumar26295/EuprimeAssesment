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

@WebServlet("/OpenCloseShop")
public class OpenCloseShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		Integer shop_id=Integer.parseInt(request.getParameter("shop_id"));
		
		ShopDao dao = DaoFactory.getShopDao();
		
		if(dao.openCloseShop(shop_id, action)){
			/*RequestDispatcher rd = request.getRequestDispatcher("shoplist");
			rd.forward(request, response);*/
			response.sendRedirect("shoplist");
		}
	}

}
