package Service;

import java.util.List;

import Entity.Book;
import Entity.Form;
import Entity.Student;
import page.PageBean;
import page.PageBeanform;

public interface BookService {
	public PageBean getBooks(int page);//获取所有图书
	public void buybook(Book book,Student s,int count);//购买图书
	public PageBean getkeyBooks(String key,int page);//获取模糊查询结果
	
	public Book getselectBook(int id);//获取指定的Book
	
	public void addnewbook(Book book);//添加新书籍
}
