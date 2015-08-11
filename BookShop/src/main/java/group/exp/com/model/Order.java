package group.exp.com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "id_order")
	private int id_order;
	
	@Column(name = "id_book")
	private int id_book;
	
	@Column(name = "id_user")
	private int id_user;
	
	@Column(name = "count_order")
	private int count_order;
	
	@Column(name = "adres_order")
	private String adres_order;
	
	@Column(name = "date_order")
	private Date date_order;
	
	@Column(name = "othe_order")
	private String othe_order;
	
	
	public Order() {
		super();
	}
	public int getId_order() {
		return id_order;
	}
	public void setId_order(int id_order) {
		this.id_order = id_order;
	}
	public int getId_book() {
		return id_book;
	}
	public void setId_book(int id_book) {
		this.id_book = id_book;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getCount_order() {
		return count_order;
	}
	public void setCount_order(int count_order) {
		this.count_order = count_order;
	}
	public String getAdres_order() {
		return adres_order;
	}
	public void setAdres_order(String adres_order) {
		this.adres_order = adres_order;
	}
	public Date getDate_order() {
		return date_order;
	}
	public void setDate_order(Date date_order) {
		this.date_order = date_order;
	}
	public String getOthe_order() {
		return othe_order;
	}
	public void setOthe_order(String othe_order) {
		this.othe_order = othe_order;
	}
	
	
	
}
