package group.exp.com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

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

	@Column(name = "other_order")
	private String other_order;

	@Column(name = "status_order")
	private String status_order;

	@Column(name = "date_delivered")
	private Date date_delivered;

	@Column(name = "return_order")
	private int return_order;

	public Orders() {
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

	public String getOther_order() {
		return other_order;
	}

	public void setOther_order(String other_order) {
		this.other_order = other_order;
	}

	public String getStatus_order() {
		return status_order;
	}

	public void setStatus_order(String status_order) {
		this.status_order = status_order;
	}

	public Date getDate_delivered() {
		return date_delivered;
	}

	public void setDate_delivered(Date date_delivered) {
		this.date_delivered = date_delivered;
	}

	public int getReturn_order() {
		return return_order;
	}

	public void setReturn_order(int return_order) {
		this.return_order = return_order;
	}

	
}
