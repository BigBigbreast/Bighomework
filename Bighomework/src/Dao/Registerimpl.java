package Dao;

import org.hibernate.Hibernate;
import org.hibernate.classic.Session;

import Entity.HibernateUtil;
import Entity.Student;

public class Registerimpl implements Register {

	@Override
	public void register(Student student) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		session.save(student);
	}

}
