package zuzu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import zuzu.hibernate.entity.Course;
import zuzu.hibernate.entity.Instructor;
import zuzu.hibernate.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String... args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			int theId = 15;

			Query<Instructor> query = session
					.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:theId");
			
			query.setParameter("theId", theId);
			
			Instructor theInstructor=query.getSingleResult();

			System.out.println(theInstructor);

			session.getTransaction().commit();

			System.out.println("\nSession closed!\n");

			session.close();

			System.out.println(theInstructor.getCourses());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
