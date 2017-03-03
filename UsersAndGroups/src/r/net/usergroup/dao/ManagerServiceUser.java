package r.net.usergroup.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import r.net.usergroup.model.User;
import r.net.usergroup.utility.BaseUtility;

public class ManagerServiceUser {

	private Connection connection;

	public ManagerServiceUser() {
		connection = BaseUtility.getConnection();
	}

	/**/
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select id_user, login_user, last_name, first_name, date_birthday from user ");
			while (rs.next()) {
				User user = new User();
				user.setId_user(rs.getInt("id_user"));
				user.setLogin_user(rs.getString("login_user"));
				user.setLast_name(rs.getString("last_name"));
				user.setFirst_name(rs.getString("first_name"));
				user.setDate_birthday(rs.getDate("date_birthday"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public User getUserById(int id_user) {
		User userById = new User();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select id_user, login_user, pass_user, last_name, first_name, date_birthday  from user where id_user = ?");
			preparedStatement.setInt(1, id_user);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				userById.setId_user(rs.getInt("id_user"));
				userById.setLogin_user(rs.getString("login_user"));
				userById.setPass_user(rs.getString("pass_user"));
				userById.setLast_name(rs.getString("last_name"));
				userById.setFirst_name(rs.getString("first_name"));
				userById.setDate_birthday(rs.getDate("date_birthday"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userById;
	}

	/**/
	public List<User> getUserGroup(int id_group) {
		List<User> userGroup = new ArrayList<User>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id_user, login_user FROM user WHERE id_user in (SELECT id_user FROM userandgroup WHERE id_group = ?)");
			preparedStatement.setInt(1, id_group);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId_user(rs.getInt("id_user"));
				user.setLogin_user(rs.getString("login_user"));
				userGroup.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userGroup;
	}

	/**/
	public List<User> getUserNoGroup(int id_group) {
		List<User> userNoGroup = new ArrayList<User>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id_user, login_user FROM user WHERE id_user NOT IN (SELECT id_user FROM userandgroup WHERE id_group = ?)");
			preparedStatement.setInt(1, id_group);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId_user(rs.getInt("id_user"));
				user.setLogin_user(rs.getString("login_user"));
				userNoGroup.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userNoGroup;
	}

	/**/
	public void addUser(User user) {
		try {

			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into user (login_user, pass_user, last_name, first_name, date_birthday) values (?,?,?,?,?)");
			preparedStatement.setString(1, user.getLogin_user());
			preparedStatement.setString(2, user.getPass_user());
			preparedStatement.setString(3, user.getLast_name());
			preparedStatement.setString(4, user.getFirst_name());
			preparedStatement.setDate(5, (Date) user.getDate_birthday());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int id_user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from user where id_user = ?");
			preparedStatement.setInt(1, id_user);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**/
	public void updateUser(String login_user, String last_name,
			String first_name, Date date_birthday, int id_user)
			throws ParseException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update user set login_user = ?, last_name = ?, first_name = ?, date_birthday = ? where id_user = ?");
			preparedStatement.setString(1, login_user);
			preparedStatement.setString(2, last_name);
			preparedStatement.setString(3, first_name);
			preparedStatement.setDate(4, date_birthday);
			preparedStatement.setInt(5, id_user);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
