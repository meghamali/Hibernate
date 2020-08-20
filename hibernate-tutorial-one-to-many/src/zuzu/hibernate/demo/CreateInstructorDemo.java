package zuzu.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import zuzu.hibernate.entity.Course;
import zuzu.hibernate.entity.Instructor;
import zuzu.hibernate.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String... args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			Instructor theInstructor=new Instructor("Harry","Potter","hp@gmail.com");
			InstructorDetail theDetail=new InstructorDetail("http://www.wizarding.com","animals");
			
			theInstructor.setInstructorDetail(theDetail);
			session.beginTransaction();
			
			session.save(theInstructor);

			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
