package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import Begin.Login;
import Model.Add_Login_Model;
import Util.db_connection;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Add_Login {

	private JFrame frame;
	private JTextField search;
	private JTextField password;
	private JTextField username;
	private JTable table;
	
	db_connection dbConnection = new db_connection();
	Add_Login_Model addlogin = new Add_Login_Model();
	PreparedStatement pst;
	ResultSet rs;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Login window = new Add_Login();
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
	public Add_Login() {
		initialize();
		table_load();
	}

	//load the table
	public void table_load() {
		try {
			Connection conn = db_connection.connect();
			String query ="select * from login";
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
		frame.setBounds(100, 100, 997, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		lblNewLabel_1_1.setIcon(new ImageIcon(Add_Login.class.getResource("/Images/1.png")));
		lblNewLabel_1_1.setBounds(10, 0, 107, 98);
		panel_1_2.add(lblNewLabel_1_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the insertloginDetails in ADD_Login_Model class by passing the parameters
				addlogin.insertloginDetails(username.getText(),password.getText());
				//load the table with inserted details
				table_load();
				//show a pop-up message
				JOptionPane.showMessageDialog(null, "Login Details Saved Successfully");
				//clear the text-fields
				username.setText("");
				password.setText("");
				//get cursor to the fist text-field
				username.requestFocus();
			}
		});
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAdd.setBackground(UIManager.getColor("Button.light"));
		btnAdd.setBounds(37, 353, 114, 41);
		frame.getContentPane().add(btnAdd);
		
		JButton btnReset_1 = new JButton("Clear");
		btnReset_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//clear the text-fields
				username.setText("");
				password.setText("");
				//get cursor to the fist text-field
				username.requestFocus();
			}
		});
		btnReset_1.setForeground(Color.BLACK);
		btnReset_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnReset_1.setBackground(UIManager.getColor("Button.light"));
		btnReset_1.setBounds(269, 353, 114, 41);
		frame.getContentPane().add(btnReset_1);
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the updateloginDetails in ADD_Login_Model class by passing the parameters
				addlogin.updateloginDetails(username.getText(),password.getText(),search.getText());
				table_load();
				JOptionPane.showMessageDialog(null, "Login Details Updated Successfully");
					//clear the text-fields
					username.setText("");
					password.setText("");
					search.setText("");
					//get cursor to the fist text-field
					username.requestFocus();
				
			}
		});
		btnUpdate_1.setForeground(Color.BLACK);
		btnUpdate_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnUpdate_1.setBackground(UIManager.getColor("Button.light"));
		btnUpdate_1.setBounds(37, 525, 114, 41);
		frame.getContentPane().add(btnUpdate_1);
		
		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call the deleteloginDetails in ADD_Login_Model class by passing the parameters
				addlogin.deleteloginDetails(search.getText());
				table_load();
				JOptionPane.showMessageDialog(null, "Login Details Deleted Successfully");
					//clear the text-fields
					username.setText("");
					password.setText("");
					search.setText("");
					//get cursor to the fist text-field
					username.requestFocus();
			
			}
		});
		btnDelete_1.setForeground(Color.BLACK);
		btnDelete_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDelete_1.setBackground(UIManager.getColor("Button.light"));
		btnDelete_1.setBounds(269, 525, 114, 41);
		frame.getContentPane().add(btnDelete_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1_1.setBackground(SystemColor.menu);
		panel_1_1_1.setBounds(50, 424, 307, 53);
		frame.getContentPane().add(panel_1_1_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("User ID");
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
					String lid = search.getText();
					Connection conn = db_connection.connect();
					if (conn == null) {
						System.out.println(" Error while Connecting to the database");
					}
					String query = "select User_Name, Password from `login` where ID = ?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, lid);
					ResultSet rs = pst.executeQuery();
					
					if (rs.next()==true) {
						
						String lusername = rs.getString(1);
						String lpassword = rs.getString(2);
						username.setText(lusername);
						password.setText(lpassword);
					}
					else {
						username.setText("");
						password.setText("");						
					}	
					
					
				}
				catch(SQLException ex) {					
				}		
			}
		});
		search.setColumns(10);
		search.setBounds(118, 13, 179, 35);
		panel_1_1_1.add(search);
		
		password = new JTextField();
		password.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		password.setColumns(10);
		password.setBounds(147, 235, 236, 27);
		frame.getContentPane().add(password);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPassword.setBackground(SystemColor.menu);
		lblPassword.setBounds(23, 231, 114, 31);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("User Name");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBackground(SystemColor.menu);
		lblNewLabel_1_1_1.setBounds(22, 173, 114, 31);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		username = new JTextField();
		username.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		username.setColumns(10);
		username.setBounds(146, 177, 236, 27);
		frame.getContentPane().add(username);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(423, 151, 527, 413);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(SystemColor.activeCaption);
		table.setFont(new Font("Times New Roman", Font.BOLD, 10));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Add_Login.class.getResource("/Images/Untitled design.png")));
		lblNewLabel_2.setBounds(0, 99, 986, 514);
		frame.getContentPane().add(lblNewLabel_2);
	}

	//set method to work for calls from another window
	public void setVisible(boolean b) {
		try {
			Add_Login window = new Add_Login();
			window.frame.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
}
