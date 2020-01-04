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
import nit.mca5.pojo.User;

@WebServlet("/orderRequest")
public class OrderRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Integer shop_id=Integer.parseInt(request.getParameter("shop_id"));
		System.out.println(shop_id);
		Integer n=Integer.parseInt(request.getParameter("totalCount"));
		
		Integer totalP=0;
		StringBuffer sb = new StringBuffer("");
		
		for(int i=1;i<=n;i++){
			String menu_name=request.getParameter("menu"+i);
			String price=request.getParameter("price"+i);
			
			if(price!=null){
				Integer pri = Integer.parseInt(price);
				totalP+=pri;
				sb=sb.append(menu_name+", ");
			}
		}
		sb=sb.deleteCharAt(sb.length()-2);
		//System.out.println(totalP + " "+sb);
		
		OrderDao dao = DaoFactory.getOrderDao();
		
		User user=(User)request.getSession().getAttribute("customer");
		Integer user_id=user.getId();
		
		if(dao.requestOrder(shop_id, user_id, sb.toString(), totalP)){
			RequestDispatcher rd = request.getRequestDispatcher("redirect.jsp");
			request.setAttribute("order_placed","your order has been placed please wait for confirmation");
			rd.forward(request, response);
		}
	}
}
