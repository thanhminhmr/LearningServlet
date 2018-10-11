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
@WebServlet("/user/delete")
public class UserDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDeleteController() {
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
		request.getRequestDispatcher("/user.delete.jsp").forward(request, response);
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

		User requestingUser = new User(Integer.valueOf(userId), null, null);
		User foundUser = Users.getUserById(requestingUser);
		if (foundUser == null) {
			response.sendRedirect("/user/list");
			return;
		}

		if (Users.deleteUserById(foundUser)) {
			response.sendRedirect("/user/list");
			return;
		}

		request.setAttribute("isError", true);
		request.setAttribute("targetUser", foundUser);
		request.getRequestDispatcher("/user.delete.jsp").forward(request, response);
	}
}
