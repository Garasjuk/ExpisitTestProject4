package r.net.usergroup.model;

public class Group {

	private int id_group;
	private String name_group;

	public Group() {
		super();
	}

	public Group(String name_group) {
		super();
		this.name_group = name_group;
	}
	
	public void setId_group(int id_group) {
		this.id_group = id_group;
	}

	public int getId_group() {
		return id_group;
	}

	public String getName_group() {
		return name_group;
	}

	public void setName_group(String name_group) {
		this.name_group = name_group;
	}

}
