package mapping.onetomany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee {
	@Id
	private int eId;
	private String eName;
	private int eContact;
	@OneToMany
	private List<Company> companies = new ArrayList<Company>();

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public int geteContact() {
		return eContact;
	}

	public void seteContact(int eContact) {
		this.eContact = eContact;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eContact=" + eContact + ", companies=" + companies
				+ "]";
	}

}
