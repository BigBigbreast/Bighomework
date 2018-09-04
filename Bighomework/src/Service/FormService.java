package Service;

import Entity.Book;
import Entity.Form;
import Entity.Recept;
import page.PageBeanform;

public interface FormService {
	public PageBeanform getuserforms(int sid,int page);//查询指定用户的所有订单
	//更新用户订单
	public void updateuserselect(int fid);
	
	public PageBeanform getalluserforms(int page);//获取分页订单
	
	public PageBeanform gettotaluserforms(int page);//获取未审核分页订单
	
	public PageBeanform getsnumberuserforms(String snumber,int page);//获取未审核分页订单

	public Form getselectform(int fid);//获取查询的订单、
	
	public void updateselectform(Form form,String status);//更新订单审核状态

	public PageBeanform getallrecepts(int page);//获取分页发票
	
	public void updateselectrecept(Recept recept,String status);//更新发票的状态

	public void addbookcount(Book book,int count);//增加图书的数量
}

