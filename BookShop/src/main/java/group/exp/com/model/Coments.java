package group.exp.com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coments")
public class Coments {

	@Id
	@GeneratedValue
	@Column(name = "id_coment")
	private int id_coment;
	
	@Column(name = "id_book")
	private int id_book;
	
	@Column(name = "id_user")
	private int id_user;
	
	@Column(name = "opinion_coment")
	private String opinion_coment;
	
	@Column(name = "date_coment")
	private Date date_coment;
	
	
	
	public Coments() {
		super();
	}

	public int getId_coment() {
		return id_coment;
	}

	public void setId_coment(int id_coment) {
		this.id_coment = id_coment;
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

	public String getOpinion_coment() {
		return opinion_coment;
	}

	public void setOpinion_coment(String opinion_coment) {
		this.opinion_coment = opinion_coment;
	}

	public Date getDate_coment() {
		return date_coment;
	}

	public void setDate_coment(Date date_coment) {
		this.date_coment = date_coment;
	}

	

}
