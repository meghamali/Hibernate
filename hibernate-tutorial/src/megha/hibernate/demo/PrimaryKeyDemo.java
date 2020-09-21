package megha.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import megha.hibernate.entity.Student;

public class PrimaryKeyDemo {
	
	public static void main(String...args) {
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		
		try {
			Student theStudent=new Student("Fred","Weasly","fred@hotmail.com");
			Student theStudent1=new Student("Ronald","Weasly","ronaldweasly@hotmail.com");
			Student theStudent2=new Student("Hermione","Granger","hermionegranger@hotmail.com");
			
			
			session.beginTransaction();
			session.save(theStudent);
			session.save(theStudent1);
			session.save(theStudent2);

			session.getTransaction().commit();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			factory.close();
		}
	}

}
