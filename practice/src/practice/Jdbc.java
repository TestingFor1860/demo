package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
// Hello ji
public class Jdbc {
	public static void main(String args[]) throws SQLException 
	{
		try {
			// loading driver class
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//create connection object
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","aman1860");
			if(!con.isClosed())
				System.out.println("connection running ");
			Statement stmt=con.createStatement();
			   
				//int result= stmt.executeUpdate("delete from studentinfo where rollno=1860");
			 ResultSet select = stmt.executeQuery("select * from studentinfo");
			 select.next();
				System.out.println(select.getInt(1)+" "+select.getString(2));
				 select.next();
					System.out.println(select.getInt(1));

			
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}  
	}
		
		
	
}
