package group.exp.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@GeneratedValue
	@Column(name = "id_cart")
	private int id_cart;
	
	@Column(name = "id_book")
	private int id_book;
	
	@Column(name = "id_user")
	private int id_user;
	
	@Column(name = "count_cart")
	private int count_cart;

	private String name_book;
	private int price_book;
	private int count_book;
	
	
	public int getId_cart() {
		return id_cart;
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

	public int getCount_cart() {
		return count_cart;
	}

	public void setCount_cart(int count_cart) {
		this.count_cart = count_cart;
	}

	public String getName_book() {
		return name_book;
	}

	public void setName_book(String name_book) {
		this.name_book = name_book;
	}

	public int getPrice_book() {
		return price_book;
	}

	public void setPrice_book(int price_book) {
		this.price_book = price_book;
	}

	public int getCount_book() {
		return count_book;
	}

	public void setCount_book(int count_book) {
		this.count_book = count_book;
	}
	
	
}
