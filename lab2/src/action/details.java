package action;

import java.sql.*;
//import mysqlcon.SqlCon;

public class details {
	private String ISBN;
	private String Title;
	private String AuthorID;
	private String Publisher;
	private String PublishDate;
	private double Price;
	private int Age;
	private String Country;
	private String Name;
	
	private String BookTitle = null;
	public String getBookTitle(){
		return BookTitle;
	}
	public void setBookTitle(String BookTitle){
		this.BookTitle = new String(BookTitle);
	}
	public String getISBN(){
		return ISBN;
	}
	public String getTitle(){
		return Title;
	}
	public String getAuthorID(){
		return AuthorID;
	}
	public String getPublisher(){
		return Publisher;
	}
	public String getPublishDate(){
		return PublishDate;
	}
	public double getPrice(){
		return Price;
	}
	public int getAge() {
		return Age;
	}
	public String getCountry() {
		return Country;
	}
	public String getName() {
		return Name;
	}
	
	Connection con1;
	Connection con2;
	Statement st1;
	Statement st2;
	public static Connection getConnection(){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_harryhe","3kknxkwxmo","h4m5xy5wkymm30k3jk20i5imljw2lkz00zyimhm3");
		}catch(Exception e){
			System.out.println("Connect Fail:"+e.getMessage());
		}
		return con;
	}
	
	public String execute()throws Exception{
		con1 = getConnection();
		con2 = getConnection();
		System.out.println(BookTitle);
		try{
			String sql = "select * from Book";
			st1 = (Statement)con1.createStatement();
			ResultSet res = st1.executeQuery(sql);
			while(res.next()){
				if(BookTitle.equals(res.getString("Title"))){
					ISBN = new String(res.getString("ISBN"));
					Title = new String(res.getString("Title"));
					AuthorID = new String(res.getString("AuthorID"));
					Publisher = new String(res.getString("Publisher"));
					PublishDate = new String(res.getString("PublishDate"));
					Price = res.getDouble("Price");
				}
			}
			con1.close();
			String sqm = "select * from Author";
			st2 = (Statement)con2.createStatement();
			ResultSet rs = st2.executeQuery(sqm);
			while(rs.next()) {
				if(AuthorID.equals(rs.getString("AuthorID"))) {
					Name = new String(rs.getString("Name"));
					Age = rs.getInt("Age");
					Country = new String(rs.getString("Country"));
				}
			}
			con2.close();
			return "Success";
		}catch(SQLException e){
			System.out.println("Connect Failed."+e.getMessage());
			return "Failed";
		}
	}
}
