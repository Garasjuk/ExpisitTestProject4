package r.net.usergroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import r.net.usergroup.utility.BaseUtility;
public class ManagerServiceGroupAndUser {

	private Connection connection;

	public ManagerServiceGroupAndUser() {
		connection = BaseUtility.getConnection();
	}

	public void deleteGroupUser(int id_group, int id_user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from userandgroup where id_group = ? and id_user = ?");
			preparedStatement.setInt(1, id_group);
			preparedStatement.setInt(2, id_user);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**/
	public void addGroupUser(int id_group, int id_user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into userandgroup (id_group, id_user) values (?,?)");
			preparedStatement.setInt(1, id_group);
			preparedStatement.setInt(2, id_user);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
