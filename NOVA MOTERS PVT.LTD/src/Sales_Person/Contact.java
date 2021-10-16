package Sales_Person;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Begin.Login;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Contact {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contact window = new Contact();
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
	public Contact() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(100, 100, 1000, 649);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Want to get in touch.?    We'd love to hear from you.  \r\n\r\n\r\n");
		lblNewLabel.setFont(new Font("STZhongsong", Font.PLAIN, 25));
		lblNewLabel.setBounds(161, 151, 937, 68);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Get in touch\r\n");
		lblNewLabel_1.setForeground(new Color(0, 0, 139));
		lblNewLabel_1.setFont(new Font("Tekton Pro", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(350, 93, 349, 87);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblHeresHowYou = new JLabel("Here's how you can reach us...");
		lblHeresHowYou.setFont(new Font("STZhongsong", Font.PLAIN, 25));
		lblHeresHowYou.setBounds(302, 209, 411, 24);
		frame.getContentPane().add(lblHeresHowYou);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Contact.class.getResource("/Images/call.png")));
		lblNewLabel_2.setBounds(124, 256, 226, 214);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Contact.class.getResource("/Images/people.jpg")));
		lblNewLabel_3.setBounds(599, 256, 226, 214);
		frame.getContentPane().add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(471, 243, 4, 360);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("Talk to sales");
		lblNewLabel_4.setForeground(new Color(204, 255, 204));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_4.setBounds(161, 465, 171, 78);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Contact customer support");
		lblNewLabel_4_1.setForeground(new Color(204, 255, 204));
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_4_1.setBounds(583, 465, 275, 78);
		frame.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5 = new JLabel("+94 714568412");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_5.setBounds(139, 532, 303, 59);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("+94 774558445");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_5_1.setBounds(619, 532, 303, 59);
		frame.getContentPane().add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(Contact.class.getResource("/Images/Untitled design.png")));
		lblNewLabel_6.setBounds(0, 98, 986, 514);
		frame.getContentPane().add(lblNewLabel_6);
		
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
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Contact.class.getResource("/Images/1.png")));
		lblNewLabel_1_1.setBounds(10, 0, 107, 98);
		panel_1.add(lblNewLabel_1_1);
		
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
		
		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.setVisible(true);
				//close the current window
				frame.setVisible(false);
			}
		});
		btnAbout.setForeground(SystemColor.menu);
		btnAbout.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAbout.setBackground(new Color(51, 102, 153));
		btnAbout.setBounds(283, 29, 120, 43);
		panel_1.add(btnAbout);
	}

	public void setVisible(boolean b) {
		try {
			Contact window = new Contact();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
