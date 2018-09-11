package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import Entity.Book;
import Entity.Form;
import Service.BookService;
import Service.BookServiceimpl;
import page.PageBean;
import page.PageBeanform;

public class LookBookaction {
	private int page;
	private String keywords;
	//private ApplicationContext aContext=new ClassPathXmlApplicationContext("/action/applicationContext.xml");
	
	private BookService bookService;
			
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	//查看所有书籍操作
	public String lookbook(){
		PageBean pageBean=bookService.getBooks(this.page);
		List<Book> books=pageBean.getList();
		ValueStack vStack=ActionContext.getContext().getValueStack();
		vStack.setValue("#session.books", books);
		HttpServletRequest request = ServletActionContext.getRequest();        
        request.setAttribute("pageBean", pageBean);
		return "success";		
	}
	
	//按照关键字搜索指定的书。
	public String searchbooks(){
			
		PageBean pageBean=bookService.getkeyBooks(keywords, page);
		List<Book> keybooks=pageBean.getList();
		ValueStack vStack=ActionContext.getContext().getValueStack();
		vStack.setValue("#session.keybooks",keybooks);
		vStack.setValue("#session.keywords", this.keywords);
		HttpServletRequest request = ServletActionContext.getRequest();        
        request.setAttribute("pageBean", pageBean);
		return "success";		
	}
	
	
	

}
