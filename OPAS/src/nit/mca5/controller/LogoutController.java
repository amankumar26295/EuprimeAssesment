package nit.mca5.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		if(session!=null){
			session.invalidate();
			System.out.println("logged out successfully");
			response.sendRedirect("home.jsp");
		}else{
			System.out.println("you are alraedy logged out");
			response.sendRedirect("home.jsp");
		}
		
	}

}
