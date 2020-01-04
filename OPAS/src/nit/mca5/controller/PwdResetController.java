package nit.mca5.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nit.mca5.dao.UserDao;
import nit.mca5.dao.daoFactory.DaoFactory;
import nit.mca5.pojo.User;
import nit.mca5.util.EmailUtil;
import nit.mca5.util.OtpGenerator;

@WebServlet("/reset")
public class PwdResetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email_id=request.getParameter("email_id");
		String role=request.getParameter("role");
		
		User user = new User();
		user.setEmail_id(email_id);
		user.setRole(role);
		
		UserDao dao = DaoFactory.getUserDao();
		
		if(dao.isUserExist(role, email_id)){
			HttpSession session=request.getSession();
			session.setAttribute("temp_user", user);
			
			String msg=""+OtpGenerator.generateOtp();
			String subject="otp for email verification";
			
			try {
			
				if(EmailUtil.sendEmail(email_id, msg, subject)){
					session=request.getSession();
					session.setAttribute("otp", msg);
					
					RequestDispatcher rd = request.getRequestDispatcher("otp2.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("email sending problem");
				}	
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("redirect.jsp");
			request.setAttribute("not_exists", "enter valid email_id and role");
			rd.forward(request, response);
			
		}
	}

}
