package Service;

import java.util.List;

import javax.enterprise.inject.New;

import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dao.BookDao;
import Dao.FormDao;
import Dao.FormDaoimpl;
import Entity.Book;
import Entity.Form;
import Entity.HibernateUtil;
import Entity.Recept;
import page.PageBeanform;

public class FormServiceimpl implements FormService {
	private static ApplicationContext aContext=new ClassPathXmlApplicationContext("/Service/applicationContext.xml");
	private static FormDao dao=(FormDao) aContext.getBean("formdao");
	@Override
	public PageBeanform getuserforms(int sid,int page) {
		// TODO Auto-generated method stub		
		PageBeanform pageBeanform=new PageBeanform();
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		int allrows=dao.getuserforms(sid);
		int totalPage=pageBeanform.getTotalPages(7, allrows);
		int currentpage=pageBeanform.getCurPage(page);
		int offset=pageBeanform.getCurrentPageOffset(7, currentpage);
		List<Form> forms=dao.userforms(sid, offset);
		tx.commit();		
		pageBeanform.setList(forms);
		pageBeanform.setAllRows(allrows);
	    pageBeanform.setCurrentPage(currentpage);
	    pageBeanform.setTotalPage(totalPage);		
		return pageBeanform;
	}
	
	@Override
	public void updateuserselect(int fid) {
		// TODO Auto-generated method stub
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		dao.updateuserform(fid);
		tx.commit();
	}

	@Override
	public PageBeanform getalluserforms(int page) {
		// TODO Auto-generated method stub
		PageBeanform pageBeanform=new PageBeanform();
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		int allrows=dao.getalluserformscount();
		int totalPage=pageBeanform.getTotalPages(7, allrows);
		int currentpage=pageBeanform.getCurPage(page);
		int offset=pageBeanform.getCurrentPageOffset(7, currentpage);
		List<Form> forms=dao.getalluserforms(offset);
		tx.commit();		
		pageBeanform.setList(forms);
		pageBeanform.setAllRows(allrows);
	    pageBeanform.setCurrentPage(currentpage);
	    pageBeanform.setTotalPage(totalPage);		
		return pageBeanform;
		
	}

	//获取未审核分页订单
	@Override
	public PageBeanform gettotaluserforms(int page) {
		// TODO Auto-generated method stub
		PageBeanform pageBeanform=new PageBeanform();
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		int allrows=dao.gettotaluserformscount();
		int totalPage=pageBeanform.getTotalPages(7, allrows);
		int currentpage=pageBeanform.getCurPage(page);
		int offset=pageBeanform.getCurrentPageOffset(7, currentpage);
		List<Form> forms=dao.gettotaluserforms(offset);
		tx.commit();		
		pageBeanform.setList(forms);
		pageBeanform.setAllRows(allrows);
	    pageBeanform.setCurrentPage(currentpage);
	    pageBeanform.setTotalPage(totalPage);		
		return pageBeanform;
	
	}

	@Override
	public PageBeanform getsnumberuserforms(String snumber, int page) {
		// TODO Auto-generated method stub
		PageBeanform pageBeanform=new PageBeanform();
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		int allrows=dao.getsnumberformscount(snumber);
		int totalPage=pageBeanform.getTotalPages(7, allrows);
		int currentpage=pageBeanform.getCurPage(page);
		int offset=pageBeanform.getCurrentPageOffset(7, currentpage);
		List<Form> forms=dao.getsnumberForms(snumber, offset);
		tx.commit();		
		pageBeanform.setList(forms);
		pageBeanform.setAllRows(allrows);
	    pageBeanform.setCurrentPage(currentpage);
	    pageBeanform.setTotalPage(totalPage);		
		return pageBeanform;
	}

	@Override
	public Form getselectform(int fid) {
		// TODO Auto-generated method stub
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		Form form =dao.getselectform(fid);
		tx.commit();		
		
		return form;
	}

	@Override
	public void updateselectform(Form form, String status) {
		// TODO Auto-generated method stub
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		dao.updateselectform(form, status);
		tx.commit();
	}

	@Override
	public PageBeanform getallrecepts(int page) {
		// TODO Auto-generated method stub
		PageBeanform pageBeanform=new PageBeanform();
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		int allrows=dao.getallreceptscount();
		int totalPage=pageBeanform.getTotalPages(7, allrows);
		int currentpage=pageBeanform.getCurPage(page);
		int offset=pageBeanform.getCurrentPageOffset(7, currentpage);
		List<Form> forms=dao.getallrecepts(offset);
		tx.commit();		
		pageBeanform.setList(forms);
		pageBeanform.setAllRows(allrows);
	    pageBeanform.setCurrentPage(currentpage);
	    pageBeanform.setTotalPage(totalPage);		
		return pageBeanform;
		
	}

	@Override
	public void updateselectrecept(Recept recept, String status) {
		// TODO Auto-generated method stub
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		dao.updateselectrecept(recept, status);
		tx.commit();
	}

	@Override
	public void addbookcount(Book book, int count) {
		// TODO Auto-generated method stub
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		dao.addbookcount(book, count);
		tx.commit();
	}
}
