package zuzu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import zuzu.hibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String... args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			int id = 6;
			session.beginTransaction();

			Student theStudent = session.get(Student.class, id);

			session.delete(theStudent);

			session.getTransaction().commit();

			// condionally delete

			session = factory.getCurrentSession();

			session.beginTransaction();

			session.createQuery("delete from Student where id='10'").executeUpdate();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
}
