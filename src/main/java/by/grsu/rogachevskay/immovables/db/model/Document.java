package by.grsu.rogachevskay.immovables.db.model;

public class Document {

	private Integer id;
	private Integer extract;
	private Integer act;
	private Integer treaty;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getExtract() {
		return extract;
	}

	public void setExtract(Integer extract) {
		this.extract = extract;
	}

	public Integer getAct() {
		return act;
	}

	public void setAct(Integer act) {
		this.act = act;
	}

	public Integer getTreaty() {
		return treaty;
	}

	public void setTreaty(Integer treaty) {
		this.treaty = treaty;
	}

	@Override
	public String toString() {
		return "document [id=" + id + ", extract=" + extract + ", act=" + act + ", treaty=" + treaty + ", getId()="
				+ getId() + ", getExtract()=" + getExtract() + ", getAct()=" + getAct() + ", getTreaty()=" + getTreaty()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
