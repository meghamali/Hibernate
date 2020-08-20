package zuzu.hibernate.one2one.bi.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import zuzu.hibernate.entity.Instructor;
import zuzu.hibernate.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			
			session.delete(theInstructorDetail);

			
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