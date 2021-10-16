package Sales_Person;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import Begin.Login;
import Model.Register_Customer_Model;
import Util.db_connection;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Register_Customer {

	private JFrame frame;
	private JTextField search;
	private JTextField nicno;
	private JTextField address;
	private JTextField contactno;
	private JTextField email;
	private JTextField dob;
	private JTextField surname;
	private JTextField gender;
	private JTextField firstname;
	private JTable table;
	
	db_connection dbConnection = new db_connection();
	Register_Customer_Model customer = new Register_Customer_Model();
	PreparedStatement pst;
	ResultSet rs;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register_Customer window = new Register_Customer();
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
	public Register_Customer() {
		initialize();
		table_load();
	}
	
	public void table_load() {
		try {
			Connection conn = db_connection.connect();
			String query ="select * from customer_detail";
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
		frame.setBounds(100, 100, 999, 650);
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
		btnLogOut.setForeground(SystemColor.menu);
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnLogOut.setBackground(new Color(51, 102, 153));
		btnLogOut.setBounds(828, 29, 120, 43);
		panel_1.add(btnLogOut);
		
		JButton btnAdminHome = new JButton("Home");
		btnAdminHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sales_Person_Home sphome = new Sales_Person_Home();
				sphome.setVisible(true);
				//close the current window
				frame.setVisible(false);
			}
		});
		btnAdminHome.setForeground(Color.WHITE);
		btnAdminHome.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAdminHome.setBackground(new Color(51, 102, 153));
		btnAdminHome.setBounds(166, 29, 134, 43);
		panel_1.add(btnAdminHome);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Register_Customer.class.getResource("/Images/1.png")));
		lblNewLabel_1.setBounds(10, 0, 107, 98);
		panel_1.add(lblNewLabel_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the insertcustomerDetails in ADD_Login_Model class by passing the parameters
				customer.insertcustomerDetails(firstname.getText(), surname.getText(), gender.getText(), dob.getText(),
						email.getText(), contactno.getText(), address.getText(), nicno.getText());
				//load the table with inserted details
				table_load();
				//show a pop-up message
					JOptionPane.showMessageDialog(null, "Details Saved Successfully");
					
					firstname.setText("");
					surname.setText("");
					gender.setText("");
					dob.setText("");
					email.setText("");
					contactno.setText("");
					address.setText("");
					nicno.setText("");
					firstname.requestFocus();
			}
		});
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAdd.setBackground(UIManager.getColor("Button.light"));
		btnAdd.setBounds(389, 550, 114, 41);
		frame.getContentPane().add(btnAdd);
		
		JButton btnReset = new JButton("Clear");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstname.setText("");
				surname.setText("");
				gender.setText("");
				dob.setText("");
				email.setText("");
				contactno.setText("");
				address.setText("");
				nicno.setText("");
				search.setText("");
				firstname.requestFocus();
			}
		});
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnReset.setBackground(UIManager.getColor("Button.light"));
		btnReset.setBounds(546, 550, 114, 41);
		frame.getContentPane().add(btnReset);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the updatecustomerDetails in ADD_Login_Model class by passing the parameters
				customer.updatecustomerDetails(firstname.getText(), surname.getText(), gender.getText(), dob.getText(),
						email.getText(), contactno.getText(), address.getText(), nicno.getText(), search.getText());
				//load the table with inserted details
				table_load();
				//show a pop-up message
					JOptionPane.showMessageDialog(null, "Details Updated Successfully");
					
					firstname.setText("");
					surname.setText("");
					gender.setText("");
					dob.setText("");
					email.setText("");
					contactno.setText("");
					address.setText("");
					nicno.setText("");
					search.setText("");
					firstname.requestFocus();

			}
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnUpdate.setBackground(UIManager.getColor("Button.light"));
		btnUpdate.setBounds(699, 550, 114, 41);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the deletecustomerDetails in ADD_Login_Model class by passing the parameters
				customer.deletecustomerDetails(search.getText());
				//load the table with inserted details
				table_load();
				//show a pop-up message
					JOptionPane.showMessageDialog(null, "Details Deleted Successfully");
					
					firstname.setText("");
					surname.setText("");
					gender.setText("");
					dob.setText("");
					email.setText("");
					contactno.setText("");
					address.setText("");
					nicno.setText("");
					search.setText("");
					firstname.requestFocus();

			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDelete.setBackground(UIManager.getColor("Button.light"));
		btnDelete.setBounds(851, 550, 114, 41);
		frame.getContentPane().add(btnDelete);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBackground(SystemColor.menu);
		panel_1_1.setBounds(31, 550, 307, 53);
		frame.getContentPane().add(panel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Customer ID");
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_3.setBackground(SystemColor.controlHighlight);
		lblNewLabel_1_3.setBounds(10, 14, 108, 31);
		panel_1_1.add(lblNewLabel_1_3);
		
		search = new JTextField();
		search.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String customerid = search.getText();
					Connection conn = db_connection.connect();
					if (conn == null) {
						System.out.println(" Error while Connecting to the database");
					}
					String query = "select `First_name`, `Surname`, `Gender`, `D.O.B.`, `Email`, `Contact_No`, `Address`, `NIC_No` from `customer_detail` where Customer_ID = ?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, customerid);
					ResultSet rs = pst.executeQuery();
					
					if (rs.next()==true) {												
						String cfirstname = rs.getString(1);
						String csurname = rs.getString(2);
						String cgender = rs.getString(3);
						String cdob = rs.getString(4);
						String cemail = rs.getString(5);
						String ccontactno = rs.getString(6);
						String caddress = rs.getString(7);
						String cnicno = rs.getString(8);
						
						firstname.setText(cfirstname);
						surname.setText(csurname);
						gender.setText(cgender);
						dob.setText(cdob);
						email.setText(cemail);
						contactno.setText(ccontactno);
						address.setText(caddress);
						nicno.setText(cnicno);
						firstname.requestFocus();												
					}					
					else {
						firstname.setText("");
						surname.setText("");
						gender.setText("");
						dob.setText("");
						email.setText("");
						contactno.setText("");
						address.setText("");
						nicno.setText("");
					}					
				}
				catch(SQLException ex) {					
				}
			}
		});
		search.setColumns(10);
		search.setBounds(118, 13, 179, 35);
		panel_1_1.add(search);
		
		JLabel lblNewLabel_7_1 = new JLabel("Nic No");
		lblNewLabel_7_1.setForeground(Color.BLACK);
		lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_7_1.setBackground(SystemColor.menu);
		lblNewLabel_7_1.setBounds(10, 475, 114, 31);
		frame.getContentPane().add(lblNewLabel_7_1);
		
		nicno = new JTextField();
		nicno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		nicno.setColumns(10);
		nicno.setBounds(115, 479, 236, 27);
		frame.getContentPane().add(nicno);
		
		JLabel lblNewLabel_7 = new JLabel("Address");
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_7.setBackground(SystemColor.menu);
		lblNewLabel_7.setBounds(10, 425, 114, 31);
		frame.getContentPane().add(lblNewLabel_7);
		
		address = new JTextField();
		address.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		address.setColumns(10);
		address.setBounds(115, 429, 236, 27);
		frame.getContentPane().add(address);
		
		JLabel lblNewLabel_6 = new JLabel("Contact No");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6.setBackground(SystemColor.menu);
		lblNewLabel_6.setBounds(10, 379, 114, 31);
		frame.getContentPane().add(lblNewLabel_6);
		
		contactno = new JTextField();
		contactno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contactno.setColumns(10);
		contactno.setBounds(115, 383, 236, 27);
		frame.getContentPane().add(contactno);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBackground(SystemColor.menu);
		lblNewLabel_5.setBounds(10, 331, 136, 31);
		frame.getContentPane().add(lblNewLabel_5);
		
		email = new JTextField();
		email.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		email.setColumns(10);
		email.setBounds(115, 335, 236, 27);
		frame.getContentPane().add(email);
		
		JLabel lblNewLabel_4 = new JLabel("D.O.B");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBackground(SystemColor.menu);
		lblNewLabel_4.setBounds(10, 282, 114, 31);
		frame.getContentPane().add(lblNewLabel_4);
		
		dob = new JTextField();
		dob.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		dob.setColumns(10);
		dob.setBounds(115, 286, 236, 27);
		frame.getContentPane().add(dob);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBackground(SystemColor.menu);
		lblNewLabel_3.setBounds(10, 236, 114, 31);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblSurename = new JLabel("Surename");
		lblSurename.setForeground(Color.BLACK);
		lblSurename.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblSurename.setBackground(SystemColor.menu);
		lblSurename.setBounds(10, 188, 114, 31);
		frame.getContentPane().add(lblSurename);
		
		surname = new JTextField();
		surname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		surname.setColumns(10);
		surname.setBounds(115, 192, 236, 27);
		frame.getContentPane().add(surname);
		
		gender = new JTextField();
		gender.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		gender.setColumns(10);
		gender.setBounds(115, 240, 236, 27);
		frame.getContentPane().add(gender);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblFirstName.setBackground(SystemColor.menu);
		lblFirstName.setBounds(10, 141, 114, 31);
		frame.getContentPane().add(lblFirstName);
		
		firstname = new JTextField();
		firstname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		firstname.setColumns(10);
		firstname.setBounds(115, 145, 236, 27);
		frame.getContentPane().add(firstname);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(361, 135, 614, 392);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(SystemColor.activeCaption);
		table.setFont(new Font("Times New Roman", Font.BOLD, 10));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Register_Customer.class.getResource("/Images/Untitled design.png")));
		lblNewLabel.setBounds(0, 96, 986, 517);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		try {
			Register_Customer window = new Register_Customer();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
