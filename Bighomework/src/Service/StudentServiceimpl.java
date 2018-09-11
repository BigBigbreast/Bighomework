package Service;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dao.BookDao;
import Dao.FormDao;
import Dao.StudentDao;
import Dao.StudentDaoimpl;
import Entity.HibernateUtil;
import Entity.Student;

public class StudentServiceimpl implements StudentService {
	private StudentDao getstudent;
	
	public StudentDao getGetstudent() {
		return getstudent;
	}

	public void setGetstudent(StudentDao getstudent) {
		this.getstudent = getstudent;
	}

	@Override//获取所有的学生信息
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		//ApplicationContext aContext=new ClassPathXmlApplicationContext("/Service/applicationContext.xml");
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		List<Student> students=getstudent.getStudents();	
		return students;
	}

}
