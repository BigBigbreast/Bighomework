package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Db_book")
public class Book {
	@Id
	@GenericGenerator(name="dept",strategy="increment")
	@GeneratedValue(generator="dept")
	private int id;
	
	private String bookname;
	private double bookprice;
	private int bookcount;
	private String bookwriter;
	private String bookplace;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getBookprice() {
		return bookprice;
	}
	public void setBookprice(double bookprice) {
		this.bookprice = bookprice;
	}
	public int getBookcount() {
		return bookcount;
	}
	public void setBookcount(int bookcount) {
		this.bookcount = bookcount;
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
	
	

}
