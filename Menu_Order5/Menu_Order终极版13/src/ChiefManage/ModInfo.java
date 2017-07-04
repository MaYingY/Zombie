package ChiefManage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;

import Dao.ChiefOperate;
import javax.swing.JPasswordField;

public class ModInfo implements ActionListener {

	private JFrame frame;
	JButton mod;
	JButton reset;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	public ModInfo(String nameString) {
		initialize(nameString);
		frame.setVisible(true);
	}
	private void initialize(final String nameString) {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//标题
		JLabel head = new JLabel("\u4FE1\u606F\u4FEE\u6539");
		head.setFont(new Font("宋体", Font.PLAIN, 14));
		head.setBounds(241, 23, 101, 53);
		frame.getContentPane().add(head);
		//用户名
		JLabel name = new JLabel("旧密码");
		name.setFont(new Font("宋体", Font.PLAIN, 14));
		name.setBounds(164, 121, 54, 15);
		frame.getContentPane().add(name);
		//密码
		JLabel passwd = new JLabel("\u65B0\u5BC6\u7801");
		passwd.setFont(new Font("宋体", Font.PLAIN, 14));
		passwd.setBounds(164, 220, 54, 15);
		frame.getContentPane().add(passwd);
		//修改
		mod = new JButton("\u4FEE\u6539");
		mod.setBounds(199, 299, 70, 23);
		mod.addActionListener(new ActionListener( ) {
			
		public void actionPerformed(ActionEvent arg0) {
			ChiefIfLogin chiefLogin = new ChiefIfLogin();
			String pString=passwordField.getText();
			try {
				if(chiefLogin.ifLogin(nameString, pString)==0){
				ChiefOperate chief = new ChiefOperate();
				try {
					chief.modInfo(nameString, passwordField_1.getText());
					JOptionPane.showMessageDialog(mod, "修改成功");
					frame.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					}
}
					else {
						JOptionPane.showMessageDialog(mod, "密码错误");
				}
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});
		frame.getContentPane().add(mod);
		//重置
		reset = new JButton("\u91CD\u7F6E");
		reset.setBounds(295, 299, 63, 23);
		reset.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent arg0) {
			passwordField.setText("");
			passwordField_1.setText("");				
			}
		});
		frame.getContentPane().add(reset);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(229, 114, 174, 29);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(235, 213, 168, 29);
		frame.getContentPane().add(passwordField_1);
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
