package mapping.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToOneMappingExample {
    public static void main(String[] args) {

        // Creating vehicle objects
        Vechicle bike1 = createVechicle(1001, "RX100", 80000);
        Vechicle bike2 = createVechicle(1002, "ROYAL ENFIELD", 50000);
        Vechicle bike3 = createVechicle(1003, "KTM", 800000);

        // Creating person objects
        Person person1 = createPerson(100, "Harinath", 85454L); // Use Long instead of long
        Person person2 = createPerson(101, "Haresh", 85454L); // Use Long instead of long

        // Associating vehicles with persons
        bike1.setPerson(person1);
        bike2.setPerson(person1);
        bike3.setPerson(person2);

        // Configuring Hibernate
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Vechicle.class);
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // Beginning transaction
        Transaction transaction = session.beginTransaction();

        // Saving objects to the database
        session.save(bike1);
        session.save(bike2);
        session.save(bike3);
        session.save(person1);
        session.save(person2);

        // Committing transaction
        transaction.commit();
        session.close(); // Closing session
    }

    // Factory method to create Vechicle instances
    public static Vechicle createVechicle(int vId, String vName, double vPrice) {
        Vechicle vechicle = new Vechicle();
        vechicle.setvId(vId);
        vechicle.setvName(vName);
        vechicle.setvPrice(vPrice); // Corrected typo
        return vechicle;
    }

    // Factory method to create Person instances
    public static Person createPerson(int pId, String pName, Long pContact) { // Use Long instead of long
        Person person = new Person();
        person.setpId(pId);
        person.setpName(pName);
        person.setpContact(pContact);
        return person;
    }
}
