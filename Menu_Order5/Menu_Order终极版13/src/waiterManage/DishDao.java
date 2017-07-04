package waiterManage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Dao.Main;
import Domain.Dish;


public class DishDao {
	Connection connection = null;
	Statement statement;
	ResultSet resultSet;
	Main ma = new Main();
	public Dish search(int sid) {
		Dish dish = new Dish();
		try {
			connection = ma.getConn();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM dishes");
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				if (id == sid) {
					dish.id = id;
					dish.name = resultSet.getString(2);
					dish.price = resultSet.getDouble(3);
					dish.chief = resultSet.getInt(4);
				}
			}
		} catch (Exception e) {
			System.out.println("HHH");
		}
		return dish;

	}

	public int searchAll() {
		int i = 0;
		try {
			connection = ma.getConn();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM dishes");
			while (resultSet.next()) {
				i++;
				System.out.println("**");
			}
		} catch (Exception e) {
			System.out.println("HHH");

		}
		return i;

	}
}
