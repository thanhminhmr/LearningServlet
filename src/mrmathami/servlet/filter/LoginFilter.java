package mrmathami.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		if (request.getRequestURI().startsWith("/static/")) {
			filterChain.doFilter(servletRequest, servletResponse);
			return;
		}

		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			filterChain.doFilter(servletRequest, servletResponse);
			return;
		}

		if (request.getServletPath().equals("/login")) {
			filterChain.doFilter(servletRequest, servletResponse);
			return;
		}

		session.setAttribute("redirectUrl", request.getRequestURI());
		System.out.println(request.getRequestURI());
		response.sendRedirect("/login");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
