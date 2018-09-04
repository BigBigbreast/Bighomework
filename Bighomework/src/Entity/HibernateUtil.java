package Entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	static{
		Configuration configuration=new Configuration();
		configuration.configure();
		sessionFactory=configuration.buildSessionFactory();
	}
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	public static Session getCurrSession(){
		return sessionFactory.getCurrentSession();
	}
	

}
