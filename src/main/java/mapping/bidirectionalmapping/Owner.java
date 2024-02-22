package mapping.bidirectionalmapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Owner {
    @Id
    private int oId;
    private String oName;
    private String oLocation;
    @ManyToMany(mappedBy = "lOwners")
    private List<House> lHouses = new ArrayList<>();

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }

    public String getoLocation() {
        return oLocation;
    }

    public void setoLocation(String oLocation) {
        this.oLocation = oLocation;
    }

    public List<House> getlHouses() {
        return lHouses;
    }

    public void setlHouses(List<House> lHouses) {
        this.lHouses = lHouses;
    }

    @Override
    public String toString() {
        return "Owner [oId=" + oId + ", oName=" + oName + ", oLocation=" + oLocation + ", lHouses=" + lHouses + "]";
    }
}
