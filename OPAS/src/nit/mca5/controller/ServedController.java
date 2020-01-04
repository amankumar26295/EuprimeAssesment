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

@WebServlet("/served")
public class ServedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shop_id_str=request.getParameter("shop_id");
		Integer shop_id=Integer.parseInt(shop_id_str);
		String action=request.getParameter("action");
		
		OrderDao dao = DaoFactory.getOrderDao();
		
		List<Order> list=null;
		
		if(action.equals("served")){
			list = dao.getServedOrder(shop_id);
			request.setAttribute("action1", "yes");
		}else{
			list = dao.getWaitingOrder(shop_id);
			request.setAttribute("action2", "yes");
		}
		
		
		
		request.setAttribute("shop_name",DaoFactory.getShopDao().getName(shop_id));
		
		List<Display> disp = new ArrayList<Display>();
		
		for(Order order:list){
			String user_name=DaoFactory.getUserDao().getUserName(order.getUser_id());
			String service_name=order.getService_name();
			Integer request_id=order.getRequest_id();
			Integer time=order.getTime_int();
			Integer rating=order.getRating();
			Display dis = new Display(user_name,service_name,request_id,action,time);
			dis.setRating(rating);
			disp.add(dis);
		}
		
		request.setAttribute("dispList", disp);
		
		RequestDispatcher rd = request.getRequestDispatcher("ShopkeeperHome2.jsp");
		request.setAttribute("shop_id",shop_id_str);
		rd.forward(request, response);
		
	}

}
