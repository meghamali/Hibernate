package megha.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import megha.hibernate.entity.Course;
import megha.hibernate.entity.Instructor;
import megha.hibernate.entity.InstructorDetail;
import megha.hibernate.entity.Review;

public class ReadCoursesAndReviewsDemo {

	public static void main(String... args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int theId=21;
			
			Course theCourse=session.get(Course.class, theId);
			
			System.out.println(theCourse);
			
			
			System.out.println("\n"+theCourse.getReview());

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
