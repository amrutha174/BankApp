package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

@WebServlet("/ResetPwd")
public class ResetPwd extends HttpServlet 
{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		String pwd = request.getParameter("pwd");
		
		Model m = new Model();
		m.setEmail(email);
		m.setPwd(pwd);
		boolean status = m.resetPwd();
		if(status==true)
			response.sendRedirect("/BankApp/resetPwdSuccess.jsp");
		else
			response.sendRedirect("/BankApp/resetPwdFail.jsp");
	}
}
