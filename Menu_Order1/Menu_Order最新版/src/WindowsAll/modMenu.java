package WindowsAll;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Domain.ManageOperate;

public class modMenu implements ActionListener{
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JButton mod;
	JButton reset;
	ManageOperate manageOperate = new ManageOperate();

	/**
	 * Create the application.
	 */
	public modMenu() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(320, 320, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//标题
		JLabel head = new JLabel("\u4FEE\u6539\u83DC\u54C1");
		head.setFont(new Font("宋体", Font.PLAIN, 16));
		head.setForeground(Color.BLACK);
		head.setBounds(208, 23, 106, 42);
		frame.getContentPane().add(head);
		//编号
		JLabel id = new JLabel("\u7F16\u53F7");
		id.setFont(new Font("宋体", Font.PLAIN, 14));
		id.setBounds(138, 77, 64, 50);
		frame.getContentPane().add(id);
		//菜名
		JLabel name = new JLabel("\u83DC\u540D");
		name.setFont(new Font("宋体", Font.PLAIN, 14));
		name.setBounds(138, 136, 46, 50);
		frame.getContentPane().add(name);
		//价格
		JLabel price = new JLabel("\u4EF7\u683C");
		price.setFont(new Font("宋体", Font.PLAIN, 14));
		price.setBounds(138, 196, 64, 50);
		frame.getContentPane().add(price);
		//主厨编号
		JLabel chiefId = new JLabel("\u4E3B\u53A8\u7F16\u53F7");
		chiefId.setFont(new Font("宋体", Font.PLAIN, 14));
		chiefId.setBounds(114, 256, 58, 50);
		frame.getContentPane().add(chiefId);
		//编号
		textField = new JTextField();
		textField.setBounds(208, 90, 164, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		//菜名
		textField_1 = new JTextField();
		textField_1.setBounds(208, 152, 164, 32);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		//价格
		textField_2 = new JTextField();
		textField_2.setBounds(209, 206, 164, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		//主厨编号
		textField_3 = new JTextField();
		textField_3.setBounds(208, 266, 164, 26);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		//添加按钮
		mod = new JButton("\u4FEE\u6539");
		mod.addActionListener(this);
		mod.setBounds(176, 315, 75, 23);
		frame.getContentPane().add(mod);
		//重置按钮
		reset = new JButton("\u91CD\u7F6E");
		reset.setBounds(305, 315, 75, 23);
		frame.getContentPane().add(reset);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == mod) {
			int id = (int)Integer.parseInt(textField.getText());
			int chief = (int)Integer.parseInt(textField_3.getText());
			double price = Double.parseDouble(textField_2.getText());
			try {
				manageOperate.modMenu(id, textField_1.getText(), price, chief);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
