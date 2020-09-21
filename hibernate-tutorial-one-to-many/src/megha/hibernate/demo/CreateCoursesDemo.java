package megha.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import megha.hibernate.entity.Course;
import megha.hibernate.entity.Instructor;
import megha.hibernate.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			Course theCourse1=new Course("Cricket");
			Course theCourse2=new Course("Hockey");
			Course theCourse3=new Course("Baseball");
			Course theCourse4=new Course("kho-kho");
			
			theInstructor.add(theCourse1);
			theInstructor.add(theCourse2);
			theInstructor.add(theCourse3);
			theInstructor.add(theCourse4);

			session.save(theCourse1);
			session.save(theCourse2);
			session.save(theCourse3);
			session.save(theCourse4);


			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
