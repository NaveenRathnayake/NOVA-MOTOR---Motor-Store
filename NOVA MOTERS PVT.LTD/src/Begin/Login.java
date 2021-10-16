package Begin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import Model.Login_Model;
import Util.db_connection;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;
	
	db_connection dbConnection = new db_connection();
	Login_Model login = new Login_Model();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 865, 494);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(441, 23, 186, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword_1 = new JLabel("Username");
		lblPassword_1.setForeground(Color.DARK_GRAY);
		lblPassword_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword_1.setBounds(500, 82, 91, 26);
		frame.getContentPane().add(lblPassword_1);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.BOLD, 15));
		username.setBackground(Color.WHITE);
		username.setColumns(10);
		username.setBounds(500, 108, 282, 38);
		frame.getContentPane().add(username);
		
		JLabel lblPassword_1_1 = new JLabel("Password");
		lblPassword_1_1.setForeground(Color.DARK_GRAY);
		lblPassword_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword_1_1.setBounds(500, 171, 91, 26);
		frame.getContentPane().add(lblPassword_1_1);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.BOLD, 15));
		password.setBounds(500, 198, 282, 38);
		frame.getContentPane().add(password);
		
		//set method to show and hide the password while typing
				JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
				chckbxNewCheckBox.setBackground(UIManager.getColor("Button.shadow"));
				chckbxNewCheckBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (chckbxNewCheckBox.isSelected()) {
							password.setEchoChar((char)0);
						}
						else {
							password.setEchoChar('*');
					}
					}
				});
				chckbxNewCheckBox.setFont(new Font("Times New Roman", Font.BOLD, 13));
				chckbxNewCheckBox.setBounds(500, 242, 118, 26);
				frame.getContentPane().add(chckbxNewCheckBox);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				//call the insertloginDetails in ADD_Login_Model class by passing the parameters
				login.checkloginDetails(username.getText(),password.getText());
				frame.setVisible(false);
			}	
			
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.setBounds(696, 395, 116, 38);
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 10, 395, 437);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(-25, -11, 410, 438);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/Images/Logo.png")));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/Images/Untitled design.png")));
		lblNewLabel_1.setBounds(0, 0, 851, 457);
		frame.getContentPane().add(lblNewLabel_1);
	}

	//set to visible when call the window
	public void setVisible(boolean b) {
		try {
			Login window = new Login();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
