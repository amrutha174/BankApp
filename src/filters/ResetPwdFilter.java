package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class ResetPwdFilter
 */
@WebFilter({"/ResetPwd"})
public class ResetPwdFilter implements Filter {

	/**
	 * Default constructor. 
	 */
	public ResetPwdFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		String pwd = request.getParameter("pwd");
		String cpwd = request.getParameter("cpwd");
		if(pwd.equals(cpwd))
			chain.doFilter(request, response);
		else
			((HttpServletResponse) response).sendRedirect("/BankApp/resetPwdFail.jsp");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
