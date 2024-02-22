package mapping.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyExample {
	public static void main(String[] args) {
		// Creating company objects
		Company c1 = createCompany(101, "TCS", "Electronic city");
		Company c2 = createCompany(102, "INFOSYS", "Marhahalli");
		Company c3 = createCompany(103, "WHIPRO", "Kengeri");

		// Creating employee objects
		Employee e1 = createEmployee(1001, "Pradeep", 82286822);
		Employee e2 = createEmployee(1002, "Haresh", 646646);

		// Adding companies to employees
		e1.getCompanies().add(c1);
		e1.getCompanies().add(c2);
		e2.getCompanies().add(c3);

		// Configuring Hibernate
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Company.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session os = sf.openSession();
		Transaction trans = os.beginTransaction();

		// Saving objects
		os.save(c1);
		os.save(c2);
		os.save(c3);
		os.save(e1);
		os.save(e2);

		// Committing the transaction and closing the session
		trans.commit();
		os.close();
	}

	private static Company createCompany(int cId, String cName, String cLocation) {
		Company company = new Company();
		company.setcId(cId);
		company.setcName(cName);
		company.setcLocation(cLocation);
		return company;
	}

	private static Employee createEmployee(int eId, String eName, int eContact) {
		Employee employee = new Employee();
		employee.seteId(eId);
		employee.seteName(eName);
		employee.seteContact(eContact);
		return employee;
	}
}
