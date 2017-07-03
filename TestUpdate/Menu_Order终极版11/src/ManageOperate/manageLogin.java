package ManageOperate;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;


import Dao.ManageOperate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class manageLogin implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton login;
	private JButton reset;
	public manageLogin() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 550, 400);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		// 管理员登陆
		JLabel headname = new JLabel("\u7BA1\u7406\u5458\u767B\u5F55");
		headname.setBounds(223, 27, 136, 46);
		frame.getContentPane().add(headname);
		// 用户名
		JLabel username = new JLabel("\u7528\u6237\u540D");
		username.setBounds(164, 102, 76, 34);
		frame.getContentPane().add(username);
		// 密码
		JLabel passwd = new JLabel("\u5BC6\u7801");
		passwd.setBounds(164, 168, 76, 34);
		frame.getContentPane().add(passwd);
		// 用户名框
		textField = new JTextField();
		textField.setBounds(250, 109, 136, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addActionListener(this);
		// 密码框
		passwordField = new JPasswordField();
		passwordField.setBounds(250, 175, 136, 21);
		frame.getContentPane().add(passwordField);
		passwordField.addActionListener(this);
		// 登陆
		login = new JButton("\u767B\u9646");
		login.setBounds(202, 243, 66, 34);
		login.addActionListener(this);
		frame.getContentPane().add(login);
		// 重置
		reset = new JButton("\u91CD\u7F6E");
		reset.setBounds(302, 243, 66, 34);
		reset.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				passwordField.setText("");
			}
		});
		frame.getContentPane().add(reset);

	}

	public void actionPerformed(ActionEvent e) {
		String username = textField.getText();
		@SuppressWarnings("deprecation")
		String password = passwordField.getText();
		
		if (e.getSource() == login) {
			if (username.isEmpty()) {
				// 用户名异常
				JTextField textField_1 = new JTextField(10);
				textField_1.setBounds(250, 140, 173, 21);
				textField_1.setEditable(false);
				textField_1.setText("用户名不能为空 ！");
				frame.getContentPane().add(textField_1);
			} 
			else{
				try {
					ManageOperate manageOperate = new ManageOperate();
					int a = manageOperate.Login(username);
					if(a == 1) {
					JTextField textField_1 = new JTextField(10);
					textField_1.setBounds(250, 140, 173, 21);
					textField_1.setEditable(false);   
					textField_1.setText("用户名不存在 ！");
					frame.getContentPane().add(textField_1);
				}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
			if (password.isEmpty()) {
				// 密码异常
				JTextField textField_2 = new JTextField();
				textField_2.setBounds(250, 212, 173, 21);
				textField_2.setEditable(false);
				textField_2.setVisible(true);
				frame.getContentPane().add(textField_2);
				textField_2.setColumns(10);
				textField_2.setText("密码不能为空 ！");
			} 
			if (! username.isEmpty() && ! password.isEmpty()) {
				
				try {
					ManageOperate manageOperate = new ManageOperate();
					int flag = manageOperate.ifLogin(username, password);
					if(flag == 0) {
						new manageOperate();
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(login, "密码错误");
					}
				} 
				 catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}

	}
}
