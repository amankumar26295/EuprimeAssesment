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

import nit.mca5.dao.MenuDao;
import nit.mca5.dao.daoFactory.DaoFactory;
import nit.mca5.pojo.Menu;

@WebServlet("/addmenu2")
public class AddMenuController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n=Integer.parseInt(request.getParameter("totalCount"));
		System.out.println("totalCount = "+n);
		
		List<Menu> list = new ArrayList<Menu>();
		for(int i=1;i<=n;i++){
			Integer menu_id=Integer.parseInt(request.getParameter("menu"+i));
			String priceStr=request.getParameter("price"+i);
			
			if(priceStr!=""){
				Integer price=Integer.parseInt(priceStr);
				Menu menu=new Menu(menu_id, price);
				list.add(menu);
			}
		}
		
		Integer shop_id=(Integer)request.getSession().getAttribute("shop_id");
		
		MenuDao dao = DaoFactory.getMenuDao();
		
		if(dao.addMenuPrice(list, shop_id)){
			RequestDispatcher rd = request.getRequestDispatcher("redirect.jsp");
			request.setAttribute("menu_updated", "Your menu is updated successfully");
			rd.forward(request, response);
		}else{
			System.out.println("not done");
		}
	}

}
