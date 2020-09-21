package megha.hibernate.one2one.bi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import megha.hibernate.entity.Instructor;
import megha.hibernate.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String... args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {

			session.beginTransaction();
			
			int id=14;
			
			InstructorDetail theInstructorDetail =session.get(InstructorDetail.class, id);
			
			session.getTransaction().commit();
			
			System.out.println(theInstructorDetail);
			System.out.println(theInstructorDetail.getTheInstructor());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}
}
