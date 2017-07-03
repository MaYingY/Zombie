package ChiefManage;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;

import Dao.Main;
import Domain.LookMenu;

public class lookMenu_Window  {

	private JFrame frame;
	String chiefName;
	int chiefId;
	Main ma = new Main();
	int dishID;
	/**
	 * Create the application.
	 * @param chiefname 
	 * @throws SQLException 
	 */
	public lookMenu_Window(String chiefname) throws SQLException {
		chiefName = chiefname;
		System.out.println("name:"+chiefName);
		initialize(chiefName);
		frame.setVisible(true);
	}

	private void initialize(String chiefName1) throws SQLException {
	
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(67, 35, 280, 172);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(10, 1, 0, 0));

		JLabel lblNewLabel = new JLabel("代做菜单");
		lblNewLabel.setBounds(177, 10, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		int coun = 0;
		//获得厨师的id
		Connection con = ma.getConn();
		String sql = "select id from chief where username=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, chiefName1);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			chiefId = rs.getInt(1);
		}
		System.out.println("厨师id"+chiefId);
		
		Main ma = new Main();
		Connection connection = ma.getConn();
		String sql1 = "select * from menu where chief=?";
		PreparedStatement pst = connection.prepareStatement(sql1);
		pst.setInt(1,chiefId);
		ResultSet resultSet = pst.executeQuery();
		while (resultSet.next()) {
			coun++;
		}
		//resultSet = pst.executeQuery();
		resultSet = pst.executeQuery();
		int i = 0;
		final JRadioButton button[] = new JRadioButton[coun];
		while (resultSet.next()) {
			int stat = resultSet.getInt(5);
			if (stat == 0) {
				button[i] = new JRadioButton(resultSet.getString(2));
				button[i].validate();
				panel.add(button[i]);
				i++;
				
				String sql2 = "select id from menu where name=?";
				PreparedStatement pst1 = connection.prepareStatement(sql2);
				pst1.setString(1,resultSet.getString(2));
//				System.out.println("caiming"+resultSet.getString(2));
				ResultSet resultSet1 = pst1.executeQuery();
				if(resultSet1.next()) {
					dishID = resultSet1.getInt(1);
				}
//				System.out.println(dishID+"~~~~~~~~~");
			}
		}
		
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBounds(169, 217, 93, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final int ID = chiefId;
				System.out.println("厨师2"+ID);
				LookMenu chief = new LookMenu();
				final int dishesID = dishID;
				System.out.println("菜号"+dishesID);
				try {
					chief.name(ID,dishesID);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.dispose();

			}
		});
		frame.getContentPane().add(btnNewButton);

	}


}
