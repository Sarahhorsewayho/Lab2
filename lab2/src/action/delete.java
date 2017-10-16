package action;

import java.sql.SQLException;

import mysqlcon.SqlCon;

public class delete {
	private String id=null;

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	
	public String execute()throws SQLException{
		SqlCon mycon= new SqlCon();
		//String id=ServletActionContext.getRequest().getParameter("id");
		//System.out.println(id);
		String sql = "delete from Book where Title="+"'"+id+"'";
		//System.out.println(sql);
		int count = mycon.executeUpdate(sql);
		//System.out.println("Delete Successful.Delete DataNum:"+count);
		return "Success";
	}
}