package action;

import java.sql.ResultSet;
import java.sql.SQLException;

import mysqlcon.SqlCon;

public class addabook {
	private String isbn;
	private String title;
	private String name;
	private String publisher;
	private String publishdate;
	private double price;
	
	public void setIsbn(String isbn){
		this.isbn=new String(isbn);
	}
	public String getIsbn(){
		return isbn;
	}
	
	public void setTitle(String title){
		this.title = new String(title);
	}
	public String getTitle(){
		return title;
	}
	
	public void setName(String name){
		this.name = new String(name);
	}
	public String getName(){
		return name;
	}
	
	public void setPublisher(String publisher){
		this.publisher=publisher;
	}
	public String getPublisher(){
		return publisher;
	}
	public void setPublishdate(String publishdate){
		this.publishdate=publishdate;
	}
	public String getPublishdate(){
		return publishdate;
	}
	public void setPrice(double price)
	{
		this.price=price;
	}
	public double getPrice()
	{
		return price;
	}
	
	public String execute()throws SQLException{
		SqlCon mycon =new SqlCon();
		String sql0="Select * from Author where Name='"+name+"';";
		ResultSet res=mycon.executeQuery(sql0);
		String ID = null;
		boolean exi=false;
		while(res.next())
		{
			if(name.equals(res.getString("Name")))
			{
				ID=res.getString("AuthorID");
				exi=true;
				break;
			}
		}
		String sql = "INSERT INTO Book(ISBN,Title,AuthorID,Publisher,PublishDate,Price)"+"VALUES("
		+"'"+isbn+"','"+title+"','"+ID+"','"+publisher+"','"+publishdate+"','"+price+"');";
		//System.out.println(sql);
		if(exi==true) {
			int count = mycon.executeUpdate(sql);
		//System.out.println("Insert Successful.DataNum:"+count);
			if(count==0)
				return "Success";
			else
				return "Failed";
			}
		else
			return "Failed";
	}
}
