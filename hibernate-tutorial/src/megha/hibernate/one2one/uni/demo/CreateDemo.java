package megha.hibernate.one2one.uni.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import megha.hibernate.entity.Instructor;
import megha.hibernate.entity.InstructorDetail;
import megha.hibernate.entity.Student;

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
			
			//theInstructor.setInstructorDetail(theInstructorDetail);
			
			session.beginTransaction();
			
			List<Instructor> theInstructors = session.createQuery("from Instructor").getResultList();
			
			
			
			//
			//System.out.println(theInstructors.get);
			//session.save(theInstructor);
			
			session.getTransaction().commit();
			
			System.out.println(theInstructors);
			for(Instructor instructor:theInstructors) {
				System.out.println(instructor.getInstructorDetail().getYoutubeChannel());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}
}
