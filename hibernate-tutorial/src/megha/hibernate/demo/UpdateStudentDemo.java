package megha.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import megha.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String... args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int id=7;
			session.beginTransaction();
			
			Student theStudent=session.get(Student.class, id);
			
			theStudent.setFirstName("James");
			
			session.getTransaction().commit();
			
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//update all emails
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
