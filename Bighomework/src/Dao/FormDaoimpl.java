package Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;

import Entity.Book;
import Entity.Form;
import Entity.HibernateUtil;
import Entity.Recept;

public class FormDaoimpl implements FormDao{

	@Override
	public int getuserforms(int sid) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		Query query=session.createQuery("from Form f inner join fetch f.student inner join fetch f.recept inner join fetch f.book where f.student.id=?");
		query.setInteger(0,sid);
		List<Form> userForms=query.list();
		return userForms.size();
	}
	@Override//多表连接迫切内连接查询返回用户的订单。
	public List<Form> userforms(int sid,int offset) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		Query query=session.createQuery("from Form f inner join fetch f.student inner join fetch f.recept inner join fetch f.book where f.student.id=?").setFirstResult(offset).setMaxResults(7);
		query.setInteger(0,sid);
		List<Form> userForms=query.list();		
		return userForms;
	}
	//更新用户订单的领取状态
	@Override
	public void updateuserform(int fid) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		Form form=(Form) session.get(Form.class, fid);
		form.setL_status("已领取");
		session.update(form);
	}
	
	
	@Override//获取分页订单
	public List<Form> getalluserforms(int offset) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		Query query=session.createQuery("from Form").setFirstResult(offset).setMaxResults(7);		
		List<Form> forms=query.list();
		return forms;
	}
	@Override//获取订单总数
	public int getalluserformscount() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		Query query=session.createQuery("from Form");		
		List<Form> forms=query.list();
		return forms.size();
	}
	
	//获取未审核订单
	@Override
	public List<Form> gettotaluserforms(int offset) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		Query query=session.createQuery("from Form f where f.c_status='待审核'").setFirstResult(offset).setMaxResults(7);		
		List<Form> forms=query.list();
		return forms;
	}
	
	@Override
	public int gettotaluserformscount() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		Query query=session.createQuery("from Form f where f.c_status='待审核'");		
		List<Form> forms=query.list();
		return forms.size();
	}
	@Override
	public List<Form> getsnumberForms(String snumber,int offset) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		Query query=session.createQuery("from Form f where f.student.snumber=?").setFirstResult(offset).setMaxResults(7);
		query.setString(0, snumber);
		List<Form> forms=query.list();
		return forms;
	}
	@Override
	public int getsnumberformscount(String snumber) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		Query query=session.createQuery("from Form f where f.student.snumber=?");
		query.setString(0, snumber);
		List<Form> forms=query.list();
		return forms.size();
	}
	@Override
	public Form getselectform(int fid) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		Form form=(Form) session.get(Form.class, fid);
		
		return form;
		
		
	}
	@Override
	public void updateselectform(Form form, String status) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		form.setC_status(status);
		if (!status.equals("通过")) {
			Book book=form.getBook();
			book.setBookcount(book.getBookcount()+form.getCount());
			session.update(book);
		}
		session.update(form);
		
	}
	@Override
	public List<Form> getallrecepts(int offset) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		Query query=session.createQuery("from Form f where f.c_status='通过'").setFirstResult(offset).setMaxResults(7);
		List<Form> forms=query.list();
		return forms;
		
	}
	@Override
	public int getallreceptscount() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		Query query=session.createQuery("from Form f where f.c_status='通过'");
		
		List<Form> forms=query.list();
		return forms.size();
	}
	@Override
	public void updateselectrecept(Recept recept, String status) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		recept.setStatus(status);
		session.update(recept);
		
	}
	@Override
	public void addbookcount(Book book, int count) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		book.setBookcount(book.getBookcount()+count);
		session.update(book);
	}
	
	

}
