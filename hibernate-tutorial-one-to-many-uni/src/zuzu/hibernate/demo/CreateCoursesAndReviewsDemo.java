package zuzu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import zuzu.hibernate.entity.Course;
import zuzu.hibernate.entity.Instructor;
import zuzu.hibernate.entity.InstructorDetail;
import zuzu.hibernate.entity.Review;

public class CreateCoursesAndReviewsDemo {

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
			
			Course theCourse=new Course("Angular");
			theCourse.add(new Review("The besst!"));
			theCourse.add(new Review("Awesome!"));
			theCourse.add(new Review("boring!"));
			
			session.save(theCourse);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
