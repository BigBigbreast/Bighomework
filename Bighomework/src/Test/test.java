package Test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;

import Dao.BookDao;
import Dao.BookDaoimpl;
import Dao.Register;
import Dao.Registerimpl;
import Entity.Book;
import Entity.Form;
import Entity.HibernateUtil;
import Entity.Recept;
import Entity.Student;
import Service.BookService;
import Service.BookServiceimpl;
import Service.FormService;
import Service.FormServiceimpl;
import Service.RegisterService;
import Service.RegisterServiceimpl;
import Service.StudentService;
import Service.StudentServiceimpl;
import oracle.net.aso.q;

public class test {
	@Test
	public void test01(){
		Session session=HibernateUtil.getCurrSession();
		Transaction tx=session.beginTransaction();
		
		Student student=(Student) session.get(Student.class, 1);
		Book book=(Book) session.get(Book.class, 1);
		Recept recept=(Recept) session.get(Recept.class, 1);
		Form form=new Form();
		form.setBook(book);
		form.setC_status("已审核");
		form.setL_status("已领取");
		form.setRecept(recept);
		form.setStudent(student);
		session.save(form);
		tx.commit();
	}
//	@Test
//	public void test02(){
//		BookService bookService=new BookServiceimpl();
//		List<Book> books=bookService.getBooks();
//		for (Book book : books) {
//			System.out.println(book.getBookname());
//		}
//	}

	@Test
	public void test03(){//测试获取所有学生信息
		StudentService bookService=new StudentServiceimpl();
		List<Student> books=bookService.getStudents();
		for (Student book : books) {
			System.out.println(book.getSname());
		}
	}
	
//	@Test
//	public void test04(){//测试图书购买
//		BookService bookService=new BookServiceimpl();
//		Session session=HibernateUtil.getCurrSession();
//		Transaction tx=session.beginTransaction();
//		Student student=(Student) session.get(Student.class, 1);
//		Book book=(Book) session.get(Book.class, 1);
//		tx.commit();
//		bookService.buybook(book, student, 1);
//	}
	
//	@Test
//	public void test05(){//测试图书查询
//		BookService bookService=new BookServiceimpl();
//		List<Book> books=bookService.getkeyBooks("计算机");
//		for (Book book : books) {
//			System.out.println(book.getBookname());
//		}
//	}
	
	@Test
	public void tet07(){//测试图书查询
		Session session=HibernateUtil.getCurrSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("from Form f inner join fetch f.student inner join fetch f.recept inner join fetch f.book where f.student.id=?");
		query.setInteger(0, 1);
		List<Form> forms=query.list();
     	tx.commit();
		for (Form form : forms) {
			System.out.println(form.getId()+" "+form.getStudent().getSname()+" "+form.getRecept().getStatus()+" "+form.getBook().getBookname());
		}		
	}
	
//	@Test
//	public void tet08(){//测试图书查询
//		BookService bookService =new BookServiceimpl();
//		List<Form> forms=bookService.getuserforms(1);
//		for (Form form : forms) {
//			System.out.println(form.getId()+" "+form.getStudent().getSname()+" "+form.getRecept().getStatus()+" "+form.getBook().getBookname());
//		}
//	
//	}
	
	@Test
	public void tet09(){//测试图书查询
		Student student=new Student();
		student.setSname("sdfa");
		student.setSnumber("sdfasdf");
		student.setSpass("sdf");
		Register register=new Registerimpl();
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		register.register(student);
		tx.commit();
	
	}
	
	@Test
	public void tet11(){//测试图书查询
		Transaction tx=HibernateUtil.getCurrSession().beginTransaction();
		Session session= HibernateUtil.getCurrSession();
		Recept recept=new Recept();
		recept.setBeginname("郑州大学");
		recept.setStatus("待开");
		Book book=(Book)session.get(Book.class, 2);
		tx.commit();
		System.out.println(book.getBookname());
		
		Transaction tx2=HibernateUtil.getCurrSession().beginTransaction();
		Session session2=HibernateUtil.getCurrSession();
		Book book1=(Book) session2.get(Book.class, book.getId());
		Student s=(Student) session2.get(Student.class, 1);
		Form form=new Form();
		form.setBook(book1);
		form.setCount(2);
		form.setStudent(s);
		form.setRecept(recept);
		form.setC_status("待审核");
		form.setL_status("待领取");
		book1.setBookcount(book1.getBookcount()-2);
		session2.save(form);
		session2.update(book1);
		tx2.commit();
	}
	
	@Test
	public void tet12(){//测试图书查询
		Session session=HibernateUtil.getCurrSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery("from Form");
		
		List<Form> forms=query.list();
     	tx.commit();
		for (Form form : forms) {
			System.out.println(form.getId()+" "+form.getStudent().getSname()+" "+form.getRecept().getStatus()+" "+form.getBook().getBookname());
		}		
	}
	
	@Test
	public void tet13(){//测试图书查询
		FormService for1=new FormServiceimpl();
		List<Form> forms=for1.gettotaluserforms(1).getList();
		for (Form form : forms) {
			System.out.println(form.getId()+" "+form.getStudent().getSname()+" "+form.getC_status()+" "+form.getBook().getBookname());
		}		
	}
	
	@Test
	public void tet14(){//测试图书查询
		FormService for1=new FormServiceimpl();
		List<Form> forms=for1.getsnumberuserforms("201677I1250", 1).getList();
		for (Form form : forms) {
			System.out.println(form.getId()+" "+form.getStudent().getSname()+" "+form.getC_status()+" "+form.getBook().getBookname());
		}		
	}
}



