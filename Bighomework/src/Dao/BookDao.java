package Dao;

import java.util.List;

import Entity.Book;
import Entity.Form;
import Entity.Student;

public interface BookDao {
	public int getallbookrows();//返回数据总数
	public List<Book> getBooks(int offset);//获取所有书，返回List集合
	public void buyBook(Book book,Student s,int count);//购买图书
	public int getallkeybooks(String keywords);//模糊查询，获取所有的关键词
	public List<Book> getkeybooks(String keywords,int offset);//模糊查询，获取关键字图书
	
	public Book getselectbook(int id);//获取指定id的Book

	public void addnewbook(Book book);//插入新书籍
	
	
}
