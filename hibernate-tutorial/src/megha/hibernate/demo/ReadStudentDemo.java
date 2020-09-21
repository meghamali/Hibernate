package megha.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import megha.hibernate.entity.Student;

public class ReadStudentDemo {
	
	public static void main(String...args) {
		
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			
			Student theStudent=new Student("Harry","Potter","harry@hotmail.com");
			
			session.beginTransaction();
			
			session.save(theStudent);
			
			session.getTransaction().commit();
			
			System.out.println("\nGet primary key: "+theStudent.getId());
			
			session=factory.getCurrentSession();
			
			session.beginTransaction();
			
			Student myStudent=session.get(Student.class, theStudent.getId());
			
			System.out.println("\nStudent data: "+myStudent);
			
			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
