package nit.mca5.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nit.mca5.dao.OrderDao;
import nit.mca5.dao.daoFactory.DaoFactory;

@WebServlet("/service")
public class ServiceCompletedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer request_id = Integer.parseInt(request.getParameter("request_id"));
		
		OrderDao dao = DaoFactory.getOrderDao();
		
		if(dao.serviceOrder(request_id)){
			RequestDispatcher rd = request.getRequestDispatcher("ShopkeeperHome2.jsp");
			String shop_id = ((String)request.getSession().getAttribute("shop_id"));
			System.out.println(shop_id+" cccccccccccc");
			request.setAttribute("shop_id", shop_id);
			rd.forward(request, response);
		}
	}

}
