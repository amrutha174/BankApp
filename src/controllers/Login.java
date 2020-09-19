package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;


@WebServlet("/Login")
public class Login extends HttpServlet
{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String cid = request.getParameter("cid");
		String pwd = request.getParameter("pwd");
		
		Model m = new Model();
		m.setCid(cid);
		m.setPwd(pwd);
		boolean status = m.login();
		if(status==true)
		{
			String accno = m.getAccno();
			String name = m.getName();
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("accno", accno);
			response.sendRedirect("/BankApp/home.jsp");
		}
		else
		{
			response.sendRedirect("/BankApp/loginFail.jsp");
		}
	}
}
