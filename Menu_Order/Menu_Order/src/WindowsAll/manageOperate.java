package WindowsAll;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class manageOperate {

	private JFrame frame;

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
		JButton foodSearch = new JButton("\u83DC\u54C1\u7BA1\u7406");
		foodSearch.setBounds(182, 97, 110, 41);
		frame.getContentPane().add(foodSearch);
		//酒品管理
		JButton wineSearch = new JButton("\u9152\u54C1\u7BA1\u7406");
		wineSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		wineSearch.setBounds(183, 181, 109, 46);
		frame.getContentPane().add(wineSearch);
	}
}
