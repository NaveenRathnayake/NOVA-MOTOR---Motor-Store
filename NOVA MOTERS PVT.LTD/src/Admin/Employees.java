package Admin;

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
import Model.Employee_Model;
import Util.db_connection;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employees {

	private JFrame frame;
	private JTextField textField;
	private JTextField search;
	private JTextField firstname;
	private JTextField surename;
	private JTextField gender;
	private JTextField dob;
	private JTextField email;
	private JTextField contactno;
	private JTextField address;
	private JTextField designation;
	private JTextField basicsalary;
	private JTextField nic;
	private JTable table;

	
	db_connection dbConnection = new db_connection();
	Employee_Model employee = new Employee_Model();
	PreparedStatement pst;
	ResultSet rs;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employees window = new Employees();
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
	public Employees() {
		initialize();
		table_load();
	}

	public void table_load() {
		try {
			Connection conn = db_connection.connect();
			String query ="select * from employee";
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
		panel_1.setBounds(0, 0, 0, 0);
		panel_1.setLayout(null);
		panel_1.setForeground(Color.LIGHT_GRAY);
		panel_1.setBackground(SystemColor.menu);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 0, 107, 98);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Add car");
		btnNewButton.setBounds(0, 0, 0, 0);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBackground(SystemColor.controlHighlight);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("Clear");
		btnReset.setBounds(0, 0, 0, 0);
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnReset.setBackground(SystemColor.controlHighlight);
		frame.getContentPane().add(btnReset);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(0, 0, 0, 0);
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnUpdate.setBackground(SystemColor.controlHighlight);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(0, 0, 0, 0);
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDelete.setBackground(SystemColor.controlHighlight);
		frame.getContentPane().add(btnDelete);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(0, 0, 986, 1);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBackground(SystemColor.menu);
		frame.getContentPane().add(panel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Car ID");
		lblNewLabel_1_3.setForeground(Color.GRAY);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_3.setBackground(SystemColor.controlHighlight);
		lblNewLabel_1_3.setBounds(31, 14, 108, 31);
		panel_1_1.add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(118, 13, 179, 35);
		panel_1_1.add(textField);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setForeground(Color.LIGHT_GRAY);
		panel_1_2.setBackground(SystemColor.menu);
		panel_1_2.setBounds(0, 0, 986, 98);
		frame.getContentPane().add(panel_1_2);
		
		JButton btnLogOut_1 = new JButton("Log Out");
		btnLogOut_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				//close the current window
				frame.setVisible(false);
			}
		});
		btnLogOut_1.setForeground(SystemColor.menu);
		btnLogOut_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnLogOut_1.setBackground(new Color(51, 102, 153));
		btnLogOut_1.setBounds(800, 29, 120, 43);
		panel_1_2.add(btnLogOut_1);
		
		JButton btnAdminHome_1 = new JButton("Admin Home");
		btnAdminHome_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_Home adhome = new Admin_Home();
				adhome.setVisible(true);
				//close the current window
				frame.setVisible(false);
			}
		});
		btnAdminHome_1.setForeground(SystemColor.menu);
		btnAdminHome_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAdminHome_1.setBackground(new Color(51, 102, 153));
		btnAdminHome_1.setBounds(166, 29, 134, 43);
		panel_1_2.add(btnAdminHome_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(Employees.class.getResource("/Images/1.png")));
		lblNewLabel_1_1.setBounds(10, 0, 107, 98);
		panel_1_2.add(lblNewLabel_1_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the insertemployeeDetails in ADD_Login_Model class by passing the parameters
				employee.insertemployeeDetails(firstname.getText(),surename.getText(), gender.getText(), dob.getText(),
						email.getText(), contactno.getText(), address.getText(), designation.getText(), basicsalary.getText(),nic.getText());
				//load the table with inserted details
				table_load();
				//show a pop-up message
					JOptionPane.showMessageDialog(null, "Employee Details Adding Process Successfull");
					
					firstname.setText("");
					surename.setText("");
					gender.setText("");
					dob.setText("");
					email.setText("");
					contactno.setText("");
					address.setText("");
					designation.setText("");
					basicsalary.setText("");
					nic.setText("");
					firstname.requestFocus();
			
			}
		});
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAdd.setBackground(UIManager.getColor("Button.light"));
		btnAdd.setBounds(389, 550, 114, 41);
		frame.getContentPane().add(btnAdd);
		
		JButton btnReset_1 = new JButton("Clear");
		btnReset_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstname.setText("");
				surename.setText("");
				gender.setText("");
				dob.setText("");
				email.setText("");
				contactno.setText("");
				address.setText("");
				designation.setText("");
				basicsalary.setText("");
				nic.setText("");
				search.setText("");
				firstname.requestFocus();
			}
		});
		btnReset_1.setForeground(Color.BLACK);
		btnReset_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnReset_1.setBackground(UIManager.getColor("Button.light"));
		btnReset_1.setBounds(546, 550, 114, 41);
		frame.getContentPane().add(btnReset_1);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the updateemployeeDetails in ADD_Login_Model class by passing the parameters
				employee.updateemployeeDetails(firstname.getText(),surename.getText(), gender.getText(), dob.getText(),
						email.getText(), contactno.getText(), address.getText(), designation.getText(), basicsalary.getText(),nic.getText(),search.getText());
				table_load();
				JOptionPane.showMessageDialog(null, "Employee Details Adding Process Successfull");
					
					firstname.setText("");
					surename.setText("");
					gender.setText("");
					dob.setText("");
					email.setText("");
					contactno.setText("");
					address.setText("");
					designation.setText("");
					basicsalary.setText("");
					nic.setText("");
					search.setText("");
					firstname.requestFocus();

			}
		});
		btnUpdate_1.setForeground(Color.BLACK);
		btnUpdate_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnUpdate_1.setBackground(UIManager.getColor("Button.light"));
		btnUpdate_1.setBounds(699, 550, 114, 41);
		frame.getContentPane().add(btnUpdate_1);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the deleteemployeeDetails in ADD_Login_Model class by passing the parameters
				employee.deleteemployeeDetails(search.getText());
				table_load();
				JOptionPane.showMessageDialog(null, "Details Deleted Successfully");
					
					firstname.setText("");
					surename.setText("");
					gender.setText("");
					dob.setText("");
					email.setText("");
					contactno.setText("");
					address.setText("");
					designation.setText("");
					basicsalary.setText("");
					nic.setText("");
					search.setText("");
					firstname.requestFocus();
		 }
		});
		btnDelete_1.setForeground(Color.BLACK);
		btnDelete_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDelete_1.setBackground(UIManager.getColor("Button.light"));
		btnDelete_1.setBounds(851, 550, 114, 41);
		frame.getContentPane().add(btnDelete_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1_1.setBackground(SystemColor.menu);
		panel_1_1_1.setBounds(22, 538, 307, 53);
		frame.getContentPane().add(panel_1_1_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Employee ID");
		lblNewLabel_1_3_1.setForeground(Color.BLACK);
		lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_3_1.setBackground(SystemColor.controlHighlight);
		lblNewLabel_1_3_1.setBounds(10, 14, 108, 31);
		panel_1_1_1.add(lblNewLabel_1_3_1);
		
		search = new JTextField();
		search.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String eid = search.getText();
					Connection conn = db_connection.connect();
					if (conn == null) {
						System.out.println(" Error while Connecting to the database");
					}
					String query = "select `First_Name`, `Surename`, `Gender`,`D.O.B`,`Email`, `Contact_NO`, `Address`, `Designation`,`Basic_Salary`, `Nic` from employee where Employee_ID = ?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, eid);
					ResultSet rs = pst.executeQuery();
					
					if (rs.next()==true) {
						
						String efirstname = rs.getString(1);
						String esurename = rs.getString(2);
						String egender = rs.getString(3);
						String edob = rs.getString(4);
						String eemail = rs.getString(5);
						String econtactno = rs.getString(6);
						String eaddress = rs.getString(7);
						String edesignation = rs.getString(8);
						String ebasicsalary = rs.getString(9);
						String enic = rs.getString(10);
						
						firstname.setText(efirstname);
						surename.setText(esurename);
						gender.setText(egender);
						dob.setText(edob);
						email.setText(eemail);
						contactno.setText(econtactno);
						address.setText(eaddress);
						designation.setText(edesignation);
						basicsalary.setText(ebasicsalary);
						nic.setText(enic);
					}					
					else {
						firstname.setText("");
						surename.setText("");
						gender.setText("");
						dob.setText("");
						email.setText("");
						contactno.setText("");
						address.setText("");
						designation.setText("");
						basicsalary.setText("");
						nic.setText("");						
					}				
				}
				catch(SQLException ex) {					
				}
			}
		});
		
		search.setColumns(10);
		search.setBounds(118, 13, 179, 35);
		panel_1_1_1.add(search);
		
		firstname = new JTextField();
		firstname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		firstname.setColumns(10);
		firstname.setBounds(125, 123, 153, 19);
		frame.getContentPane().add(firstname);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblFirstName.setBounds(11, 121, 104, 18);
		frame.getContentPane().add(lblFirstName);
		
		surename = new JTextField();
		surename.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		surename.setColumns(10);
		surename.setBounds(125, 165, 153, 19);
		frame.getContentPane().add(surename);
		
		JLabel lblSureName = new JLabel("Sure Name");
		lblSureName.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblSureName.setBounds(10, 152, 105, 41);
		frame.getContentPane().add(lblSureName);
		
		gender = new JTextField();
		gender.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		gender.setColumns(10);
		gender.setBounds(125, 208, 153, 19);
		frame.getContentPane().add(gender);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblGender.setBounds(11, 209, 104, 13);
		frame.getContentPane().add(lblGender);
		
		dob = new JTextField();
		dob.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		dob.setColumns(10);
		dob.setBounds(125, 251, 153, 19);
		frame.getContentPane().add(dob);
		
		JLabel lblDob = new JLabel("D.O.B");
		lblDob.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblDob.setBounds(11, 252, 104, 13);
		frame.getContentPane().add(lblDob);
		
		email = new JTextField();
		email.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		email.setColumns(10);
		email.setBounds(125, 293, 153, 19);
		frame.getContentPane().add(email);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblEmail.setBounds(11, 294, 105, 13);
		frame.getContentPane().add(lblEmail);
		
		contactno = new JTextField();
		contactno.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contactno.setColumns(10);
		contactno.setBounds(125, 333, 153, 19);
		frame.getContentPane().add(contactno);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblContactNo.setBounds(11, 334, 104, 13);
		frame.getContentPane().add(lblContactNo);
		
		address = new JTextField();
		address.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		address.setColumns(10);
		address.setBounds(125, 373, 153, 19);
		frame.getContentPane().add(address);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblAddress.setBounds(11, 374, 104, 13);
		frame.getContentPane().add(lblAddress);
		
		designation = new JTextField();
		designation.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		designation.setColumns(10);
		designation.setBounds(125, 411, 153, 19);
		frame.getContentPane().add(designation);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblDesignation.setBounds(11, 405, 104, 26);
		frame.getContentPane().add(lblDesignation);
		
		basicsalary = new JTextField();
		basicsalary.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		basicsalary.setColumns(10);
		basicsalary.setBounds(125, 453, 153, 19);
		frame.getContentPane().add(basicsalary);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary");
		lblBasicSalary.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblBasicSalary.setBounds(11, 451, 105, 18);
		frame.getContentPane().add(lblBasicSalary);
		
		nic = new JTextField();
		nic.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		nic.setColumns(10);
		nic.setBounds(125, 491, 153, 19);
		frame.getContentPane().add(nic);
		
		JLabel lblNic = new JLabel("Nic");
		lblNic.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNic.setBounds(11, 492, 105, 13);
		frame.getContentPane().add(lblNic);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(293, 108, 683, 415);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(SystemColor.activeCaption);
		table.setFont(new Font("Times New Roman", Font.BOLD, 10));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Employees.class.getResource("/Images/Untitled design.png")));
		lblNewLabel_2.setBounds(0, 99, 986, 514);
		frame.getContentPane().add(lblNewLabel_2);
	}

	public void setVisible(boolean b) {
		try {
			Employees window = new Employees();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
