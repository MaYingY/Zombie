package Domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import WindowsAll.manageOperate;

public class ManageOperate {
	
	static Main newMain = new Main();
    static Connection con = newMain.getConn();
	
	public static int Login(String username) throws SQLException {
		
		String sql = "select * from manager where username=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, username);
		ResultSet rs = preparedStatement.executeQuery();
		int flag = 0;
		if(! rs.next()) {  
			flag = 1;
		} 
		return flag;
	}
	
	public static int ifLogin(String username, String password) throws SQLException {
		String sql = "select * from manager where username = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, username);
		ResultSet rs = preparedStatement.executeQuery();
		int flag = 1;
		while( rs.next()) {
			if(rs.getString(2) == password) {
				return 0;
			}
		}
		return flag;
	}
	
}
	
