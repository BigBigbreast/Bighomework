package Dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.classic.Session;

import Entity.Book;
import Entity.Form;
import Entity.HibernateUtil;
import Entity.Recept;
import Entity.Student;

public class BookDaoimpl implements BookDao {

	
	@Override
	public List<Book> getBooks(int offset) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		Query query=session.createQuery("from Book").setFirstResult(offset).setMaxResults(7);
		List<Book> books=query.list();
		return books;
	}
	@Override
	public int getallbookrows() {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		Query query=session.createQuery("from Book");
		int allrows=query.list().size();
		return allrows;
	}
	
	@Override
	public void buyBook(Book book, Student s, int count) {
		Session session= HibernateUtil.getCurrSession();
		session.clear();
		Recept recept=new Recept();
		recept.setBeginname("郑州大学");
		recept.setStatus("待开");
		
		Form form=new Form();
		form.setBook(book);
		form.setCount(count);
		form.setStudent(s);
		form.setRecept(recept);
		form.setC_status("待审核");
		form.setL_status("待领取");
		form= (Form) session.merge(form);
		session.save(form);	
		Book book2=(Book) session.get(Book.class, book.getId());
		book2.setBookcount(book2.getBookcount()-count);
		session.update(book2);
		
	}
 
	@Override
	public int getallkeybooks(String keywords) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		Query query=session.createQuery("from Book as book where book.bookname like:key");
		query.setString("key", "%"+keywords+"%");
		List<Book> keybooks=query.list();
		
		return keybooks.size();
	}
	public List<Book> getkeybooks(String keywords,int offset) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		Query query=session.createQuery("from Book as book where book.bookname like:key").setFirstResult(offset).setMaxResults(7);
		query.setString("key","%"+keywords+"%");
		List<Book> keybooks=query.list();
		return keybooks;
	}

	
	@Override
	public Book getselectbook(int id) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		Book book=(Book) session.get(Book.class,id);		
		return book;		
	}
	@Override
	public void addnewbook(Book book) {
		// TODO Auto-generated method stub
		Session session=HibernateUtil.getCurrSession();
		session.save(book);
		
	}
	
	

	
	
	

}
