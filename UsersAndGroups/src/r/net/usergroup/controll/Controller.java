package r.net.usergroup.controll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import r.net.usergroup.dao.ManagerServiceGroupAndUser;
import r.net.usergroup.dao.ManagerServiceUser;
import r.net.usergroup.dao.ManagerServiceGroup;
import r.net.usergroup.model.Group;
import r.net.usergroup.model.User;

@RestController
public class Controller {

	private ManagerServiceUser managerserviceuser = new ManagerServiceUser();
	private ManagerServiceGroupAndUser managerservicegroupanduser = new ManagerServiceGroupAndUser();
	private ManagerServiceGroup managerservicegroup = new ManagerServiceGroup();

	/**/
	@RequestMapping(value = "/users", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getAllUsers() {
		List<User> users = managerserviceuser.getAllUsers();
		return users;
	}

	/**/
	@RequestMapping(value = "/userChoos/{id_user}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUserById(@PathVariable String id_user) throws ParseException {
		User userById = managerserviceuser.getUserById(Integer
				.parseInt(id_user));
		return userById;
	}

	/**/
	@RequestMapping(value = "/groups", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Group> getAllGroups() {
		List<Group> groups = managerservicegroup.getAllGroups();
		return groups;
	}

	/**/
	@RequestMapping(value = "/groupChoos/{id_group}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Group getGroupById(@PathVariable String id_group) {
		Group groupById = managerservicegroup.getGroupById(Integer
				.parseInt(id_group));
		return groupById;
	}

	/**/
	@RequestMapping(value = "/groupUser/{id_user}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Group> getGroupUser(@PathVariable String id_user) {
		List<Group> groupUser = managerservicegroup.getGroupUser(Integer
				.parseInt(id_user));
		return groupUser;
	}

	/**/
	@RequestMapping(value = "/groupNoUser/{id_user}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Group> getGroupNoUser(@PathVariable String id_user) {
		List<Group> groupNoUser = managerservicegroup.getGroupNoUser(Integer
				.parseInt(id_user));
		return groupNoUser;
	}

	/**/
	@RequestMapping(value = "/userGroup/{id_group}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getUserGroup(@PathVariable String id_group) {
		List<User> userGroup = managerserviceuser.getUserGroup(Integer
				.parseInt(id_group));
		return userGroup;
	}

	/**/
	@RequestMapping(value = "/userNoGroup/{id_group}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getUserNoGroup(@PathVariable String id_group) {
		List<User> userNoGroup = managerserviceuser.getUserNoGroup(Integer
				.parseInt(id_group));
		return userNoGroup;
	}

	/**/
	@RequestMapping(value = "/user/insert/{new_login_user}/{new_pass_user}/{new_last_name}/{new_first_name}/{new_date_birthday}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addUser(@PathVariable String new_login_user,
			@PathVariable String new_pass_user,
			@PathVariable String new_last_name,
			@PathVariable String new_first_name,
			@PathVariable Date new_date_birthday) throws ParseException {

		SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatForDateNow.parse(formatForDateNow
				.format(new_date_birthday));
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		User user = new User();
		user.setLogin_user(new_login_user);
		user.setPass_user(new_pass_user);
		user.setLast_name(new_last_name);
		user.setFirst_name(new_first_name);
		user.setDate_birthday(sqlDate);
		managerserviceuser.addUser(user);
	}

	/**/
	@RequestMapping(value = "/user/update/{login_user}/{last_name}/{first_name}/{date_birthday}/{id_user}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void updateUser(@PathVariable String login_user,
			@PathVariable String last_name, @PathVariable String first_name,
			@PathVariable String date_birthday, @PathVariable int id_user)
			throws ParseException {
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatForDateNow.parse(date_birthday);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		managerserviceuser.updateUser(login_user, last_name, first_name,
				sqlDate, id_user);
	}

	/**/
	@RequestMapping(value = "/user/delete/{id_user}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void deleteUser(@PathVariable int id_user) throws ParseException {
		managerserviceuser.deleteUser(id_user);
	}

	/**/
	@RequestMapping(value = "/user/delete/group/{id_group}/{id_user}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void deleteGroupUser(@PathVariable int id_group,
			@PathVariable int id_user) throws ParseException {
		managerservicegroupanduser.deleteGroupUser(id_group, id_user);
	}

	/**/
	@RequestMapping(value = "/user/insert/group/{id_group}/{id_user}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addGroupUser(@PathVariable int id_group,
			@PathVariable int id_user) throws ParseException {
		managerservicegroupanduser.addGroupUser(id_group, id_user);
	}

	/**/
	@RequestMapping(value = "/group/insert/{name_group}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addGroup(@PathVariable String name_group) throws ParseException {
		Group group = new Group();
		group.setName_group(name_group);
		managerservicegroup.addGroup(group);
	}

	/**/
	@RequestMapping(value = "/group/delete/{id_group}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void deleteGroup(@PathVariable int id_group) throws ParseException {
		managerservicegroup.deleteGroup(id_group);
	}

	/**/
	@RequestMapping(value = "/group/update/{name_group}/{id_group}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void updateeGroup(@PathVariable String name_group,
			@PathVariable int id_group) throws ParseException {
		managerservicegroup.updateGroup(name_group, id_group);
	}

}
