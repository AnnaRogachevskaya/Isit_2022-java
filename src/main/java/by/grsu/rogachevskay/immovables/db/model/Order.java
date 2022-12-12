package by.grsu.rogachevskay.immovables.db.model;

public class Order {

	private Integer id;
	private Integer personId;
	private String sum;
	private String status;
	private Integer documentId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	@Override
	public String toString() {
		return "order [id=" + id + ", personId=" + personId + ", sum=" + sum + ", status=" + status + ", documentId="
				+ documentId + ", getId()=" + getId() + ", getPersonId()=" + getPersonId() + ", getSum()=" + getSum()
				+ ", getStatus()=" + getStatus() + ", getDocumentId()=" + getDocumentId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
