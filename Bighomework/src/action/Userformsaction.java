package action;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import Entity.Form;
import Service.BookService;
import Service.BookServiceimpl;
import Service.FormService;
import Service.FormServiceimpl;
import page.PageBeanform;

public class Userformsaction {
	private int page;
	private String id;
	private ApplicationContext aContext=new ClassPathXmlApplicationContext("/action/applicationContext.xml");
	private FormService formService=(FormService)aContext.getBean("updateuserform");
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


		//获取指定用户的所有的订单数据
		public String searchuserforms(){
			ValueStack vStack=ActionContext.getContext().getValueStack();
			int sid=(int) vStack.findValue("#session.student.id");
			
			PageBeanform pageBeanform=formService.getuserforms(sid, page);                  
			List<Form> forms=pageBeanform.getList();
			vStack.setValue("#session.userforms", forms);
			HttpServletRequest request = ServletActionContext.getRequest();        
	        request.setAttribute("pageBeanform", pageBeanform);
			return "success";
		}
		
		//显示用户选择的订单信息
		public String getselectform(){
			int id=Integer.parseInt(this.id)-1;
			ValueStack vStack=ActionContext.getContext().getValueStack();
			List<Form> forms=(List<Form>) vStack.findValue("#session.userforms");
			int num=id%7;
			Form form=forms.get(num);
			vStack.setValue("#session.userselectform", form);
			return "success";
			
		}
		
		//更新用户的领取状态
		public String updatelstatus(){
			ValueStack vStack=ActionContext.getContext().getValueStack();
			Form form=(Form) vStack.findValue("#session.userselectform");
			int formnumber=form.getId();
			
			formService.updateuserselect(formnumber);			
			return "success";
			
		}
}
