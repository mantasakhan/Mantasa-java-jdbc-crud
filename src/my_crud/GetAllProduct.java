package my_crud;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GetAllProduct {

	public static void main(String[] args) {
		
		try {  //step1
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (Exception e) 
		{
			System.out.println("Error in loading drivers");
		}
		
		try 
		{
			//step 2
			Connection con = 
					DriverManager.getConnection
	("jdbc:mysql://localhost:3306/17dec25ad?user=root&password=ROOT");
			//step3
			PreparedStatement ps = 
	con.prepareStatement("select * from product");
			
			//step4
				ResultSet rs  =  ps.executeQuery();
			
				while(rs.next()==true)
				{
					System.out.println("Product Id = "+rs.getInt("pid"));
					System.out.println("Product Name = "+rs.getString("pname"));
					System.out.println("Product Price = "+rs.getDouble("price"));
				}
				
			//step5
			con.close();
			ps.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Error in sql statement:"+e);
		}
	}

}
