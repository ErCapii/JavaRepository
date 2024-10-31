package Ejercicio4ServicioPedidosAmpliacionLogin.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Ejercicio4ServicioPedidosAmpliacionLogin.Service.ConsultException;
import Ejercicio4ServicioPedidosAmpliacionLogin.Service.InsertException;
import Ejercicio4ServicioPedidosAmpliacionLogin.User.User;

public class DaoUser {

	public Long insertUser(Connection conn, User user) throws InsertException, SQLException {
		String sql = "INSERT INTO login (username, password, email, register_date) VALUES ( ?, ?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setDate(4, Date.valueOf(user.getRegDate()));
			stmt.executeUpdate();
			ResultSet key = stmt.getGeneratedKeys();
			key.next();
			return key.getLong(1);
		}
	}

	public User getById(Connection conn, Long id) throws SQLException {
		String sql = "SELECT * FROM login WHERE id_user = ?";
		return getUser(conn, sql, id);
	}

	public User getByEmail(Connection conn, String email) throws SQLException {
		String sql = "SELECT * FROM login WHERE email = ?";
		return getUser(conn, sql, email);
	}

	public User getByUsername(Connection conn, String username) throws SQLException {
		String sql = "SELECT * FROM login WHERE username = ?";
		return getUser(conn, sql, username);
	}

	private User getUser(Connection conn, String sql, Object parametro) throws SQLException {
		User user = null;

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			if (parametro instanceof Long) {
				stmt.setLong(1, (Long) parametro);
			} else if (parametro instanceof String) {
				stmt.setString(1, (String) parametro);
			}

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				user = new User(rs.getLong("id_user"), // id_user
						rs.getString("username"), rs.getString("password"), rs.getString("email"),
						rs.getDate("register_date").toLocalDate(), // register_date
						rs.getDate("last_login_date") != null ? rs.getDate("last_login_date").toLocalDate() : null // last_login_date
				);
			}

		}

		return user;
	}

	public void updateUser(Connection conn, User user) throws SQLException {
		String sql = "UPDATE login Set username = ?, password = ?, email = ?, register_date = ?, last_login_date = ? WHERE id_user = "
				+ user.getId();
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setDate(4, Date.valueOf(user.getRegDate()));
			stmt.setDate(5, Date.valueOf(user.getLastLoginDate()));
			stmt.executeUpdate();

		}
	}

}
