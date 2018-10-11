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
import java.util.ArrayList;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/user/create")
public class UserCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserCreateController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/user.create.jsp").forward(request, response);
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
			request.setAttribute("isEmpty", true);
			request.getRequestDispatcher("/user.create.jsp").forward(request, response);
			return;
		}

		// try create
		User requestingUser = new User(null, username, password);
		User createdUser = Users.addUser(requestingUser);
		if (createdUser == null) {
			request.setAttribute("isError", true);
			request.setAttribute("isFailed", true);
			request.setAttribute("targetUsername", username);
			request.getRequestDispatcher("/user.create.jsp").forward(request, response);
			return;
		}

		response.sendRedirect("/user/list");
	}
}
