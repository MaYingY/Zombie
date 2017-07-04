package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChiefOperate {
	
	static Main newMain = new Main();
    static Connection con = newMain.getConn();
    //获得酒的id
    public static int WineID() {
		int sid = 0;
		try {
			
			Connection connection = newMain.getConn();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("SELECT * FROM dishes");
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				if (id > sid) {
					sid = id;
				}
			}
		} catch (Exception e) {
			System.out.println("HHH");
		}
		return sid;
	}
	//添加酒品
	public int addWine(String name, double price, int type) throws SQLException {
		// TODO Auto-generated method stub
		int id = WineID();
		String sql = "insert into wine(id, name, price, type) values(?,?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setDouble(3, price);
		preparedStatement.setInt(4, type);
		preparedStatement.executeUpdate();
		return id;
	}
	//删除酒品
	public void deleteWine(String name) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from wine where name=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.executeUpdate();
	}
	//修改信息
	public void modMenu(int id, String name, double price, int type) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update wine set name=?,price=?,type=? where id=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setDouble(2, price);
		preparedStatement.setInt(3, type);
		preparedStatement.setInt(4, id);
		preparedStatement.executeUpdate();
	}
	//修改信息
	public void modInfo(String name, String passwd) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "update chief set passwd=? where name=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, passwd);
		preparedStatement.executeUpdate();
	}
}
