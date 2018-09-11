package Service;

import java.util.List;

import javax.enterprise.inject.New;

import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dao.BookDao;
import Dao.BookDaoimpl;
import Entity.Book;
import Entity.Form;
import Entity.HibernateUtil;
import Entity.Student;
import page.PageBean;
import page.PageBeanform;

public class BookServiceimpl implements BookService {
	private BookDao dao;
	public BookDao getDao() {
		return dao;
	}
	public void setDao(BookDao dao) {
		this.dao = dao;
	}

	@Override//获取所有图书，返回List集合
	public PageBean getBooks(int page) {
		PageBean pageBean=new PageBean();
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		int allrows=dao.getallbookrows();
		int totalPage=pageBean.getTotalPages(7, allrows);
		int currentpage=pageBean.getCurPage(page);
		int offset=pageBean.getCurrentPageOffset(7, currentpage);
		List<Book> books=dao.getBooks(offset);
		tx.commit();		
		pageBean.setList(books);
		pageBean.setAllRows(allrows);
	    pageBean.setCurrentPage(currentpage);
	    pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	@Override
	public void buybook(Book book, Student s, int count) {
		// TODO Auto-generated method stub		
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		dao.buyBook(book, s, count);
		tx.commit();
	}

	@Override
	public PageBean getkeyBooks(String key,int page) {
		// TODO Auto-generated method stub
		PageBean pageBean=new PageBean();
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		int allrows=dao.getallkeybooks(key);
		int totalPage=pageBean.getTotalPages(7, allrows);
		int currentpage=pageBean.getCurPage(page);
		int offset=pageBean.getCurrentPageOffset(7, currentpage);
		List<Book> books=dao.getkeybooks(key, offset);
		tx.commit();		
		pageBean.setList(books);
		pageBean.setAllRows(allrows);
	    pageBean.setCurrentPage(currentpage);
	    pageBean.setTotalPage(totalPage);
		return pageBean;
	}

	

	@Override
	public Book getselectBook(int id) {
		// TODO Auto-generated method stub
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		Book book=dao.getselectbook(id);
		tx.commit();
		return book;
	}

	@Override
	public void addnewbook(Book book) {
		// TODO Auto-generated method stub
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		dao.addnewbook(book);
		tx.commit();
	}

	

}
