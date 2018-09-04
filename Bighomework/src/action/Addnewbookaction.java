package action;

import javax.faces.application.Application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;

import Dao.BookDao;
import Entity.Book;
import Service.BookService;
import Service.BookServiceimpl;

public class Addnewbookaction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bookname;
	private String bookwriter;
	private String bookplace;
	private String bookcount;
	private String bookprice;
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookwriter() {
		return bookwriter;
	}
	public void setBookwriter(String bookwriter) {
		this.bookwriter = bookwriter;
	}
	public String getBookplace() {
		return bookplace;
	}
	public void setBookplace(String bookplace) {
		this.bookplace = bookplace;
	}
	public String getBookcount() {
		return bookcount;
	}
	public void setBookcount(String bookcount) {
		this.bookcount = bookcount;
	}
	public String getBookprice() {
		return bookprice;
	}
	public void setBookprice(String bookprice) {
		this.bookprice = bookprice;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public String addbook(){
		Book book=new Book();
		book.setBookcount(Integer.parseInt(bookcount));
		book.setBookname(bookname);
		book.setBookplace(bookplace);
		book.setBookprice(Double.parseDouble(bookprice));
		book.setBookwriter(bookwriter);
		ApplicationContext aContext=new ClassPathXmlApplicationContext("/action/applicationContext.xml");
		BookService bookService=(BookService) aContext.getBean("addnewbook");
		bookService.addnewbook(book);
		return "success";
		
		
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
		
		String bookplace=this.bookplace;
		
		if (!bookplace.contains("出版社")) {
			this.addFieldError("2","输入的出版社信息不正确");
		
		}
		if(!as()){
			this.addFieldError("3","输入格式不正确");
		}
	}
	public boolean as(){
		String bookprice=this.bookprice;
		try {
			Double.parseDouble(bookprice);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
