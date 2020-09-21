package megha.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import megha.hibernate.entity.Course;
import megha.hibernate.entity.Instructor;
import megha.hibernate.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String... args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
			Course theCourse=session.get(Course.class,19);
			
			//theCourse.setInstructor(null);
			
			System.out.println(theCourse);
			
			session.delete(theCourse);

			session.getTransaction().commit();
			System.out.println("Done!!!!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
