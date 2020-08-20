package zuzu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import zuzu.hibernate.entity.Course;
import zuzu.hibernate.entity.Instructor;
import zuzu.hibernate.entity.InstructorDetail;
import zuzu.hibernate.entity.Review;
import zuzu.hibernate.entity.Student;

public class CreateCoursesAndStudentsDemo {

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
			
			Course theCourse=new Course("Angular");
			
			session.save(theCourse);
			
			//create students
			Student theStudent1=new Student("Megha","Mali","meghamali@gmail.com");
			Student theStudent2=new Student("Meera","Kumari",",meenakumari@gmail.com");
			Student theStudent3=new Student("Bahubali","Singh","bahubali@gmail.com");
			
			theCourse.addStudent(theStudent1);
			theCourse.addStudent(theStudent2);
			theCourse.addStudent(theStudent3);
			
			System.out.println("\nSaving students!!\n");
			
			session.save(theStudent1);
			session.save(theStudent2);
			session.save(theStudent3);

			System.out.println("\nStudents saved!!\n");

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
