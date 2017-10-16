package action;


import mysqlcon.SqlCon;

public class trans {
	private static String id=null;

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	static String transid()
	{
		return id;
	}
	public String execute(){
		System.out.println(id);
		return "Success";
	}
}
