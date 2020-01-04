package nit.mca5.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nit.mca5.dao.OrderDao;
import nit.mca5.dao.daoFactory.DaoFactory;
import nit.mca5.pojo.Display;
import nit.mca5.pojo.Order;

@WebServlet("/userServed")
public class UserServedCOntroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id=Integer.parseInt(request.getParameter("user_id"));
		String action=request.getParameter("action");
		
		//System.out.println(id+ " "+action);
		
		OrderDao dao = DaoFactory.getOrderDao();
		
		List<Order> list=null;
		
		if(action.equals("served")){
			list = dao.getUserServedOrder(id);
		}else{
			list = dao.getUserWaitingOrder(id);
		}
		
		request.setAttribute("user_name",DaoFactory.getUserDao().getUserName(id));
		
		List<Display> disp = new ArrayList<Display>();
		
		for(Order order:list){
			String shop_name=DaoFactory.getShopDao().getName(order.getShop_id());
			String service_name=order.getService_name();
			Integer request_id=order.getRequest_id();
			Integer time=order.getTime_int();
			Integer price=order.getPrice();
			
			Display dis = new Display(shop_name,service_name,request_id,time,price);
			
			disp.add(dis);
		}
		
		request.setAttribute("dispList1", disp);
		RequestDispatcher rd = request.getRequestDispatcher("customerOrder.jsp");
		rd.forward(request, response);

	}
}
