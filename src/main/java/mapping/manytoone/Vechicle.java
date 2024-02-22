package mapping.manytoone;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vechicle {
	@Id
	private int vId;
	private String vName;
	private double vPrice;
	@ManyToOne(fetch = FetchType.LAZY)
	private Person person;

	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public double getvPrice() {
		return vPrice;
	}

	public void setvPrice(double vPrice) {
		this.vPrice = vPrice;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Vechicle [vId=" + vId + ", vName=" + vName + ", vPrice=" + vPrice + ", person=" + person + "]";
	}

}
