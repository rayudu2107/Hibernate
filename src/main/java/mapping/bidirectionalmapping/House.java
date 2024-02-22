package mapping.bidirectionalmapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class House {
    @Id
    private int hId;
    private String hLocation;
    private int hRent;
    @ManyToMany
    private List<Owner> lOwners = new ArrayList<>();

    public int gethId() {
        return hId;
    }

    public void sethId(int hId) {
        this.hId = hId;
    }

    public String gethLocation() {
        return hLocation;
    }

    public void sethLocation(String hLocation) {
        this.hLocation = hLocation;
    }

    public int gethRent() {
        return hRent;
    }

    public void sethRent(int hRent) {
        this.hRent = hRent;
    }

    public List<Owner> getlOwners() {
        return lOwners;
    }

    public void setlOwners(List<Owner> lOwners) {
        this.lOwners = lOwners;
    }

    @Override
    public String toString() {
        return "House [hId=" + hId + ", hLocation=" + hLocation + ", hRent=" + hRent + ", lOwners=" + lOwners + "]";
    }
}
