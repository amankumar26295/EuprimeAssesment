package nit.mca5.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nit.mca5.dao.OrderDao;
import nit.mca5.dao.daoFactory.DaoFactory;

@WebServlet("/order11")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer time=0;
		String status=request.getParameter("s");
		Integer request_id=Integer.parseInt(request.getParameter("request_id"));
		if(status.equals("accept"))
			time=Integer.parseInt(request.getParameter("time"));
		
		java.util.Date d1=new java.util.Date();
		Timestamp t1 = new Timestamp(d1.getTime()+time*60*1000);
		
		OrderDao dao = DaoFactory.getOrderDao();

		if(dao.updateOrder(request_id, status,time,t1)){
			RequestDispatcher rd = request.getRequestDispatcher("ShopkeeperHome2.jsp");
			String shop_id_str=(String)request.getSession().getAttribute("shop_id");
			request.setAttribute("shop_id", shop_id_str);
			rd.forward(request, response);
		}else{
			System.out.println("error updating order");
		}
		
	}


}
