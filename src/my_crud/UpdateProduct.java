package my_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateProduct {

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
	con.prepareStatement("update product set pname = ?, price = ? where pid = ?");
			
			//step4
			Scanner s = new Scanner(System.in);
			int x=0,pid=0;
			String pname="";
			double price=0;
				System.out.println("Enter Product Id :");
				pid = s.nextInt();
				System.out.println("Enter Product Name : ");
				pname = s.next();
				System.out.println("Enter Price :");
				price = s.nextDouble();
				
				
				ps.setString(2, pname);
				ps.setDouble(3, price);
				ps.setInt(1, pid);
				x = x+ ps.executeUpdate();
			
			System.out.println(x+" record updated successfully");
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

