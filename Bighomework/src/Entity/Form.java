package Entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Db_form")
public class Form {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String l_status;
	private String c_status;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="r_id")
	@Cascade(CascadeType.ALL)
	private Recept recept;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="s_id")
	@Cascade(CascadeType.ALL)
	private Student student;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="b_id")
	@Cascade(CascadeType.ALL)
	private Book book;
	
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getL_status() {
		return l_status;
	}
	public void setL_status(String l_status) {
		this.l_status = l_status;
	}
	public String getC_status() {
		return c_status;
	}
	public void setC_status(String c_status) {
		this.c_status = c_status;
	}
	public Recept getRecept() {
		return recept;
	}
	public void setRecept(Recept recept) {
		this.recept = recept;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	

}
