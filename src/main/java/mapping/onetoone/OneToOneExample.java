package mapping.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneExample {
	public static void main(String[] args) {
		// Create Pan instances
		Pan pan1 = createPan(1001, "HARESH V", "BLR");
		Pan pan2 = createPan(1002, "JOHN DOE", "NYC");
		Pan pan3 = createPan(1003, "ALICE SMITH", "LON");

		// Create Person instances
		Persons person1 = createPerson(101, "HARESH V", 9750082373L);
		Persons person2 = createPerson(102, "JOHN DOE", 9876543210L);
		Persons person3 = createPerson(103, "ALICE SMITH", 9871234560L);

		person1.setPan(pan1);
		person2.setPan(pan2);
		person3.setPan(pan3);
		
		// Hibernate configuration
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Pan.class)
				.addAnnotatedClass(Persons.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Save entities
		session.save(pan1);
		session.save(pan2);
		session.save(pan3);
		session.save(person1);
		session.save(person2);
		session.save(person3);

		// Commit the transaction and close the session
		transaction.commit();
		session.close();
	}

	private static Pan createPan(int pId, String pName, String pLocation) {
		Pan pan = new Pan();
		pan.setpId(pId);
		pan.setpName(pName);
		pan.setpLocation(pLocation);
		return pan;
	}

	private static Persons createPerson(int pID, String pName, long pContact) {
		Persons person = new Persons();
		person.setpID(pID);
		person.setpName(pName);
		person.setPcontact(pContact);
		return person;
	}
}
