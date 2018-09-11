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
	private Register register;
	
	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	@Override
	public void register(Student student) {
		// TODO Auto-generated method stub
		ApplicationContext aContext=new ClassPathXmlApplicationContext("/Service/applicationContext.xml");
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		register.register(student);
		tx.commit();
	}

}
