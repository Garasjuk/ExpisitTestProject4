package group.exp.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class Genre {

	@Id
	@GeneratedValue
	@Column(name = "id_genre")
	private int id_genre;
	
	@Column(name = "name_genre")
	private String name_genre;

	public Genre() {
		super();
	}

	public int getId_genre() {
		return id_genre;
	}

	public String getName_genre() {
		return name_genre;
	}

	public void setName_genre(String name_genre) {
		this.name_genre = name_genre;
	}

}
