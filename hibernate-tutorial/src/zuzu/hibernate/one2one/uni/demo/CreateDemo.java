package zuzu.hibernate.one2one.uni.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import zuzu.hibernate.entity.Instructor;
import zuzu.hibernate.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String... args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			
			Instructor theInstructor=new Instructor("Harry","Potter","hp@gmail.com");
			
			InstructorDetail theInstructorDetail=new InstructorDetail("http://www.hogwarts.com","Queditch");
			
			theInstructor.setInstructorDetail(theInstructorDetail);
			
			session.beginTransaction();
			
			session.save(theInstructor);
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}
}
