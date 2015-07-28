package b.conf.admin.controller;

import java.text.ParseException;
import java.util.List;

import javax.sound.sampled.AudioFormat.Encoding;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import b.conf.admin.model.Groups;
import b.conf.admin.model.Unionz;
import b.conf.admin.dao.ManagerService;
import b.conf.admin.model.Users;

@RestController
public class AdminController {

	ManagerService managerservice = new ManagerService();
	
	@RequestMapping(value = "/groups", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Groups> getAllGroups() {
		List<Groups> groups = managerservice.getAllGroups();
		return groups;

	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Users> getAllUsers() {
		List<Users> users = managerservice.getAllUsers();
		return users;
	}
	
	
	//getUserByName
	@RequestMapping(value = "/user/getByName/{user_name}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Users getUserByName(@PathVariable String user_name) {
		Users users = managerservice.getUserByName(user_name);
		return users;
	}	
	//getUserGroupByID
	@RequestMapping(value = "/userGroup/getByID/{id_user}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Groups> getUserGroupByID(@PathVariable String id_user) {
		List<Groups> groups = managerservice.getUserGroupByID(Integer.parseInt(id_user));
		return groups;
	}
	//getNoUserGroupByID
	@RequestMapping(value = "/noUserGroup/getByID/{id_user}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Groups> getNoUserGroupByID(@PathVariable String id_user) {
		List<Groups> groups = managerservice.getNoUserGroupByID(Integer.parseInt(id_user));
		return groups;
	}
	
	
	//getGroupByName
	@RequestMapping(value = "/group/getByName/{name_group}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Groups getGroupByName(@PathVariable String name_group ) {
		
		Groups groups = managerservice.getGroupByName(name_group);
		return groups;
	}	
	//getGroupUserByID
	@RequestMapping(value = "/groupUser/getByID/{id_group}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Users> getGroupUserByID(@PathVariable String id_group) {
		List<Users> users = managerservice.getGroupUserByID(Integer.parseInt(id_group));
		return users;
	}
	//getNoGroupUserByID
	@RequestMapping(value = "/noGroupUser/getByID/{id_group}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Users> getNoGroupUserByID(@PathVariable String id_group) {
		List<Users> users = managerservice.getNoGroupUserByID(Integer.parseInt(id_group));
		return users;
	}	
	
	
	@RequestMapping(value = "/user/deleteGroup/{id_group}/{id_user}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void deleteUserGroup(@PathVariable String id_group, @PathVariable String id_user) 
			throws ParseException {managerservice.deleteUserGroup(Integer.parseInt(id_group), Integer.parseInt(id_user));

	}
	
	@RequestMapping(value = "/group/deleteUser/{id_user}/{id_group}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void deleteGroupUser(@PathVariable String id_user, @PathVariable String id_group) 
			throws ParseException {managerservice.deleteGroupUser(Integer.parseInt(id_user), Integer.parseInt(id_group));

	}
	
	@RequestMapping(value = "/user/delete/{id_user}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void deleteUser(@PathVariable String id_user) 
			throws ParseException {managerservice.deleteUser(Integer.parseInt(id_user));

	}
	
	@RequestMapping(value = "/group/delete/{id_group}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void deleteGroup(@PathVariable String id_group) 
			throws ParseException {managerservice.deleteGroup(Integer.parseInt(id_group));

	}
	
	@RequestMapping(value = "/add/user/group/{id_group}/{id_user}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addTask(@PathVariable Integer id_group,
			@PathVariable Integer id_user) throws ParseException {
		Unionz unionz = new Unionz();
		unionz.setId_group(id_group);
		unionz.setId_user(id_user);
		managerservice.addUserGroup(unionz);
	}
	
	@RequestMapping(value = "/add/group/user/{id_user}/{id_group}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addGroupUser(@PathVariable Integer id_user,
			@PathVariable Integer id_group) throws ParseException {
		Unionz unionz = new Unionz();
		unionz.setId_group(id_group);
		unionz.setId_user(id_user);
		managerservice.addGroupUser(unionz);
	}
	
	@RequestMapping(value = "/user/edit/{user_name}/{first_name}/{last_name}/{email}/{id_user}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void updataUsers(@PathVariable String user_name,
							@PathVariable String first_name,
							@PathVariable String last_name,
							@PathVariable String email,
							@PathVariable int id_user) throws ParseException {
	
		managerservice.updataUser(user_name, first_name, last_name, email, id_user);
	}
	
	@RequestMapping(value = "/group/edit/name/{id_group}/{name_group}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void updataGroup(@PathVariable int id_group,
							@PathVariable String name_group) throws ParseException {
		managerservice.updataGroup(id_group, name_group);
	}
	
	@RequestMapping(value = "/add/user/{user_name}/{first_name}/{last_name}/{email}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addUser(@PathVariable String user_name,
			@PathVariable String first_name,
			@PathVariable String last_name,
			@PathVariable String email) throws ParseException {
		Users users  = new Users();
		users.setUser_name(user_name);
		users.setFirst_name(first_name);
		users.setLast_name(last_name);
		users.setEmail(email);
		managerservice.addUser(users);
	}
	
	@RequestMapping(value = "/add/group/{name_group}", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addGroupd(@PathVariable String name_group
			) throws ParseException {
		Groups groups = new Groups();
		groups.setName_group(name_group);
		managerservice.addGroup(groups);
	}
}
