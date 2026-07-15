
package my_crud;
import java.sql.*;
import java.util.Scanner;


public class AddProduct {

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
			con.prepareStatement("insert into product values(?,?,?)");
			
			//step4
			Scanner s = new Scanner(System.in);
			int x=0,pid=0;
			String pname="";
			double price=0;
			for(int i=1; i<=3; i++)
			{
				System.out.println("Enter Product Id :");
				pid = s.nextInt();
				System.out.println("Enter Product Name: ");
				pname = s.next();
				System.out.println("Enter Price :");
				price = s.nextDouble();
				
				ps.setInt(1, pid);
				ps.setString(2, pname);
				ps.setDouble(3, price);
				x = x+ ps.executeUpdate();
			}
			System.out.println(x+" record inserted successfully");
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
