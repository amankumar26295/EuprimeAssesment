package nit.mca5.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nit.mca5.dao.UserDao;
import nit.mca5.dao.daoFactory.DaoFactory;
import nit.mca5.pojo.User;

@WebServlet("/reset3")
public class PwdResetController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("temp_user");
		
		String email_id=user.getEmail_id();
		String role=user.getRole();
		String pass1=request.getParameter("pass1");
		String pass2=request.getParameter("pass2");
		
		if(pass1.equals(pass2)){
			UserDao dao = DaoFactory.getUserDao();
			
			if(dao.updatePassword(email_id, role, pass1)){
				RequestDispatcher rd = request.getRequestDispatcher("redirect.jsp");
				request.setAttribute("pwd_rst", "your password has been successfully updated");
				rd.forward(request, response);
			}
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("resetPass.jsp");
			request.setAttribute("pwd_not_match", "your password didn't match");
			rd.forward(request, response);
		}
		
	}

}
