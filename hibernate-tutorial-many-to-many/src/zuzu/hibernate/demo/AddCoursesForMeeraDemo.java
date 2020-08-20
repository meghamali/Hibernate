package zuzu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import zuzu.hibernate.entity.Course;
import zuzu.hibernate.entity.Instructor;
import zuzu.hibernate.entity.InstructorDetail;
import zuzu.hibernate.entity.Review;
import zuzu.hibernate.entity.Student;

public class AddCoursesForMeeraDemo {

	public static void main(String... args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			int theId=27;
			
			Student theStudent=session.get(Student.class, theId);
			
			System.out.println("\nStudent details: "+theStudent);

			System.out.println("\nCourses: "+theStudent.getCourses());
			
			//create courses
			
			Course theCourse=new Course("Rubik's Cube- how to solve it!");
			
			Course theCourse1=new Course("Bootstrap-Learn to code with bootstrap");

			session.save(theCourse);
			session.save(theCourse1);
			
			
			theCourse.addStudent(theStudent);
			theCourse1.addStudent(theStudent);

			
			session.getTransaction().commit();
			
			
			System.out.println("\nDone!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
