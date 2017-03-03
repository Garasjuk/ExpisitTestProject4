package r.net.usergroup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import r.net.usergroup.model.Group;
import r.net.usergroup.utility.BaseUtility;

public class ManagerServiceGroup {

	private Connection connection;

	public ManagerServiceGroup() {
		connection = BaseUtility.getConnection();
	}

	/**/
	public List<Group> getAllGroups() {
		List<Group> groups = new ArrayList<Group>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("select id_group, name_group from groupp");
			while (rs.next()) {
				Group group = new Group();
				group.setId_group(rs.getInt("id_group"));
				group.setName_group(rs.getString("name_group"));
				groups.add(group);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groups;
	}

	public Group getGroupById(int id_group) {
		Group groupById = new Group();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select id_group, name_group from groupp where id_group = ?");
			preparedStatement.setInt(1, id_group);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				groupById.setId_group(rs.getInt("id_group"));
				groupById.setName_group(rs.getString("name_group"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groupById;
	}

	/**/
	public List<Group> getGroupUser(int id_user) {
		List<Group> groupUser = new ArrayList<Group>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id_group, name_group FROM groupp WHERE id_group in (SELECT id_group FROM userandgroup WHERE id_user = ?)");
			preparedStatement.setInt(1, id_user);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Group group = new Group();
				group.setId_group(rs.getInt("id_group"));
				group.setName_group(rs.getString("name_group"));
				groupUser.add(group);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groupUser;
	}

	/**/
	public List<Group> getGroupNoUser(int id_user) {
		List<Group> groupNoUser = new ArrayList<Group>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT id_group, name_group FROM groupp WHERE id_group not in (SELECT id_group FROM userandgroup WHERE id_user = ?)");
			preparedStatement.setInt(1, id_user);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Group group = new Group();
				group.setId_group(rs.getInt("id_group"));
				group.setName_group(rs.getString("name_group"));
				groupNoUser.add(group);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groupNoUser;
	}

	/**/
	public void addGroup(Group group) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into groupp(name_group) values (?)");
			preparedStatement.setString(1, group.getName_group());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**/
	public void deleteGroup(int id_group) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from groupp where id_group = ?");
			preparedStatement.setInt(1, id_group);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**/
	public void updateGroup(String name_group, int id_group)
			throws ParseException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update groupp set name_group=? where id_group=?");
			preparedStatement.setString(1, name_group);
			preparedStatement.setInt(2, id_group);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
