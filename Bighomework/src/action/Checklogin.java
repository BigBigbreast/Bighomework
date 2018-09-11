package action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import Entity.Student;
import Service.StudentService;
import Service.StudentServiceimpl;

public class Checklogin {
	private String username;
	private String userpass;
	private StudentService studentService;
	
	public StudentService getStudentService() {
		return studentService;
	}
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	
	public String checklogin(){
		ValueStack valueStack=ActionContext.getContext().getValueStack();
		//ApplicationContext aContext=new ClassPathXmlApplicationContext("/action/applicationContext.xml");
		//StudentService studentService=(StudentService)aContext.getBean("register");
		List<Student> students=studentService.getStudents();
		for (Student student : students) {
			if (username.equals(student.getSnumber())&&userpass.equals(student.getSpass())){
				valueStack.setValue("#session.student",student);
				return "success";
			}
		}
		valueStack.setValue("#session.flag",1);
		return "input";
		
	}
	

}
