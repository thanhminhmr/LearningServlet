package mrmathami.servlet.controller;

import mrmathami.servlet.model.dao.Users;
import mrmathami.servlet.model.data.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/user/edit")
public class UserEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserEditController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		if (userId == null || userId.isEmpty() || !userId.matches("[0-9]+")) {
			response.sendRedirect("/user/list");
			return;
		}

		User requestingUser = new User(Integer.valueOf(userId), null, null);
		User foundUser = Users.getUserById(requestingUser);
		if (foundUser == null) {
			response.sendRedirect("/user/list");
			return;
		}

		request.setAttribute("targetUser", foundUser);
		request.getRequestDispatcher("/user.edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		if (userId == null || userId.isEmpty() || !userId.matches("[0-9]+")) {
			response.sendRedirect("/user/list");
			return;
		}

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User requestingUser = new User(Integer.valueOf(userId), username, password);
		User foundUser = Users.getUserById(requestingUser);
		if (foundUser == null) {
			response.sendRedirect("/user/list");
			return;
		}

		// empty username or password check
		if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
			request.setAttribute("isError", true);
			request.setAttribute("isEmpty", true);
			request.setAttribute("targetUser", requestingUser);
			request.getRequestDispatcher("/user.edit.jsp").forward(request, response);
			return;
		}

		// try edit
		if (!Users.updateUserById(requestingUser)) {
			request.setAttribute("isError", true);
			request.setAttribute("isFailed", true);
			request.setAttribute("targetUser", requestingUser);
			request.getRequestDispatcher("/user.edit.jsp").forward(request, response);
			return;
		}

		response.sendRedirect("/user/list");
	}
}
