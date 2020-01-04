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

import nit.mca5.util.EmailUtil;
import nit.mca5.util.OtpGenerator;
import nit.mca5.dao.UserDao;
import nit.mca5.dao.daoFactory.DaoFactory;
import nit.mca5.pojo.User;

@WebServlet("/signup")
public class SignUpController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String role=request.getParameter("role");
		String  name  = request.getParameter("name");
		String  email_id  = request.getParameter("email_id");
		String  password  = request.getParameter("password");
		String  mobile_no  = request.getParameter("mobile_no");
		String  city  = request.getParameter("city");
		String  locality  = request.getParameter("locality");
		
		User user  = new User(role,name,email_id,password,mobile_no,city,locality);
		UserDao dao  = DaoFactory.getUserDao();
		
		if(dao.isUserExist(role, email_id)){
			RequestDispatcher rd = request.getRequestDispatcher("redirect.jsp");
			request.setAttribute("user_already_exist", "user already exixts with email_id : "+email_id+" and role : "+role);
			rd.forward(request, response);
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("temp_user", user);
			
			String msg=""+OtpGenerator.generateOtp();
			String subject="otp for email verification";
			
			try {
			
				if(EmailUtil.sendEmail(email_id, msg, subject)){
					session=request.getSession();
					session.setAttribute("otp", msg);
					
					RequestDispatcher rd = request.getRequestDispatcher("otp.jsp");
					rd.forward(request, response);
				}else{
					System.out.println("email sending problem");
				}	
			} catch (MessagingException e) {
				System.out.println("email id is wrong or connection not established");
			}
		}

	}

}
