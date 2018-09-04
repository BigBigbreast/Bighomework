package Dao;

import java.util.List;

import Entity.Book;
import Entity.Form;
import Entity.Recept;

public interface FormDao {
	public List<Form> userforms(int sid,int offset);//联合迫切内连接查询，查询用户订单
	public int getuserforms(int sid);//获取用户的所有订单的数量
	//更新用户的订单的领取状态
	public void updateuserform(int fid);
	
	//获取所有的订单
	public List<Form> getalluserforms(int offset);
	//获取所有的订单数量
	public int getalluserformscount();
	
	//获取所有未审核订单
	public List<Form> gettotaluserforms(int offset);
	//获取所有的订单数量
	public int gettotaluserformscount();
	
	//获取指定学生的订单
	public List<Form> getsnumberForms(String snumber,int offset);
	//获取指定学生的订单数量
	public int getsnumberformscount(String snumber);
	
	//获取订单
	public Form getselectform(int fid);
	
	//更新订单审核状态
	public void updateselectform(Form form,String status);
	
	//获取所有的发票
	public List<Form> getallrecepts(int offset);
	//获取所有的发票数量
	public int getallreceptscount();
	
	//更新选择的发票的状态
	public void updateselectrecept(Recept recept,String status);
	
	//增加图书数量
	public void addbookcount(Book book,int count );
	
}
