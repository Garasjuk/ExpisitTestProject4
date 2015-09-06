package group.exp.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "likes")
public class Likes {

	@Id
	@GeneratedValue
	@Column(name = "id_like")
	private int id_like;
	
	@Column(name = "id_book")
	private int id_book;
	
	@Column(name = "id_user")
	private int id_user;

	public Likes() {
		super();
	}

	public int getId_like() {
		return id_like;
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

}
