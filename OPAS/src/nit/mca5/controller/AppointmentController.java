package nit.mca5.controller;

import java.io.IOException;
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

@WebServlet("/appoint")
public class AppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer shop_id=Integer.parseInt(request.getParameter("shop_id"));
		//System.out.println(shop_id);
		
		MenuDao dao =DaoFactory.getMenuDao();
		
		List<Menu> list = dao.searchResulMenuList(shop_id);
		
		if(list!=null){
			RequestDispatcher rd = request.getRequestDispatcher("searchResult2.jsp");
			request.setAttribute("search_menu_list", list);
			request.setAttribute("shop_id", shop_id);
			rd.include(request, response);
		}else{
			System.out.println("done");
		}
	}

	
}
