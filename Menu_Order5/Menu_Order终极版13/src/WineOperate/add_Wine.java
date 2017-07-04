package WineOperate;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Dao.ChiefOperate;
import Dao.ManageOperate;

public class add_Wine implements ActionListener {
	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	JButton add;
	JButton reset;
	ChiefOperate chiefOperate = new ChiefOperate();
	private JComboBox<String> comboBox;
	public add_Wine() {
		initialize();
		frame.setVisible(true);
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(320, 320, 550, 400);
		frame.getContentPane().setLayout(null);
		//标题
		JLabel head = new JLabel("\u6DFB\u52A0\u9152\u54C1");
		head.setFont(new Font("宋体", Font.PLAIN, 16));
		head.setForeground(Color.BLACK);
		head.setBounds(208, 23, 106, 42);
		frame.getContentPane().add(head);
		//菜名
		JLabel name = new JLabel("\u540D\u79F0");
		name.setFont(new Font("宋体", Font.PLAIN, 14));
		name.setBounds(138, 116, 46, 42);
		frame.getContentPane().add(name);
		//价格
		JLabel price = new JLabel("\u4EF7\u683C");
		price.setFont(new Font("宋体", Font.PLAIN, 14));
		price.setBounds(138, 168, 46, 40);
		frame.getContentPane().add(price);
		//类型
		JLabel type = new JLabel("\u7C7B\u578B");
		type.setFont(new Font("宋体", Font.PLAIN, 14));
		type.setBounds(138, 239, 46, 15);
		frame.getContentPane().add(type);
		//酒名
		textField_1 = new JTextField();
		textField_1.setBounds(218, 122, 164, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		//价格
		textField_2 = new JTextField();
		textField_2.setBounds(218, 176, 164, 26);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		//添加按钮
		add = new JButton("\u6DFB\u52A0");
		add.setBounds(179, 290, 75, 23);
		add.addActionListener(this);
		frame.getContentPane().add(add);
		//重置按钮
		reset = new JButton("\u91CD\u7F6E");
		reset.setBounds(300, 290, 75, 23);
		frame.getContentPane().add(reset);
		//下拉列表
		comboBox = new JComboBox();
		comboBox.setBounds(218, 235, 164, 23);
		comboBox.addItem("白酒");
		comboBox.addItem("啤酒");
		frame.getContentPane().add(comboBox);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add) {
			double price = Double.parseDouble(textField_2.getText());
			int type = comboBox.getSelectedIndex() + 1;
			try {
				int id= chiefOperate.addWine(textField_1.getText(), price, type);
				JOptionPane.showMessageDialog(add, "新酒编号为"+id);
				frame.dispose();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}
