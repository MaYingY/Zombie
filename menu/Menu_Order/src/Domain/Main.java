package Domain;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
	public static void main(String[] args) {
		getConn();
	}
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/menu","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
