package Intercepter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class studentIntercepter implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		ValueStack valueStack=ActionContext.getContext().getValueStack();
		String snumber=(String) valueStack.findValue("#session.student.snumber");
		if(!(snumber.equals("admin")||snumber.equals("root"))){
			arg0.invoke();
		}		
		return "sorry";
		
	}

}
