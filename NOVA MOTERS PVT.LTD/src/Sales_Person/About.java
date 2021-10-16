package Sales_Person;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import Begin.Login;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class About {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About window = new About();
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
	public About() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 235));
		frame.setBounds(100, 100, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Our teams are here to help");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Tekton Pro Cond", Font.PLAIN, 50));
		lblNewLabel.setBounds(184, 89, 617, 93);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("OUR PURPOSE");
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(23, 184, 242, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("HOW WE REACH THAT");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(23, 318, 242, 36);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("WHAT IS THE RESULT");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 139));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(34, 440, 249, 69);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("We are on a mission : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(123, 211, 337, 50);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Method : ");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(123, 351, 337, 36);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Solution : ");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_1_1.setBounds(123, 490, 337, 36);
		frame.getContentPane().add(lblNewLabel_2_1_1);
		
		JTextArea txtrTheWayWe = new JTextArea();
		txtrTheWayWe.setForeground(new Color(255, 255, 255));
		txtrTheWayWe.setBackground(new Color(51, 102, 255));
		txtrTheWayWe.setFont(new Font("Times New Roman", Font.BOLD, 17));
		txtrTheWayWe.setText("The way we do it is super-transparent, safe, fast, and without any pressure, \r\nwith honest care and guidance.");
		txtrTheWayWe.setBounds(169, 386, 735, 57);
		frame.getContentPane().add(txtrTheWayWe);
		
		JTextArea txtrWeJustHappened = new JTextArea();
		txtrWeJustHappened.setForeground(new Color(255, 255, 255));
		txtrWeJustHappened.setBackground(new Color(51, 102, 255));
		txtrWeJustHappened.setFont(new Font("Times New Roman", Font.BOLD, 17));
		txtrWeJustHappened.setText("We just happened to create a brand new used - car buying and selling platform with \r\nmore than 5000 top - condition 150 point inspected cars, a home delivery option, \r\nand a 14-day money-back guarantee. ");
		txtrWeJustHappened.setBounds(169, 526, 735, 64);
		frame.getContentPane().add(txtrWeJustHappened);
		
		JTextArea txtrWeBelieveThat = new JTextArea();
		txtrWeBelieveThat.setForeground(new Color(255, 255, 255));
		txtrWeBelieveThat.setBackground(new Color(51, 102, 255));
		txtrWeBelieveThat.setFont(new Font("Times New Roman", Font.BOLD, 17));
		txtrWeBelieveThat.setText("We believe that everyone should have the right to buy and sell used cars in a fair way,\r\n without shady tactics.");
		txtrWeBelieveThat.setBounds(169, 258, 735, 50);
		frame.getContentPane().add(txtrWeBelieveThat);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.LIGHT_GRAY);
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
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(About.class.getResource("/Images/1.png")));
		lblNewLabel_1_1_1.setBounds(10, 0, 107, 98);
		panel_1.add(lblNewLabel_1_1_1);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sales_Person_Home sphome = new Sales_Person_Home();
				sphome.setVisible(true);
				//close the current window
				frame.setVisible(false);
			}
		});
		btnHome.setForeground(SystemColor.menu);
		btnHome.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnHome.setBackground(new Color(51, 102, 153));
		btnHome.setBounds(165, 29, 120, 43);
		panel_1.add(btnHome);
		
		JButton btnContact = new JButton("Contact");
		btnContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contact contact = new Contact();
				contact.setVisible(true);
				//close the current window
				frame.setVisible(false);
			}
		});
		btnContact.setForeground(SystemColor.menu);
		btnContact.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnContact.setBackground(new Color(51, 102, 153));
		btnContact.setBounds(283, 29, 120, 43);
		panel_1.add(btnContact);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(About.class.getResource("/Images/Untitled design.png")));
		lblNewLabel_3.setBounds(0, 100, 986, 513);
		frame.getContentPane().add(lblNewLabel_3);
	}

	public void setVisible(boolean b) {
		try {
			About window = new About();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
