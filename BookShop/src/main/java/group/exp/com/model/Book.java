package group.exp.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue
	@Column(name = "id_book")
	private int id_book;

	@Column(name = "name_book")
	private String name_book;

	@Column(name = "count_book")
	private int count_book;

	@Column(name = "price_book")
	private int price_book;

	@Column(name = "id_genre")
	private int id_genre;

	@Column(name = "id_author")
	private int id_author;

	@Column(name = "new_book")
	private int new_book;

	@Column(name = "id_publishing")
	private int id_publishing;

	private String name_genre;
	private String name_author;
	private String name_publishing;

	public Book() {
		super();
	}

	public int getId_book() {
		return id_book;
	}

	public void setId_book(int id_book) {
		this.id_book = id_book;
	}

	public String getName_book() {
		return name_book;
	}

	public void setName_book(String name_book) {
		this.name_book = name_book;
	}

	public int getCount_book() {
		return count_book;
	}

	public void setCount_book(int count_book) {
		this.count_book = count_book;
	}

	public int getPrice_book() {
		return price_book;
	}

	public void setPrice_book(int price_book) {
		this.price_book = price_book;
	}

	public int getId_genre() {
		return id_genre;
	}

	public void setId_genre(int id_genre) {
		this.id_genre = id_genre;
	}

	public int getId_author() {
		return id_author;
	}

	public void setId_author(int id_author) {
		this.id_author = id_author;
	}

	public int getNew_book() {
		return new_book;
	}

	public void setNew_book(int new_book) {
		this.new_book = new_book;
	}

	public int getId_publishing() {
		return id_publishing;
	}

	public void setId_publishing(int id_publishing) {
		this.id_publishing = id_publishing;
	}

	public String getName_genre() {
		return name_genre;
	}

	public void setName_genre(String name_genre) {
		this.name_genre = name_genre;
	}

	public String getName_author() {
		return name_author;
	}

	public void setName_author(String name_author) {
		this.name_author = name_author;
	}

	public String getName_publishing() {
		return name_publishing;
	}

	public void setName_publishing(String name_publishing) {
		this.name_publishing = name_publishing;
	}

}
