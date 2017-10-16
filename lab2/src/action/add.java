package action;

import mysqlcon.SqlCon;

public class add {
	private String authorID;
	private String name;
	private String country;
	private int age;
	
	public void setAuthorID(String authorID){
		this.authorID=new String(authorID);
	}
	public String getAuthorID(){
		return authorID;
	}
	
	public void setName(String name){
		this.name = new String(name);
	}
	public String getName(){
		return name;
	}
	
	public void setCountry(String country){
		this.country = new String(country);
	}
	public String getCountry(){
		return country;
	}
	
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}
	
	
	
	public String execute()throws Exception{
		SqlCon mycon =new SqlCon();
		String sql = "INSERT INTO Author(AuthorID,Name,Age,Country)"+"VALUES("+"'"+authorID+"','"+name+"','"+age+"','"+country+"')";
		int count = mycon.executeUpdate(sql);
		//System.out.println("Insert Successful.DataNum:"+count);
		return "Success";
	}
}
