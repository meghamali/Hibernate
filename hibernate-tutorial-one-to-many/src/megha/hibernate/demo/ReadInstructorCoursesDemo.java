package megha.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import megha.hibernate.entity.Course;
import megha.hibernate.entity.Instructor;
import megha.hibernate.entity.InstructorDetail;

public class ReadInstructorCoursesDemo {

	public static void main(String... args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			Instructor theInstructor=session.get(Instructor.class, 15);
			
			System.out.println(theInstructor);
			
			System.out.println(theInstructor.getCourses());

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
