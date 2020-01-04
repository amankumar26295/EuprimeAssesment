package nit.mca5.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import nit.mca5.dao.AdminDao;
import nit.mca5.dao.UserDao;
import nit.mca5.dao.daoFactory.DaoFactory;
import nit.mca5.pojo.Admin;
import nit.mca5.pojo.User;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String role = request.getParameter("role");
		 String email_id = request.getParameter("email_id");
		 String password = request.getParameter("password");
	
		 User user=null;
		 Admin admn=null;
		 if(role.equals("user") || role.equals("shopkeeper")){
			 UserDao userDao  = DaoFactory.getUserDao();
			 user = userDao.validLogin(email_id, password,role);
			 //System.out.println(admn+" login ");
		 }else{
			 AdminDao adminDao  = DaoFactory.getAdminDao();
			 admn = adminDao.validLogin(email_id, password);
			 //System.out.println(user);
		 }
		 
		 if(user!=null) {
			 
			 	
			 	if(user.getRole().equals("shopkeeper")){
				 HttpSession session = request.getSession();
				 System.out.println("logged in successfully as shopkeeper");
				 session.setAttribute("shopkeeper", user);
				 response.sendRedirect("shoplist");
			 	}else{
			 		HttpSession session = request.getSession();
			 		session.setAttribute("customer", user);
			 		System.out.println("logged in successfully as customer");
			 		RequestDispatcher rd = request.getRequestDispatcher("CustomerHome.jsp");
				 	rd.forward(request, response);
			 	}
				 
		}else if(admn!=null){
				HttpSession session = request.getSession();
				session.setAttribute("admn", admn);
				RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
				rd.forward(request, response);
		 }else{
			 RequestDispatcher rd = request.getRequestDispatcher("redirect.jsp");
			 request.setAttribute("error_msg", "invalid email_id or password");
			 rd.forward(request, response);
		 }
	}
}//class

