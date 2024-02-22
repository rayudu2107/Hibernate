package mapping.bidirectionalmapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
    @Id
    private int vId;
    private String vName;
    private int vPrice;
    
    @ManyToOne
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

	public int getvPrice() {
		return vPrice;
	}

	public void setvPrice(int vPrice) {
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
		return "Vehicle [vId=" + vId + ", vName=" + vName + ", vPrice=" + vPrice + ", person=" + person + "]";
	}
    
}
