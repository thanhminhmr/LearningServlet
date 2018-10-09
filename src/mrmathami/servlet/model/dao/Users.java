package mrmathami.servlet.model.dao;

import mrmathami.servlet.model.data.User;
import mrmathami.servlet.utilities.database.DatabaseConnection;

import java.sql.*;

public final class Users {
	public static User getUser(User user) {
		Connection connection = DatabaseConnection.getConnection();
		if (user == null || !user.has(false, true, true, false)) return null;

		try (PreparedStatement statement = connection.prepareStatement("SELECT userId, username, password, roleId FROM users WHERE username = ? AND password = ?")) {
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());

			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				return new User(
						(Integer) resultSet.getObject("userId"),
						resultSet.getString("username"),
						resultSet.getString("password"),
						(Integer) resultSet.getObject("roleId")
				);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static User addUser(User user) {
		Connection connection = DatabaseConnection.getConnection();
		if (user == null || !user.has(false, true, true, true)) return null;

		try (PreparedStatement statement = connection.prepareStatement("INSERT INTO users (username, password, roleId) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setInt(3, user.getRoleId());

			if (statement.executeUpdate() != 0) {
				ResultSet resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {
					return new User(
							resultSet.getInt(1),
							user.getUsername(),
							user.getPassword(),
							user.getRoleId()
					);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
