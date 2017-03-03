package r.net.usergroup.model;

import java.util.Date;

public class User {

	private int id_user;
	private String login_user;
	private String pass_user;
	private String last_name;
	private String first_name;
	private Date date_birthday;

	public User() {
		super();
	}

	public User(String login_user, String pass_user, String last_name,
			String first_name, Date date_birthday) {
		super();
		this.login_user = login_user;
		this.pass_user = pass_user;
		this.last_name = last_name;
		this.first_name = first_name;
		this.date_birthday = date_birthday;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_user() {
		return id_user;
	}

	public String getLogin_user() {
		return login_user;
	}

	public void setLogin_user(String login_user) {
		this.login_user = login_user;
	}

	public String getPass_user() {
		return pass_user;
	}

	public void setPass_user(String pass_user) {
		this.pass_user = pass_user;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public Date getDate_birthday() {
		return date_birthday;
	}

	public void setDate_birthday(Date date_birthday) {
		this.date_birthday = date_birthday;
	}

}
