package action;

import java.sql.*;
import java.util.*;

import mysqlcon.SqlCon;

public class check {
	Connection con;
	Statement st;

	private String authorname;
	private ArrayList<String> BookList = new ArrayList<String>();
	
	public String getAuthorname(){
		return authorname;
	}
	
	public void setAuthorname(String authorname){
		this.authorname = authorname;
	}
	
	public ArrayList<String> getBookList(){
		return BookList;
	}
	public String execute() throws SQLException{
		SqlCon mycon = new SqlCon();
			String sql = "select * from Author";
			ResultSet res = mycon.executeQuery(sql);
			boolean flag = false;
			String theAuthorID = null;
			while(res.next()){
				if(authorname.equals(res.getString("Name"))){
					theAuthorID=new String(res.getString("AuthorID"));
					flag = true;
					break;
				}
			}
		if(flag){
			String sq2 = "select * from Book";
			res = mycon.executeQuery(sq2);
			while(res.next())
				if(theAuthorID.equals(res.getString("AuthorID")))
					BookList.add(new String(res.getString("Title")));
				return "Success";
			} 
		else{ 
			return "Failed";
		}
	}
}



