package mapping.bidirectionalmapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person {
    @Id
    private int pId;
    private String pName;
    private int pContact;
    
    @OneToMany(mappedBy = "person")
    private List<Vehicle> vehicles = new ArrayList<>();

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpContact() {
		return pContact;
	}

	public void setpContact(int pContact) {
		this.pContact = pContact;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "Person [pId=" + pId + ", pName=" + pName + ", pContact=" + pContact + ", vehicles=" + vehicles + "]";
	}
    
}
