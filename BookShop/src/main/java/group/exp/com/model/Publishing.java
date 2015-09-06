package group.exp.com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publishing")
public class Publishing {

	@Id
	@GeneratedValue
	@Column(name = "id_publishing")
	private int id_publishing;
	
	@Column(name = "name_publishing")
	private String name_publishing;

	public Publishing() {
		super();
	}

	public int getId_publishing() {
		return id_publishing;
	}

	public String getName_publishing() {
		return name_publishing;
	}

	public void setName_publishing(String name_publishing) {
		this.name_publishing = name_publishing;
	}

}
