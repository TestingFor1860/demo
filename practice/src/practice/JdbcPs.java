package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcPs {
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
			
			// Prepared statement
			// insert Command
		/*	PreparedStatement ps = con.prepareStatement("insert into studentinfo values(?,?)");
			ps.setInt(1, 13);
			ps.setString(2, "s3");*/
			
		// delete command
			
		PreparedStatement ps =con.prepareStatement("delete from studentinfo where rollno=?");
		
			ps.executeUpdate();
			
			// select command
			PreparedStatement sel = con.prepareStatement("select * from studentinfo");
			ResultSet res=sel.executeQuery();
			while(res.next())
			{
				System.out.println(res.getInt(1)+ " "+res.getString(2));
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}  
	}
		
		
	
}
