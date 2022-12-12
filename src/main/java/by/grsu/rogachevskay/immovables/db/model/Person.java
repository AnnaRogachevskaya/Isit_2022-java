package by.grsu.rogachevskay.immovables.db.model;

public class Person {
	private Integer id;
	private String type;
	private String name;
	private String addres;
	private String telephone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "person [id=" + id + ", type=" + type + ", name=" + name + ", addres=" + addres + ", telephone="
				+ telephone + ", getId()=" + getId() + ", getType()=" + getType() + ", getName()=" + getName()
				+ ", getAddres()=" + getAddres() + ", getTelephone()=" + getTelephone() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
