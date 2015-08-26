package group.exp.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "id_user")
	private int id_user;

	@Column(name = "name_user")
	private String name_user;

	@Column(name = "money_user")
	private int money_user;

	@Column(name = "adres_user")
	private String adres_user;

	@Column(name = "pass_user")
	private String pass_user;

	@Column(name = "identif")
	private String identif;

	@Column(name = "email")
	private String email;

	@Column(name = "spend_money")
	private int spend_money;

	public User() {
		super();
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getName_user() {
		return name_user;
	}

	public void setName_user(String name_user) {
		this.name_user = name_user;
	}

	public int getMoney_user() {
		return money_user;
	}

	public void setMoney_user(int money_user) {
		this.money_user = money_user;
	}

	public String getAdres_user() {
		return adres_user;
	}

	public void setAdres_user(String adres_user) {
		this.adres_user = adres_user;
	}

	public String getPass_user() {
		return pass_user;
	}

	public void setPass_user(String pass_user) {
		this.pass_user = pass_user;
	}

	public String getIdentif() {
		return identif;
	}

	public void setIdentif(String identif) {
		this.identif = identif;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSpend_money() {
		return spend_money;
	}

	public void setSpend_money(int spend_money) {
		this.spend_money = spend_money;
	}
}
