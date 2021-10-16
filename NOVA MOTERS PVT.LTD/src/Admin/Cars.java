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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import Begin.Login;
import Model.Car_Model;
import Util.db_connection;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Cars {

	private JFrame frame;
	private JTextField mileage;
	private JTextField fuel;
	private JTextField transmission;
	private JTextField condition;
	private JTextField color;
	private JTextField brand;
	private JTextField model;
	private JTextField carname;
	private JTable table;
	private JTextField search;
	private JTextField price;
	protected int Login;

	db_connection dbConnection = new db_connection();
	Car_Model car = new Car_Model();
	PreparedStatement pst;
	ResultSet rs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cars window = new Cars();
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
	public Cars() {
		initialize();
		table_load();
	}

	

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
		btnLogOut.setForeground(SystemColor.menu);
		btnLogOut.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnLogOut.setBackground(new Color(51, 102, 153));
		btnLogOut.setBounds(828, 29, 120, 43);
		panel_1.add(btnLogOut);
		
		JButton btnAdminHome = new JButton("Admin Home");
		btnAdminHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_Home adhome = new Admin_Home();
				adhome.setVisible(true);
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
		lblNewLabel_1.setIcon(new ImageIcon(Cars.class.getResource("/Images/1.png")));
		lblNewLabel_1.setBounds(10, 0, 107, 98);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Car Name");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBackground(SystemColor.menu);
		lblNewLabel_1_1.setBounds(10, 123, 114, 31);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("Car Model");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBackground(SystemColor.menu);
		lblNewLabel.setBounds(10, 171, 114, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblCarBrand = new JLabel("Car Brand");
		lblCarBrand.setForeground(Color.BLACK);
		lblCarBrand.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCarBrand.setBackground(SystemColor.menu);
		lblCarBrand.setBounds(10, 218, 114, 31);
		frame.getContentPane().add(lblCarBrand);
		
		JLabel lblNewLabel_3 = new JLabel("Color");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBackground(SystemColor.menu);
		lblNewLabel_3.setBounds(10, 266, 114, 31);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Condition");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_4.setBackground(SystemColor.menu);
		lblNewLabel_4.setBounds(10, 312, 114, 31);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Transmission");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_5.setBackground(SystemColor.menu);
		lblNewLabel_5.setBounds(10, 361, 136, 31);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Fuel Type");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6.setBackground(SystemColor.menu);
		lblNewLabel_6.setBounds(10, 409, 114, 31);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Mileage");
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_7.setBackground(SystemColor.menu);
		lblNewLabel_7.setBounds(10, 455, 114, 31);
		frame.getContentPane().add(lblNewLabel_7);
		
		mileage = new JTextField();
		mileage.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		mileage.setColumns(10);
		mileage.setBounds(134, 459, 236, 27);
		frame.getContentPane().add(mileage);
		
		fuel = new JTextField();
		fuel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		fuel.setColumns(10);
		fuel.setBounds(134, 413, 236, 27);
		frame.getContentPane().add(fuel);
		
		transmission = new JTextField();
		transmission.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		transmission.setColumns(10);
		transmission.setBounds(134, 365, 236, 27);
		frame.getContentPane().add(transmission);
		
		condition = new JTextField();
		condition.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		condition.setColumns(10);
		condition.setBounds(134, 316, 236, 27);
		frame.getContentPane().add(condition);
		
		color = new JTextField();
		color.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		color.setColumns(10);
		color.setBounds(134, 270, 236, 27);
		frame.getContentPane().add(color);
		
		brand = new JTextField();
		brand.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		brand.setColumns(10);
		brand.setBounds(134, 222, 236, 27);
		frame.getContentPane().add(brand);
		
		model = new JTextField();
		model.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		model.setColumns(10);
		model.setBounds(134, 175, 236, 27);
		frame.getContentPane().add(model);
		
		carname = new JTextField();
		carname.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		carname.setColumns(10);
		carname.setBounds(134, 127, 236, 27);
		frame.getContentPane().add(carname);
		
		JButton btnNewButton = new JButton("Add car");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//call the insertcarDetails in Car_Model class by passing the parameters
				car.insertcarDetails(carname.getText(), model.getText(), brand.getText(), color.getText(), condition.getText(),
						 transmission.getText(), fuel.getText(), mileage.getText(), price.getText());
				//load the table with inserted details
				table_load();
				//show a pop-up message
				JOptionPane.showMessageDialog(null, "Details Saved Successfully");
				//clear the text-fields
					carname.setText("");
					model.setText("");
					brand.setText("");
					color.setText("");
					condition.setText("");
					transmission.setText("");
					fuel.setText("");
					mileage.setText("");
					price.setText("");
					carname.requestFocus();
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBackground(UIManager.getColor("Button.light"));
		btnNewButton.setBounds(389, 550, 114, 41);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("Clear");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carname.setText("");
				model.setText("");
				brand.setText("");
				color.setText("");
				condition.setText("");
				transmission.setText("");
				fuel.setText("");
				mileage.setText("");
				price.setText("");
				search.setText("");
				carname.requestFocus();
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
				
				//call the updatecarDetails in Car_Model class by passing the parameters
				car.updatecarDetails(carname.getText(), model.getText(), brand.getText(), color.getText(), condition.getText(),
						 transmission.getText(), fuel.getText(), mileage.getText(), price.getText(), search.getText());
				//load the table with inserted details
				table_load();
				//show a pop-up message
					JOptionPane.showMessageDialog(null, "Details Updated Successfully");
				//clear the text-fields	
					carname.setText("");
					model.setText("");
					brand.setText("");
					color.setText("");
					condition.setText("");
					transmission.setText("");
					fuel.setText("");
					mileage.setText("");
					price.setText("");
					search.setText("");
					carname.requestFocus();

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
				//call the updatecarDetails in Car_Model class by passing the parameters
				car.deletecarDetails(search.getText());
				//load the table with inserted details
				table_load();
				//show a pop-up message
					JOptionPane.showMessageDialog(null, "Details Deleted Successfully");
					
					carname.setText("");
					model.setText("");
					brand.setText("");
					color.setText("");
					condition.setText("");
					transmission.setText("");
					fuel.setText("");
					mileage.setText("");
					price.setText("");
					search.setText("");
					carname.requestFocus();
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDelete.setBackground(UIManager.getColor("Button.light"));
		btnDelete.setBounds(851, 550, 114, 41);
		frame.getContentPane().add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(380, 123, 596, 398);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setBackground(SystemColor.activeCaption);
		table.setFont(new Font("Times New Roman", Font.BOLD, 10));
		scrollPane.setViewportView(table);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(SystemColor.menu);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(31, 550, 307, 53);
		frame.getContentPane().add(panel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Car ID");
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setBackground(UIManager.getColor("Button.light"));
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(31, 14, 108, 31);
		panel_1_1.add(lblNewLabel_1_3);
		
		search = new JTextField();
		search.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String cid = search.getText();
					Connection conn = db_connection.connect();
					if (conn == null) {
						System.out.println(" Error while Connecting to the database");
					}
					String query =  "select `Car_Name`, `Car_Model`, `Car_Brand`, `Color`, `Condition`, `Transmission`, `Fuel_Type`, `Mileage`, `Price` from `cars` where Car_ID = ?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, cid);
					ResultSet rs = pst.executeQuery();
					
					if (rs.next()==true) {
						String cname = rs.getString(1);
						String cmodel = rs.getString(2);
						String cbrand = rs.getString(3);
						String ccolor = rs.getString(4);
						String ccondition = rs.getString(5);
						String ctransmistion = rs.getString(6);
						String cfuel = rs.getString(7);
						String cmileage = rs.getString(8);
						String cprice = rs.getString(9);
						
						carname.setText(cname);
						model.setText(cmodel);
						brand.setText(cbrand);
						color.setText(ccolor);
						condition.setText(ccondition);
						transmission.setText(ctransmistion);
						fuel.setText(cfuel);
						mileage.setText(cmileage);
						price.setText(cprice);
	
					}
					
					else {
						carname.setText("");
						model.setText("");
						brand.setText("");
						color.setText("");
						condition.setText("");
						transmission.setText("");
						fuel.setText("");
						mileage.setText("");
						price.setText("");
					}
					
				}
				catch(SQLException ex) {
					
				}
			}
		});
		search.setColumns(10);
		search.setBounds(118, 13, 179, 35);
		panel_1_1.add(search);
		
		JLabel lblNewLabel_7_1 = new JLabel("Price");
		lblNewLabel_7_1.setForeground(Color.BLACK);
		lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_7_1.setBackground(SystemColor.menu);
		lblNewLabel_7_1.setBounds(10, 505, 114, 31);
		frame.getContentPane().add(lblNewLabel_7_1);
		
		price = new JTextField();
		price.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		price.setColumns(10);
		price.setBounds(134, 509, 236, 27);
		frame.getContentPane().add(price);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Cars.class.getResource("/Images/Untitled design.png")));
		lblNewLabel_2.setBounds(0, 96, 986, 517);
		frame.getContentPane().add(lblNewLabel_2);
	}

	public void setVisible(boolean b) {
		try {
			Cars window = new Cars();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
