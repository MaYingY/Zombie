package Domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class ManageOperate extends JFrame {
	
	static Main newMain = new Main();
    static Connection con = newMain.getConn();
	//登录检测用户名
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
	//检测用户名和密码
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
	//菜品添加
	public static void addMenu(int id, String name, double price, int chief) throws SQLException {
		String sql = "insert into dishes(id, name, price, chief) values(?,?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setDouble(3, price);
		preparedStatement.setInt(4, chief);
		preparedStatement.executeUpdate();
	}
	//修改菜品
	public static void modMenu(int id, String name, double price, int chief) throws SQLException {
		String sql = "update dishes set name=?,price=?,chief=? where id=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setDouble(2, price);
		preparedStatement.setInt(3, chief);		
		preparedStatement.setInt(4, id);
		preparedStatement.executeUpdate();
	}
	//删除菜品
	public void deleteMenu(String name) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from dishes where name=?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.executeUpdate();
	}
	//菜单查询
	public static void searchDishes() throws SQLException {
		JTextArea allDishes;
		JFrame frame;
		frame = new JFrame();
		frame.setBounds(300, 300, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel id = new JLabel("编号");
		id.setBounds(10, 10, 150, 50);
		frame.getContentPane().add(id);
		
		JLabel name = new JLabel("名称");
		name.setBounds(197, 10, 150, 50);
		frame.getContentPane().add(name);
		
		JLabel price = new JLabel("价格");
		price.setBounds(270, 10, 150, 50);
		frame.getContentPane().add(price);
		
		JLabel chief = new JLabel("主厨编号");
		chief.setBounds(324, 10, 150, 50);
		frame.getContentPane().add(chief);
		
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery("select * from dishes");
		List<Dishes> list = new ArrayList<Dishes>();
		while(rs.next()) {
			Dishes dishes = new Dishes();
			dishes.setId(rs.getInt("id"));
			dishes.setName(rs.getString("name"));
			dishes.setPrice(rs.getDouble("price"));
			dishes.setChief(rs.getInt("chief"));
			list.add(dishes);
		}
		allDishes = new JTextArea();
		allDishes.setBounds(50, 90, 550, 400);
		allDishes.setEditable(false);
//		frame.getContentPane().add(passwd);
		frame.add(allDishes);

		for(int i = 0; i < list.size(); i ++) {
			Dishes dishes = list.get(i);
			allDishes.append(dishes.id+"\t"+dishes.name+"\t"+dishes.price+"\t"+dishes.chief+"\n");
		}
		frame.setVisible(true);
	}
	//添加酒品
	public static void addWine(int id, String name, double price) throws SQLException {
		String sql = "insert into wine(id, name, price) values(?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setDouble(3, price);
		preparedStatement.executeUpdate();
	}
	//查询厨师
	public static void searchChief() throws SQLException {
		JTextArea allChief;
		JFrame frame;
		frame = new JFrame();
		frame.setBounds(300, 300, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel id = new JLabel("\u7F16\u53F7");
		id.setBounds(10, 10, 200, 50);
		frame.getContentPane().add(id);
		
		JLabel name = new JLabel("\u59D3\u540D");
		name.setBounds(197, 10, 200, 50);
		frame.getContentPane().add(name);
		
		JLabel passwd = new JLabel("\u5BC6\u7801");
		passwd.setBounds(324, 10, 200, 50);
		frame.getContentPane().add(passwd);
		
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery("select * from chief");
		List<Chief> list = new ArrayList<Chief>();
		while(rs.next()) {
			Chief chief = new Chief();
			chief.setId(rs.getString("id"));
			chief.setName(rs.getString("name"));
			chief.setPasswd(rs.getString("passwd"));
			list.add(chief);
		}
		allChief = new JTextArea();
		allChief.setBounds(50, 90, 550, 400);
		allChief.setEditable(false);
		frame.getContentPane().add(passwd);
		frame.add(allChief);

		for(int i = 0; i < list.size(); i ++) {
			Chief chief = list.get(i);
			allChief.append(chief.id+"\t"+chief.name+"\t"+chief.passwd+"\n");
		}
		frame.setVisible(true);
	}
}
	
