package Sales_Manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Begin.Login;
import net.proteanit.sql.DbUtils;

import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Add_Sales {

	private JFrame frame;
	private JTextField search;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Sales window = new Add_Sales();
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
	public Add_Sales() {
		initialize();
		Connect ();
		table_load();

	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	
	public void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nova_moters", "root", "");
		}
		catch (ClassNotFoundException ex) {
			
		}
		catch (SQLException ex) {
			
		}
	}
	
	
	public void table_load() {
		try {
			pst = con.prepareStatement("select * from sales");
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
		btnLogOut.setForeground(SystemColor.menu);
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnLogOut.setBackground(new Color(51, 102, 153));
		btnLogOut.setBounds(828, 29, 120, 43);
		panel_1.add(btnLogOut);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Add_Sales.class.getResource("/Images/1.png")));
		lblNewLabel_1.setBounds(36, 0, 107, 98);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setBounds(383, 550, 114, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("Clear");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnReset.setBackground(SystemColor.controlHighlight);
		btnReset.setBounds(540, 550, 114, 41);
		frame.getContentPane().add(btnReset);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnUpdate.setBackground(SystemColor.controlHighlight);
		btnUpdate.setBounds(693, 550, 114, 41);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDelete.setBackground(SystemColor.controlHighlight);
		btnDelete.setBounds(845, 550, 114, 41);
		frame.getContentPane().add(btnDelete);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBackground(SystemColor.menu);
		panel_1_1.setBounds(25, 550, 307, 53);
		frame.getContentPane().add(panel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Sales ID");
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_3.setBackground(SystemColor.controlHighlight);
		lblNewLabel_1_3.setBounds(31, 14, 108, 31);
		panel_1_1.add(lblNewLabel_1_3);
		
		search = new JTextField();
		search.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		search.setColumns(10);
		search.setBounds(118, 13, 179, 35);
		panel_1_1.add(search);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(383, 108, 579, 415);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(SystemColor.activeCaption);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Add_Sales.class.getResource("/Images/Untitled design.png")));
		lblNewLabel.setBounds(0, 97, 986, 516);
		frame.getContentPane().add(lblNewLabel);
	}

	public void setVisible(boolean b) {
		try {
			Add_Sales window = new Add_Sales();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
