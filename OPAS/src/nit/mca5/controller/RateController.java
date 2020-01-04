package nit.mca5.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nit.mca5.dao.OrderDao;
import nit.mca5.dao.ShopDao;
import nit.mca5.dao.daoFactory.DaoFactory;

@WebServlet("/rateController")
public class RateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rate=request.getParameter("rate");
		Integer request_id=Integer.parseInt(request.getParameter("request_id"));
		Integer shop_id=Integer.parseInt(request.getParameter("shop_id"));
		
		if(rate!=null){
			Integer rateInt = Integer.parseInt(rate);
			
			OrderDao dao = DaoFactory.getOrderDao();
			
			if(dao.rate(rateInt, request_id)){
				
				float rateSum = dao.rateSum(shop_id);
				
				ShopDao dao2 = DaoFactory.getShopDao();
				
				if(dao2.rate(shop_id, rateSum)){
					RequestDispatcher rd = request.getRequestDispatcher("CustomerHome.jsp");
					rd.forward(request, response);
				}
			}
			
		}else{
			
			OrderDao dao = DaoFactory.getOrderDao();
			
			if(dao.rate(0, request_id)){
				
				float rateSum = dao.rateSum(shop_id);
				
				ShopDao dao2 = DaoFactory.getShopDao();
				
				if(dao2.rate(shop_id, rateSum)){
					RequestDispatcher rd = request.getRequestDispatcher("CustomerHome.jsp");
					rd.forward(request, response);
				}
			}
		}
	}

}
