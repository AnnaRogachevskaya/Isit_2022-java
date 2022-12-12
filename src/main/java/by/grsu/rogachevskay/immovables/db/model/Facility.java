package by.grsu.rogachevskay.immovables.db.model;

public class Facility {

	private Integer id;
	private String name;
	private String addres;
	private Integer personId;
	private Integer price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "facility [id=" + id + ", name=" + name + ", addres=" + addres + ", personId=" + personId + ", price="
				+ price + ", getId()=" + getId() + ", getName()=" + getName() + ", getAddres()=" + getAddres()
				+ ", getPersonId()=" + getPersonId() + ", getPrice()=" + getPrice() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
