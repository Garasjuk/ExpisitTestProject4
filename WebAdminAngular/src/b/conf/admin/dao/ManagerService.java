package b.conf.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import b.conf.admin.model.Groups;
import b.conf.admin.model.Unionz;
import b.conf.admin.model.Users;
import b.conf.admin.utility.BaseUtility;

public class ManagerService {
	
	private Connection connection;
	
	public ManagerService() {
		connection = BaseUtility.getConnection();
	}
	
	/**/
	public List<Groups> getAllGroups() {
		List<Groups> groups = new ArrayList<Groups>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from groups ");
			while (rs.next()) {
				Groups group = new Groups();
				group.setId_group(rs.getInt("id_group"));
				group.setName_group(rs.getString("name_group"));	
				groups.add(group);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return groups;
	}
	
	/**/
	public List<Users> getAllUsers() {
		List<Users> users = new ArrayList<Users>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users ");
			while (rs.next()) {
				Users user = new Users();
				user.setId_user(rs.getInt("id_user"));
				user.setFirst_name(rs.getString("first_name"));
				user.setLast_name(rs.getString("last_name"));
				user.setUser_name(rs.getString("user_name"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	/**/
	public Users getUserByName(String user_name) {
		Users users = new Users();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from users where user_name=?");
			preparedStatement.setString(1, user_name);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				users.setId_user(rs.getInt("id_user"));
				users.setFirst_name(rs.getString("first_name"));
				users.setLast_name(rs.getString("last_name"));
				users.setUser_name(rs.getString("user_name"));
				users.setEmail(rs.getString("email"));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	/**/
	public List<Groups> getUserGroupByID(int id_user) {
		List<Groups> groups = new ArrayList<Groups>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select groups.id_group, groups.name_group from groups INNER JOIN unionz ON groups.id_group = unionz.id_group WHERE unionz.id_user = ?");
			preparedStatement.setInt(1, id_user);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				
				Groups group = new Groups();
				group.setId_group(rs.getInt("id_group"));	
				group.setName_group(rs.getString("name_group"));
				groups.add(group);
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groups;
	}
	
	/**/
	public List<Groups> getNoUserGroupByID(int id_user) {
		List<Groups> groups = new ArrayList<Groups>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select groups.id_group, groups.name_group from groups WHERE groups.id_group NOT IN (SELECT  unionz.id_group FROM unionz WHERE unionz.id_user = ?)");
			preparedStatement.setInt(1, id_user);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Groups group = new Groups();
				group.setId_group(rs.getInt("id_group"));	
				group.setName_group(rs.getString("name_group"));
				groups.add(group);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groups;
	}

	
	
	/**/
	public Groups getGroupByName(String name_group) {
	
		Groups groups = new Groups();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from groups where name_group=?");
			preparedStatement.setString(1, name_group);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				groups.setId_group(rs.getInt("id_group"));
				groups.setName_group(rs.getString("name_group"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groups;
	}
	
	/**/
	public List<Users> getGroupUserByID(int id_group) {
		List<Users> users = new ArrayList<Users>();		
		try {			
			PreparedStatement preparedStatement = connection.prepareStatement("select users.id_user, users.user_name, users.first_name, users.last_name, users.email  from users INNER JOIN unionz ON users.id_user = unionz.id_user WHERE unionz.id_group = ?");
			preparedStatement.setInt(1, id_group);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Users user = new Users();
				user.setId_user(rs.getInt("id_user"));
				user.setFirst_name(rs.getString("first_name"));
				user.setLast_name(rs.getString("last_name"));
				user.setUser_name(rs.getString("user_name"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	/**/
	public List<Users> getNoGroupUserByID(int id_group) {
		List<Users> users = new ArrayList<Users>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select users.id_user, users.user_name, users.first_name, users.last_name, users.email from users WHERE users.id_user NOT IN (SELECT  unionz.id_user FROM unionz WHERE unionz.id_group = ?)");
			preparedStatement.setInt(1, id_group);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Users user = new Users();
				user.setId_user(rs.getInt("id_user"));
				user.setFirst_name(rs.getString("first_name"));
				user.setLast_name(rs.getString("last_name"));
				user.setUser_name(rs.getString("user_name"));
				user.setEmail(rs.getString("email"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	
	
	
	public void deleteUserGroup(int id_group, int id_user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from unionz where id_group = ? and id_user = ?");
			preparedStatement.setInt(1, id_group);
			preparedStatement.setInt(2, id_user);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteGroupUser(int id_user, int id_group) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from unionz where id_user = ? and id_group = ?");
			preparedStatement.setInt(1, id_user);
			preparedStatement.setInt(2, id_group);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	/**/
	public void addUserGroup(Unionz unionz) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into unionz(id_group, id_user) values (?,?)");
			preparedStatement.setInt(1, unionz.getId_group());
			preparedStatement.setInt(2, unionz.getId_user());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**/
	public void addGroupUser(Unionz unionz) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into unionz(id_group, id_user) values (?,?)");
			preparedStatement.setInt(1, unionz.getId_group());
			preparedStatement.setInt(2, unionz.getId_user());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**/
	public void updataUser(String user_name, String first_name, String last_name, String email, int id_user)
			throws ParseException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update users set user_name=?, first_name=?, last_name=?, email=? where id_user=?");
			preparedStatement.setString(1, user_name);
			preparedStatement.setString(2, first_name);
			preparedStatement.setString(3, last_name);
			preparedStatement.setString(4, email);
			preparedStatement.setInt(5, id_user);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**/
	public void updataGroup(int id_group, String name_group)
			throws ParseException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update groups set name_group=? where id_group=?");
			preparedStatement.setString(1, name_group);
			preparedStatement.setInt(2, id_group);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**/
	public void addUser(Users users) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into users(user_name, first_name, last_name, email) values (?,?,?,?)");
			preparedStatement.setString(1, users.getUser_name());
			preparedStatement.setString(2, users.getFirst_name());
			preparedStatement.setString(3, users.getLast_name());
			preparedStatement.setString(4, users.getEmail());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**/
	public void addGroup(Groups groups) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into groups(name_group) values (?)");
			preparedStatement.setString(1, groups.getName_group());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void deleteUser(int id_user) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from unionz where id_user = ? ");
			preparedStatement.setInt(1, id_user);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from users where id_user = ? ");
			preparedStatement.setInt(1, id_user);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deleteGroup(int id_group) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from unionz where id_group = ? ");
			preparedStatement.setInt(1, id_group);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from groups where id_group = ? ");
			preparedStatement.setInt(1, id_group);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
