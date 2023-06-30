package emswebapp;
import java.sql.*;

public class DBconnection {

	public static Connection createConnection(){
		Connection con=null;
		try {
			 con = DriverManager.getConnection("jdbc:mysql://localhost/Employee", "root", "rootroot");
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return con;
	}

}
