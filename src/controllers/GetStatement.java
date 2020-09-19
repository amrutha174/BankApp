package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;


@WebServlet("/GetStatement")
public class GetStatement extends HttpServlet
{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String accno = (String) session.getAttribute("accno");
		
		Model m = new Model();
		m.setAccno(accno);
		ArrayList al = m.getStatement();
		if(al.isEmpty())
			response.sendRedirect("/BankApp/getStatementFail.jsp");
		else
		{
			session.setAttribute("al", al);
			response.sendRedirect("/BankApp/getStatement.jsp");
		}
	}
}
