package mapping.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Persons {
	@Id
	private int pID;
	private String pName;
	private long pcontact;

	@OneToOne
	private Pan pan;

	public Pan getPan() {
		return pan;
	}

	public void setPan(Pan pan) {
		this.pan = pan;
	}

	public int getpID() {
		return pID;
	}

	public void setpID(int pID) {
		this.pID = pID;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public long getPcontact() {
		return pcontact;
	}

	public void setPcontact(long pcontact) {
		this.pcontact = pcontact;
	}

	@Override
	public String toString() {
		return "Person [pID=" + pID + ", pName=" + pName + ", pcontact=" + pcontact + "]";
	}
}
