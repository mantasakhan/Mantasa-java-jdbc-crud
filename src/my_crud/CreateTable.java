package my_crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

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
			Statement stmt = con.createStatement();
			
			//step4
			stmt.executeUpdate
			("create table employee(eid int primary key,"
					+ "ename varchar(20),salary numeric(10,2))");
			
			System.out.println("Table Created Successfully");
			//step5
			con.close();
			stmt.close();
		}
		catch (SQLException e) 
		{
			System.out.println("Error in sql statement:"+e);
		}

	}

}
