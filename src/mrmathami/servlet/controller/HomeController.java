package mrmathami.servlet.controller;

import mrmathami.servlet.model.dao.Users;
import mrmathami.servlet.model.data.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// empty username or password check
		if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
			request.setAttribute("isError", true);
			request.setAttribute("isEmptyUsernamePassword", true);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}

		// try login
		User requestingUser = new User(null, username, password, null);
		User foundUser = Users.getUser(requestingUser);
		if (foundUser == null) {
			request.setAttribute("isError", true);
			request.setAttribute("isLoginFailed", true);
			request.setAttribute("typedUsername", username);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}

		// login success
		HttpSession session = request.getSession(true);
		session.setAttribute("user", foundUser);

		String redirectUrl = (String) session.getAttribute("redirectUrl");
		if (redirectUrl == null || redirectUrl.isEmpty()) {
			response.sendRedirect("home");
		} else {
			response.sendRedirect(redirectUrl);
		}
	}
}
