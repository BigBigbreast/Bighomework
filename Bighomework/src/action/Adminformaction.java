package action;

import java.util.List;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import Entity.Form;
import Service.FormService;
import Service.FormServiceimpl;
import page.PageBeanform;

public class Adminformaction {
	//private ApplicationContext aContext=new ClassPathXmlApplicationContext("/action/applicationContext.xml");
	private FormService formService;
	private int page;
	private String id;
	private String snumber;
	
	public FormService getFormService() {
		return formService;
	}
	public void setFormService(FormService formService) {
		this.formService = formService;
	}
	public String getSnumber() {
		return snumber;
	}
	public void setSnumber(String snumber) {
		this.snumber = snumber;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	//显示所有订单
	public String showusercheck(){
		ValueStack vStack=ActionContext.getContext().getValueStack();
		
		PageBeanform pageBeanform=formService.getalluserforms(page);               
		List<Form> forms=pageBeanform.getList();
		vStack.setValue("#session.alluserforms", forms);
		HttpServletRequest request = ServletActionContext.getRequest();        
        request.setAttribute("pageBeanform", pageBeanform);
		return "success";		
	}

	//显示未审核的订单
	public String showuncheckedforms(){
		ValueStack vStack=ActionContext.getContext().getValueStack();		
		PageBeanform pageBeanform=formService.gettotaluserforms(page);               
		List<Form> forms=pageBeanform.getList();
		vStack.setValue("#session.totaluserforms", forms);
		HttpServletRequest request = ServletActionContext.getRequest();        
        request.setAttribute("pageBeanform", pageBeanform);
		return "success";				
	}
	
	//显示指定用户的订单
	public String showsnumberforms(){
		ValueStack vStack=ActionContext.getContext().getValueStack();		
		PageBeanform pageBeanform=formService.getsnumberuserforms(this.snumber, this.page);               
		List<Form> forms=pageBeanform.getList();		
		vStack.setValue("#session.snumberuserforms", forms);
		HttpServletRequest request = ServletActionContext.getRequest();        
        request.setAttribute("pageBeanform", pageBeanform);
		return "success";
	}
	
	//获取选定的订单
	public String shouforminfo(){
		int fid=Integer.parseInt(this.id);
		Form form=formService.getselectform(fid);
		ValueStack vStack=ActionContext.getContext().getValueStack();
		vStack.setValue("#session.updateselectform", form);
		return "success";
		
	}
}
