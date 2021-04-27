import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class vendeur_commande {

	private JFrame frame;
	private JTextField txtdepot;
	private JTextField txtquantite;
	private JTextField txtcout;
	private JTable table;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vendeur_commande window = new vendeur_commande();
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
	public vendeur_commande() {
		initialize();
		Connect();
		table_load();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

 
	 public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud", "root","");
	        }
	        catch (ClassNotFoundException ex) 
	        {
	          
	        }
	        catch (SQLException ex) 
	        {
	        	 
	        }
	    }
	 
	  public void table_load()
	    {
	    	try 
	    	{
		    pst = con.prepareStatement("select * from vendeur_commande");
		    rs = pst.executeQuery();
		    table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
	    	catch (SQLException e) 
	    	 {
	    		e.printStackTrace();
		  } 
	    }
	 
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1206, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("COMMANDE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(552, 10, 229, 79);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(24, 107, 430, 223);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbldepot = new JLabel("Depot");
		lbldepot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbldepot.setBounds(24, 24, 99, 33);
		panel.add(lbldepot);
		
		JLabel lblquantite = new JLabel("Quantite");
		lblquantite.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblquantite.setBounds(24, 67, 99, 33);
		panel.add(lblquantite);
		
		txtdepot = new JTextField();
		txtdepot.setBounds(160, 32, 211, 22);
		panel.add(txtdepot);
		txtdepot.setColumns(10);
		
		txtquantite = new JTextField();
		txtquantite.setColumns(10);
		txtquantite.setBounds(160, 72, 211, 22);
		panel.add(txtquantite);
		
		txtcout = new JTextField();
		txtcout.setColumns(10);
		txtcout.setBounds(160, 113, 211, 22);
		panel.add(txtcout);
		
		JLabel Lblcout = new JLabel("Cout");
		Lblcout.setFont(new Font("Tahoma", Font.BOLD, 14));
		Lblcout.setBounds(24, 105, 99, 33);
		panel.add(Lblcout);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{			
				String depot,quantite,cout;
				depot = txtdepot.getText();
				quantite = txtquantite.getText();
				cout = txtcout.getText();
							
				 try {
					pst = con.prepareStatement("insert into vendeur_commande(depot,quantite,cout)values(?,?,?)");
					pst.setString(1, depot);
					pst.setString(2, quantite);
					pst.setString(3, cout);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added!");
					table_load();
					
						           
					txtdepot.setText("");
					txtquantite.setText("");
					txtcout.setText("");
					txtdepot.requestFocus();
				   }
			 
				catch (SQLException e1) 
			        {
									
				e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(24, 343, 107, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(184, 343, 107, 50);
		frame.getContentPane().add(btnExit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtdepot.setText("");
				txtquantite.setText("");
				txtcout.setText("");
				txtdepot.requestFocus();
			}
		});
		btnClear.setBounds(347, 343, 107, 50);
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(500, 115, 676, 318);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(24, 421, 430, 110);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblBookId = new JLabel("ID");
		lblBookId.setBounds(30, 38, 60, 17);
		lblBookId.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblBookId);
		
		txtid = new JTextField();
		txtid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				 try {
			          
			            String id = txtid.getText();

			                pst = con.prepareStatement("select depot,quantite,cout from vendeur_commande where id = ?");
			                pst.setString(1, id);
			                ResultSet rs = pst.executeQuery();

			            if(rs.next()==true)
			            {
			              
			                String depot = rs.getString(1);
			                String quantite = rs.getString(2);
			                String cout = rs.getString(3);
			                
			                txtdepot.setText(depot);
			                txtquantite.setText(quantite);
			                txtcout.setText(cout);
			                
			            }   
			            else
			            {
			            	txtdepot.setText("");
			            	txtquantite.setText("");
			                txtcout.setText("");
			                 
			            }

			        } 
				
				 catch (SQLException ex) {
			           
			        }
			}
		});
		txtid.setBounds(102, 36, 278, 22);
		txtid.setColumns(10);
		panel_1.add(txtid);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String depot,quantite,cout,id;
				
				depot = txtdepot.getText();
				quantite = txtquantite.getText();
				cout = txtcout.getText();
				id  = txtid.getText();
				
				 try {
						pst = con.prepareStatement("update vendeur_commande set depot= ?,quantite=?,cout=? where id =?");
						pst.setString(1, depot);
			            pst.setString(2, quantite);
			            pst.setString(3, cout);
			            pst.setString(4, id);
			            pst.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Record Updated!");
			            table_load();
			           
			            txtdepot.setText("");
			            txtquantite.setText("");
			            txtcout.setText("");
			            txtdepot.requestFocus();
					}

		            catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnUpdate.setBounds(639, 454, 107, 50);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                String id;
			id  = txtid.getText();
			
			 try {
					pst = con.prepareStatement("delete from vendeur_commande where id =?");
			
		            pst.setString(1, id);
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Record Deleted!");
		            table_load();
		           
		            txtdepot.setText("");
		            txtquantite.setText("");
		            txtcout.setText("");
		            txtdepot.requestFocus();
				}
		
		        catch (SQLException e1) {
					
					e1.printStackTrace();
				}
					}
				});
				btnDelete.setBounds(805, 454, 107, 50);
				frame.getContentPane().add(btnDelete);
			}
}