package mapping.bidirectionalmapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class BidirectionalMappingOneToManyAndManyToOne {
    public static void main(String[] args) {
        // Creating Vehicle objects
        Vehicle v1 = createVehicle(1001, "RX100", 80000);
        Vehicle v2 = createVehicle(1002, "ROYAL ENFIELD", 50000);
        Vehicle v3 = createVehicle(1003, "KTM", 800000);

        // Creating Person objects
        Person p1 = createPerson(100, "Harinath", 85454L);
        Person p2 = createPerson(101, "Haresh", 85454L);

        // Associating Vehicles with Persons
        p2.getVehicles().add(v2);
        p2.getVehicles().add(v3);
        p1.getVehicles().add(v1);

        v1.setPerson(p1);
        v2.setPerson(p2);
        v3.setPerson(p2);

        // Configuring Hibernate and saving objects to the database
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Vehicle.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session os = sf.openSession();
        Transaction trans = os.beginTransaction();
        os.save(v1);
        os.save(v2);
        os.save(v3);
        os.save(p1);
        os.save(p2);
        trans.commit();
        os.close();
    }

    // Factory method to create Vehicle instances
    public static Vehicle createVehicle(int vId, String vName, double vPrice) {
        Vehicle vehicle = new Vehicle();
        vehicle.setvId(vId);
        vehicle.setvName(vName);
        vehicle.setvPrice((int) vPrice);
        return vehicle;
    }

    // Factory method to create Person instances
    public static Person createPerson(int pId, String pName, Long pContact) {
        Person person = new Person();
        person.setpId(pId);
        person.setpName(pName);
        person.setpContact(pContact.intValue());
        return person;
    }
}
