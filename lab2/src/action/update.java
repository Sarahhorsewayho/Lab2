package action;

import java.sql.ResultSet;
import java.sql.SQLException;

import mysqlcon.SqlCon;

public class update {
	private String name;
	private String publisher;
	private String publishdate;
	private double price;
	private String id = action.trans.transid();
	public void setName(String name){
		this.name=new String(name);
	}
	public String getName(){
		return name;
	}
	
	public void setPublisher(String publisher){
		this.publisher = new String(publisher);
	}
	public String getPulisher(){
		return publisher;
	}
	
	public void setPublishdate(String publishdate){
		this.publishdate = new String(publishdate);
	}
	public String getPublishdate(){
		return publishdate;
	}
	
	public void setPrice(double price){
		this.price=price;
	}
	public double getPrice(){
		return price;
	}
	
	
	
	public String execute()throws SQLException{
		SqlCon mycon =new SqlCon();
		String sql1="update Book set Publisher='"+publisher+"',PublishDate='"+publishdate+"',Price='"+price+"' where Title='"+id+"'";
		//System.out.println(sql1);
		int count = mycon.executeUpdate(sql1);
		//System.out.println("Insert Successful.DataNum:"+count);
		String sql2="select * from Book";
		String IDtemp = null;
		ResultSet res = mycon.executeQuery(sql2);
		while(res.next()){
			if(id.equals(res.getString("Title"))){
				IDtemp=new String(res.getString("AuthorID"));
				break;
			}
		}
		String sql3="update Author set Name='"+name+"' where AuthorID='"+IDtemp+"'";
		int count2 = mycon.executeUpdate(sql3);
		//System.out.println("Update Successful.DataNum is:"+(count+count2));
		return "Success";
	}
}
