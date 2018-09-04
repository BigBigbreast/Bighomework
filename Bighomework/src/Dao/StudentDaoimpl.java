package Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import Entity.HibernateUtil;
import Entity.Student;

public class StudentDaoimpl implements StudentDao {

	@Override//获取所有的用户信息。
	public List<Student> getStudents() {
		Session session=HibernateUtil.getCurrSession();
		Query query=session.createQuery("from Student");
		List<Student> students=query.list();
		return students;
	}

}
