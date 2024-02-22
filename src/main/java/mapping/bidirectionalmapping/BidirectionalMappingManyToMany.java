package mapping.bidirectionalmapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BidirectionalMappingManyToMany {

    public static void main(String[] args) {
        // Create Owner objects
        Owner o1 = createOwner(101, "Sandeep", "Hyderabad");
        Owner o2 = createOwner(102, "Praveen", "Srikakulam");

        // Create House objects
        House h1 = createHouse(1001, "JP Nagar", 5626956);
        House h2 = createHouse(1002, "Jayanagar", 645321);
        House h3 = createHouse(1003, "Banasankari", 8528287);

        // Establish bidirectional relationship
        o1.getlHouses().add(h1);
        o1.getlHouses().add(h2);
        o2.getlHouses().add(h3);

        h1.getlOwners().add(o1);
        h2.getlOwners().add(o1);
        h3.getlOwners().add(o2);

        // Configure Hibernate and save objects
        Configuration cfg = new Configuration();
        cfg.configure().addAnnotatedClass(Owner.class).addAnnotatedClass(House.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session s = sf.openSession();
        Transaction trans = s.beginTransaction();
        s.save(h3);
        s.save(h2);
        s.save(h1);
        s.save(o1);
        s.save(o2);
        trans.commit();
        s.close();
    }

    // Method to create an Owner object
    private static Owner createOwner(int oId, String oName, String oLocation) {
        Owner owner = new Owner();
        owner.setoId(oId);
        owner.setoName(oName);
        owner.setoLocation(oLocation);
        return owner;
    }

    // Method to create a House object
    private static House createHouse(int hId, String hLocation, int hRent) {
        House house = new House();
        house.sethId(hId);
        house.sethLocation(hLocation);
        house.sethRent(hRent);
        return house;
    }
}
