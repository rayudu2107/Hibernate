package mapping.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyExample {
	public static void main(String[] args) {
		// Create customers
		Customer c1 = createCustomer(10, "Prakash");
		Customer c2 = createCustomer(11, "Mahesh");
		Customer c3 = createCustomer(12, "Harinath");

		// Create items
		Item i1 = createItem(101, "Curd", 12);
		Item i2 = createItem(102, "Cone ice cream", 40);
		Item i3 = createItem(103, "Strawberry", 50);

		// Associate customers with items
		c1.getItems().add(i1);
		c1.getItems().add(i2);
		c1.getItems().add(i3);

		c2.getItems().add(i1);
		c2.getItems().add(i2);

		c3.getItems().add(i3);

		// Associate items with customers
		i1.getCustomers().add(c1);
		i1.getCustomers().add(c2);
		i2.getCustomers().add(c1);
		i2.getCustomers().add(c2);
		i3.getCustomers().add(c1);
		i3.getCustomers().add(c3);

		// Configuring Hibernate
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Item.class);
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// Saving objects to the database
		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(i1);
		session.save(i2);
		session.save(i3);

		// Committing transaction and closing session
		transaction.commit();
		session.close();
	}

	// Method to create a customer
	public static Customer createCustomer(int cId, String cName) {
		Customer customer = new Customer();
		customer.setcId(cId);
		customer.setcName(cName);
		return customer;
	}

	// Method to create an item
	public static Item createItem(int iId, String iName, int iPrice) {
		Item item = new Item();
		item.setiId(iId);
		item.setiName(iName);
		item.setiPrice(iPrice);
		return item;
	}
}
