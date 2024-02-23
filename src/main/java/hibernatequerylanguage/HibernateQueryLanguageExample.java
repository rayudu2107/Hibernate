package hibernatequerylanguage;

import java.util.Arrays;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class HibernateQueryLanguageExample {
    public static void main(String[] args) {
        // Creating students using createStudent method
        Student s1 = createStudent(11, "Harinath");
        Student s2 = createStudent(12, "Mahesh");
        Student s3 = createStudent(13, "Basha");

        // Creating books using createBook method
        Book b1 = createBook(1, "Java");
        Book b2 = createBook(2, "Sql");
        Book b3 = createBook(3, "Hibernate");

        // Adding books to students' book lists
        s1.getbList().add(b1);
        s2.getbList().add(b2);
        s3.getbList().add(b3);

        // Setting student references for each book
        b1.setStudent(s1);
        b2.setStudent(s2);
        b3.setStudent(s3);

        // Creating Hibernate configuration
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class)
                .addAnnotatedClass(Book.class);
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction trans = session.beginTransaction();

        // Saving objects to the database
//        session.save(s1);
//        session.save(s2);
//        session.save(s3);
//        session.save(b1);
//        session.save(b2);
//        session.save(b3);

        System.out.println("===============Query=================");
        // Retrieving students using HQL (Hibernate Query Language)
        Query<Student> query = session.createQuery("from Student", Student.class);
        List<Student> students = query.list();
        for (Student s : students) {
            System.out.println(s.getStuId() + "        " + s.getStuName() + "    " + s.getbList());
        }

        System.out.println("======================NativeQuery====================");

        // Method-1: Using Native SQL Query with Entity Mapping
        NativeQuery<Student> nativeQuery1 = session.createNativeQuery("Select * from student", Student.class);
        List<Student> students1 = nativeQuery1.list();
        for (Student s : students1) {
            System.out.println(s.getStuId() + "        " + s.getStuName() + "    " + s.getbList());
        }

        // Method-2: Using Native SQL Query without Entity Mapping
        NativeQuery<Object[]> nativeQuery2 = session.createSQLQuery("Select * from student");
        List<Object[]> students2 = nativeQuery2.list();
        for (Object[] student : students2)
            System.out.println(Arrays.deepToString(student));

        // Criteria Query: Retrieving student by ID
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteria1 = builder.createQuery(Student.class);
        Root<Student> root1 = criteria1.from(Student.class);
        criteria1.select(root1);
        criteria1.where(builder.equal(root1.get("stuId"), 11));

        Query<Student> query1 = session.createQuery(criteria1);
        List<Student> list2 = query1.list();
        list2.forEach(System.out::println);

        // DELETE BY ID using CriteriaDelete
        CriteriaBuilder builder2 = session.getCriteriaBuilder();
        CriteriaDelete<Student> criteriaDelete = builder2.createCriteriaDelete(Student.class);
        Root<Student> root2 = criteriaDelete.from(Student.class);
        criteriaDelete.where(builder2.equal(root2.get("stuId"), 11));
        int rs1 = session.createQuery(criteriaDelete).executeUpdate();
        System.out.println(rs1);

        // DELETE ALL using CriteriaDelete
        CriteriaBuilder builder3 = session.getCriteriaBuilder();
        CriteriaDelete<Student> criteriaDeleteAll = builder3.createCriteriaDelete(Student.class);
        Root<Student> root3 = criteriaDeleteAll.from(Student.class);
        int rs2 = session.createQuery(criteriaDeleteAll).executeUpdate();
        System.out.println(rs2);

        // UPDATE BY ID using CriteriaUpdate
        CriteriaBuilder builder4 = session.getCriteriaBuilder();
        CriteriaUpdate<Student> criteriaUpdate = builder4.createCriteriaUpdate(Student.class);
        Root<Student> root4 = criteriaUpdate.from(Student.class);
        criteriaUpdate.set("stuName", "Harinath");
        criteriaUpdate.where(builder4.equal(root4.get("stuId"), 11));
        int rs3 = session.createQuery(criteriaUpdate).executeUpdate();
        System.out.println(rs3);

        // UPDATE ALL using CriteriaUpdate
        CriteriaBuilder builder5 = session.getCriteriaBuilder();
        CriteriaUpdate<Student> criteriaUpdateAll = builder5.createCriteriaUpdate(Student.class);
        Root<Student> root5 = criteriaUpdateAll.from(Student.class);
        criteriaUpdateAll.set("stuName", "NewName");
        int rs4 = session.createQuery(criteriaUpdateAll).executeUpdate();
        System.out.println(rs4);

        trans.commit();

        // Closing session and session factory
        session.close();
        sf.close();
    }

    // Method to create a student with given ID and name
    public static Student createStudent(int stuId, String stuName) {
        Student student = new Student();
        student.setStuId(stuId);
        student.setStuName(stuName);
        return student;
    }

    // Method to create a book with given ID and name
    public static Book createBook(int bId, String bName) {
        Book book = new Book();
        book.setbId(bId);
        book.setbName(bName);
        return book;
    }
}
