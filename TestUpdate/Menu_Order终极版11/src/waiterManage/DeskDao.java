package waiterManage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Dao.Main;


public class DeskDao {
	Connection connection=null;
	ResultSet resultSet = null;
	Statement statement = null;
	Main ma = new Main();
	public boolean search(int sid) {
		boolean flag= false;
		try {
			connection = ma.getConn();
			statement=connection.createStatement();
			//System.out.println("__");
			resultSet = statement.executeQuery("SELECT * FROM desk");
			while(resultSet.next()){
				//System.out.println("***");
				int id=resultSet.getInt(1);
				if(id==sid){
				int t=resultSet.getInt(2);
				if(t==0)
					flag = true;
				else {
					flag = false;
				}
				}
			}
		} catch (Exception e) {
			System.out.println("HHH");
		}
		return flag;
		
	}
	public void change(int sid,int i) {
		try {
			connection = ma.getConn();
			statement=connection.createStatement();
			statement.execute("update desk set stat ="+i+" where id = "+sid);
			
			connection.close();
		} catch (Exception e) {
			System.out.println("HHH");
		}
	}

}
