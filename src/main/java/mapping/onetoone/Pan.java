package mapping.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pan {
	@Id
	private int pId;
	private String pName;
	private String pLocation;

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

	public String getpLocation() {
		return pLocation;
	}

	public void setpLocation(String pLocation) {
		this.pLocation = pLocation;
	}

	@Override
	public String toString() {
		return "Pan [pId=" + pId + ", pName=" + pName + ", pLocation=" + pLocation + "]";
	}
}
