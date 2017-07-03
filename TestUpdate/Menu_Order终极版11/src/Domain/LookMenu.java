package Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Dao.Main;


public class LookMenu {

	Connection connection;
	Statement statement;
	PreparedStatement ps;
	Main ma = new Main();
	public void  name(int ID,int dishId) throws SQLException {
		connection = ma.getConn();
		
		String sql = "update menu set stat=1 where chief=? and id=?";
		ps=connection.prepareStatement(sql);
		ps.setInt(1, ID);
		ps.setInt(2, dishId);
		System.out.println(ps);
		ps.executeUpdate();
		connection.close();
	}
}

