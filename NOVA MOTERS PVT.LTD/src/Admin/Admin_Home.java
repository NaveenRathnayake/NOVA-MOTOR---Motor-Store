package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import Begin.Login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Home window = new Admin_Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(SystemColor.control);
		frame.setBounds(100, 100, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_1_1 = new JButton("Edit & View Car Details");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cars cars = new Cars();
				cars.setVisible(true);
				//close the current window
				frame.setVisible(false);
			}
		});
		btnNewButton_1_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1_1.setBackground(UIManager.getColor("Button.light"));
		btnNewButton_1_1.setBounds(359, 148, 245, 98);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Edit & View Employees Details");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employees employee = new Employees();
				employee.setVisible(true);
				//close the current window
				frame.setVisible(false);
			}
		});
		btnNewButton_1_1_1_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1_1_1_1.setBackground(UIManager.getColor("Button.light"));
		btnNewButton_1_1_1_1.setBounds(359, 299, 250, 98);
		frame.getContentPane().add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1_1 = new JButton("Edit & View Login Details");
		btnNewButton_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Login addlogin = new Add_Login();
				addlogin.setVisible(true);
				//close the current window
				frame.setVisible(false);
			}
		});
		btnNewButton_1_1_1_1_1_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1_1_1_1_1_1.setBackground(UIManager.getColor("Button.light"));
		btnNewButton_1_1_1_1_1_1.setBounds(359, 452, 250, 92);
		frame.getContentPane().add(btnNewButton_1_1_1_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(SystemColor.activeCaption);
		panel_1.setBackground(SystemColor.menu);
		panel_1.setBounds(0, 0, 986, 98);
		frame.getContentPane().add(panel_1);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				//close the current window
				frame.setVisible(false);
			}
		});
		btnLogOut.setForeground(SystemColor.menu);
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnLogOut.setBackground(new Color(51, 102, 153));
		btnLogOut.setBounds(828, 29, 120, 43);
		panel_1.add(btnLogOut);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Admin_Home.class.getResource("/Images/1.png")));
		lblNewLabel_1.setBounds(36, 0, 107, 98);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Admin_Home.class.getResource("/Images/Untitled design.png")));
		lblNewLabel.setBounds(0, 94, 986, 519);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		try {
			Admin_Home window = new Admin_Home();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
