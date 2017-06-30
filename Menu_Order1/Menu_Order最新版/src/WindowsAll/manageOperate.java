package WindowsAll;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class manageOperate implements ActionListener{

	private JFrame frame;
	JButton foodManage;
	JButton wineManage;
	private JButton chiefManage;
	private JButton waiterManage;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public manageOperate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300,300, 550, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//标题
		JLabel headName = new JLabel("\u6B22\u8FCE\u6765\u5230\u597D\u8FD0\u6765\u996D\u5E97\uFF01");
		headName.setBounds(187, 26, 147, 41);
		frame.getContentPane().add(headName);
		//菜品管理
		foodManage = new JButton("\u83DC\u54C1\u7BA1\u7406");
		foodManage.setBounds(78, 115, 110, 41);
		foodManage.addActionListener(this);
		frame.getContentPane().add(foodManage);
		//酒品管理
		wineManage = new JButton("\u9152\u54C1\u7BA1\u7406");
		wineManage.addActionListener(this);
		wineManage.setBounds(78, 217, 109, 46);
		wineManage.addActionListener(this);
		frame.getContentPane().add(wineManage);
		//厨师管理
		chiefManage = new JButton("\u53A8\u5E08\u7BA1\u7406");
		chiefManage.setBounds(292, 115, 110, 41);
		chiefManage.addActionListener(this);
		frame.getContentPane().add(chiefManage);
		//服务员管理
		waiterManage = new JButton("\u670D\u52A1\u5458\u7BA1\u7406");
		waiterManage.setBounds(292, 217, 110, 46);
		waiterManage.addActionListener(this);
		frame.getContentPane().add(waiterManage);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == foodManage) {
			menuManage menu = new menuManage();
			frame.dispose();
		}
		if(e.getSource() == wineManage) {
			
		}
	}
}
