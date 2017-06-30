package WindowsAll;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class wineManage {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public wineManage() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u9152\u5355\u7BA1\u7406");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 14));
		lblNewLabel.setBounds(218, 26, 105, 50);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0\u9152\u54C1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(81, 104, 105, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5220\u9664\u9152\u54C1");
		btnNewButton_1.setBounds(81, 204, 105, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u4FEE\u6539\u9152\u54C1");
		btnNewButton_2.setBounds(297, 104, 93, 35);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u67E5\u8BE2\u9152\u54C1");
		btnNewButton_3.setBounds(297, 204, 93, 35);
		frame.getContentPane().add(btnNewButton_3);
	}
}
