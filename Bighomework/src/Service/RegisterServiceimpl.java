package Service;

import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dao.FormDao;
import Dao.Register;
import Dao.Registerimpl;
import Entity.HibernateUtil;
import Entity.Student;

public class RegisterServiceimpl implements RegisterService {

	@Override
	public void register(Student student) {
		// TODO Auto-generated method stub
		ApplicationContext aContext=new ClassPathXmlApplicationContext("/Service/applicationContext.xml");
		Register r=(Register)aContext.getBean("registerdao");
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		r.register(student);
		tx.commit();
	}

}
