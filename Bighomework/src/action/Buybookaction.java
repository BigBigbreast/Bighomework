package action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import Entity.Book;
import Entity.Student;
import Service.BookService;
import Service.BookServiceimpl;

public class Buybookaction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String buybookcount;
	
	ApplicationContext aContext=new ClassPathXmlApplicationContext("/action/applicationContext.xml");
	
	private BookService bookService=(BookService)aContext.getBean("buybook");
	public String getBuybookcount() {
		return buybookcount;
	}

	public void setBuybookcount(String buybookcount) {
		this.buybookcount = buybookcount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String selectbook(){
		int id=Integer.parseInt(this.id);
		ValueStack valueStack=ActionContext.getContext().getValueStack();
		
		
		
		Book userselectbook=bookService.getselectBook(id);
		
		valueStack.setValue("#session.userselectbook", userselectbook );
		return "success";		
	}
	
	public String buyselectbook(){
		ValueStack valueStack=ActionContext.getContext().getValueStack();
		Book book=(Book) valueStack.findValue("#session.userselectbook");
		Student student=(Student) valueStack.findValue("#session.student");
		
		int count=Integer.parseInt(this.buybookcount);
		if(count<=(int)valueStack.findValue("#session.userselectbook.bookcount")){
			bookService.buybook(book, student,count);
			return "success";
		}
		return "input";		
	}
	
	
    public void validateBuyselectbook() {
    	// TODO Auto-generated method stub
    	super.validate();
    	ValueStack valueStack=ActionContext.getContext().getValueStack();
    	 Book book=(Book) valueStack.findValue("#session.userselectbook");
    	int count=book.getBookcount();
    	 if(Integer.parseInt(this.buybookcount)>count){
    		 this.addFieldError("buybookcount", "库存不足");
    	 }
    	
    }
	
	
}
