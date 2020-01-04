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

@WebServlet("/reset2")
public class PwdResetController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//User user=(User)request.getSession().getAttribute("temp_user");
		
		String user_otp=request.getParameter("user_otp");
		String otp=(String)request.getSession().getAttribute("otp");
		
		if(user_otp.trim().equalsIgnoreCase(otp)){
	
			RequestDispatcher rd = request.getRequestDispatcher("resetPass.jsp");
			rd.forward(request, response);
			
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("otp2.jsp");
			request.setAttribute("otp_error_msg", "OTP is Wrong");
			rd.forward(request, response);
		}
	}

}
