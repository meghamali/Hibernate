package zuzu.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import zuzu.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String... args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			// get all the data

			session.beginTransaction();

			List<Student> getStudents = session.createQuery("from Student").getResultList();

			displayStudents(getStudents);

			// last name=potter

			System.out.println("\n Last name= Potter only... ");

			getStudents = session.createQuery("from Student where lastName='Potter'").getResultList();

			displayStudents(getStudents);

			// last name =potter OR firstname=fred

			System.out.println("\n\n last name or first name condition");
			getStudents = session.createQuery("from Student where lastName='Potter' OR firstName='Fred'")
					.getResultList();

			displayStudents(getStudents);

			// like clause
			System.out.println("\n\n Like clause");

			getStudents = session.createQuery("from Student where email like '%hotmail.com'").getResultList();
			displayStudents(getStudents);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> getStudents) {
		for (Student theStudent : getStudents) {
			System.out.println(theStudent);
		}
	}

}
