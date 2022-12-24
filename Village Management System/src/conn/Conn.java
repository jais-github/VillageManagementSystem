package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
	Connection c;
	public Statement s;
  public Conn() {
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	      c= DriverManager.getConnection("jdbc:mysql://localhost:3306/village_management_system","root","MySQL@123");
	      s=c.createStatement();  
	    }catch(Exception e) {
	    	
	    }
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
