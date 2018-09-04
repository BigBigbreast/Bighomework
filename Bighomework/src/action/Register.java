package action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import Entity.Student;
import Service.RegisterService;
import Service.RegisterServiceimpl;
import Service.StudentService;
import Service.StudentServiceimpl;

public class Register extends ActionSupport{
	/**
	 * 
	 */
	private ApplicationContext aContext=new ClassPathXmlApplicationContext("/action/applicationContext.xml");
	private static final long serialVersionUID = 1L;
	private String snumber;
	private String spas;
	private String spas1;
	private String sname;
	public String getSnumber() {
		return snumber;
	}
	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	public String getSpas() {
		return spas;
	}
	public void setSpas(String spas) {
		this.spas = spas;
	}
	public String getSpas1() {
		return spas1;
	}
	public void setSpas1(String spas1) {
		this.spas1 = spas1;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public String doregister(){
		RegisterService registerService=(RegisterService)aContext.getBean("register2");
		Student student=new Student();
		student.setSname(sname);
		student.setSnumber(snumber);
		student.setSpass(spas);
		registerService.register(student);
		ValueStack valueStack=ActionContext.getContext().getValueStack();
		valueStack.setValue("#session.student",student);
		return "success";	
	}

	public void validateDoregister(){
		ValueStack valueStack=ActionContext.getContext().getValueStack();
		StudentService studentService=(StudentService)aContext.getBean("register");
		List<Student> students=studentService.getStudents();
		for (Student student : students) {
			if (this.snumber.equals(student.getSnumber())){
				this.addFieldError("snumber", "该学号已被注册");
				break;
			}
		}
		if(!this.spas.equals(spas1)){
			this.addFieldError("spass", "两次输入的密码不一致，请重新输入");
		}
		
	}
	
}
