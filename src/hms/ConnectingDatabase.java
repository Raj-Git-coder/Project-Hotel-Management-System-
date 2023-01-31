package hms;
import java.sql.*;

public class ConnectingDatabase 
{
	Connection connection;
	Statement statement;
	
	public ConnectingDatabase() 
	{
		try
		{		
			
			Class.forName("oracle.jdbc.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","user1","usr");
			statement=connection.createStatement();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
