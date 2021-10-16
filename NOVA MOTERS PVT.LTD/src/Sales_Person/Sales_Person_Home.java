package Sales_Person;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Begin.Login;
import Util.db_connection;
import net.proteanit.sql.DbUtils;

public class Sales_Person_Home {

	private JFrame frame;
	private JTable table;
	
	db_connection dbConnection = new db_connection();
	PreparedStatement pst;
	ResultSet rs;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sales_Person_Home window = new Sales_Person_Home();
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
	public Sales_Person_Home() {
		initialize();
		table_load();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	
	public void table_load() {
		try {
			Connection conn = db_connection.connect();
			String query ="select * from cars";
			PreparedStatement pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
				
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Sales_Person_Home.class.getResource("/Images/1.png")));
		lblNewLabel_1.setBounds(10, 0, 107, 98);
		panel_1.add(lblNewLabel_1);
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLogOut.setBackground(new Color(0, 102, 153));
		btnLogOut.setBounds(828, 29, 120, 43);
		panel_1.add(btnLogOut);
		
		JButton btnRegisterCostomers = new JButton("Register Costomers");
		btnRegisterCostomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register_Customer customer = new Register_Customer();
				customer.setVisible(true);
				//close the current window
				frame.setVisible(false);
			}
		});
		btnRegisterCostomers.setForeground(Color.WHITE);
		btnRegisterCostomers.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnRegisterCostomers.setBackground(new Color(0, 102, 153));
		btnRegisterCostomers.setBounds(582, 29, 177, 43);
		panel_1.add(btnRegisterCostomers);
		
		JButton btnAbout = new JButton("About ");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About about = new About();
				about.setVisible(true);
				//close the current window
				frame.setVisible(false);
			}
		});
		btnAbout.setForeground(Color.WHITE);
		btnAbout.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAbout.setBackground(new Color(0, 102, 153));
		btnAbout.setBounds(165, 29, 120, 43);
		panel_1.add(btnAbout);
		
		JButton btnContact = new JButton("Contact");
		btnContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contact contact = new Contact();
				contact.setVisible(true);
				//close the current window
				frame.setVisible(false);
			}
		});
		btnContact.setForeground(Color.WHITE);
		btnContact.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnContact.setBackground(new Color(0, 102, 153));
		btnContact.setBounds(283, 29, 120, 43);
		panel_1.add(btnContact);
		
		table = new JTable();
		table.setBackground(SystemColor.activeCaption);
		
		JLabel lblCarsInThe = new JLabel("Available Cars");
		lblCarsInThe.setForeground(new Color(0, 0, 128));
		lblCarsInThe.setFont(new Font("Dialog", Font.PLAIN, 50));
		lblCarsInThe.setBounds(289, 99, 462, 93);
		frame.getContentPane().add(lblCarsInThe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 205, 909, 367);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(SystemColor.activeCaption);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Sales_Person_Home.class.getResource("/Images/Untitled design.png")));
		lblNewLabel.setBounds(0, 98, 986, 515);
		frame.getContentPane().add(lblNewLabel);
	}
	
	public void setVisible(boolean b) {
		try {
			Sales_Person_Home window = new Sales_Person_Home();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
