package action;

import java.util.List;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import Entity.Book;
import Entity.Form;
import Entity.Recept;
import Service.BookService;
import Service.BookServiceimpl;
import Service.FormService;
import Service.FormServiceimpl;
import page.PageBean;
import page.PageBeanform;

public class Updateuserform {
	private String status;
	private String id;
	private String bookid;
	private int page;
	private String r_status;
	private String count;
	private String bcid;
	//private ApplicationContext aContext=new ClassPathXmlApplicationContext("/action/applicationContext.xml");
	private FormService formService;
	private BookService bookService;
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public String getBcid() {
		return bcid;
	}

	public void setBcid(String bcid) {
		this.bcid = bcid;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getR_status() {
		return r_status;
	}

	public void setR_status(String r_status) {
		this.r_status = r_status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public FormService getFormService() {
		return formService;
	}

	public void setFormService(FormService formService) {
		this.formService = formService;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	//更新用户的订单审核状态
	public String updateusercstatus(){
		ValueStack valueStack=ActionContext.getContext().getValueStack();
		Form form=(Form) valueStack.findValue("#session.updateselectform");
		formService.updateselectform(form, this.status);
		return "success";		
	}

	//显示所有的发票信息
	public String showallrecepts(){
		ValueStack vStack=ActionContext.getContext().getValueStack();		
		PageBeanform pageBeanform=formService.getallrecepts(page);               
		List<Form> forms=pageBeanform.getList();
		vStack.setValue("#session.alluserrecepts", forms);
		HttpServletRequest request = ServletActionContext.getRequest();        
        request.setAttribute("pageBeanform", pageBeanform);
		return "success";		
	}
	
	//显示选择发票的信息
	public String showselectreceptinfo(){
		int fid=Integer.parseInt(id);
		Form form=formService.getselectform(fid);
		ValueStack vStack=ActionContext.getContext().getValueStack();
		vStack.setValue("#session.userselectrecept", form);
		return "success";		
	}
	
	//更新订单的发票状态
	public String updateuserrstatus(){
		ValueStack vStack=ActionContext.getContext().getValueStack();
		Form form=(Form) vStack.findValue("#session.userselectrecept");
		Recept recept=form.getRecept();
		formService.updateselectrecept(recept, r_status);
		return "success";		
	}
	
	//显示所有的领书单的信息
	public String showalllingforms(){
		ValueStack vStack=ActionContext.getContext().getValueStack();		
		PageBeanform pageBeanform=formService.getallrecepts(page);               
		List<Form> forms=pageBeanform.getList();
		vStack.setValue("#session.alllingforms", forms);
		HttpServletRequest request = ServletActionContext.getRequest();        
        request.setAttribute("pageBeanform", pageBeanform);
		return "success";
	}
	
	//购入图书
	public String addbooks(){
		
		PageBean pageBean=bookService.getBooks(this.page);
		List<Book> books=pageBean.getList();
		ValueStack vStack=ActionContext.getContext().getValueStack();
		vStack.setValue("#session.addbooks", books);
		HttpServletRequest request = ServletActionContext.getRequest();        
        request.setAttribute("pageBean", pageBean);
		return "success";		
	}
	
	//显示选顶的图书的信息。
	public String showselectedbook(){
		int bid=Integer.parseInt(bookid)-1;
		int count=bid%7;
		ValueStack vStack=ActionContext.getContext().getValueStack();
		List<Book> books=(List<Book>) vStack.findValue("#session.addbooks");
		Book book=books.get(count);
		vStack.setValue("#session.addselectbook", book);
		return "success";		
	}
	
	//更新书籍的数量
	public String updatebookcount(){
		ValueStack vStack=ActionContext.getContext().getValueStack();
		Book book=(Book) vStack.findValue("#session.addselectbook");
		formService.addbookcount(book,Integer.parseInt(count));
		return "success";		
	}
	
	//显示图书的图表
	public String showecharts(){
		
		PageBean pageBean=bookService.getBooks(this.page);
		List<Book> books=pageBean.getList();
		ValueStack vStack=ActionContext.getContext().getValueStack();
		vStack.setValue("#session.charbooks", books);
		HttpServletRequest request = ServletActionContext.getRequest();        
        request.setAttribute("pageBean", pageBean);
		return "success";		
	}
	
	//显示选定的图书信息
	public String showselectechart(){
		int id=Integer.parseInt(bcid);
		ValueStack vStack=ActionContext.getContext().getValueStack();
		List<Book> books=(List<Book>) vStack.findValue("#session.charbooks");
		Book book=books.get(id);
		vStack.setValue("#session.addselectbook", book);
		return "success";
	}
}
