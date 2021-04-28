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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

 
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
		lblNewLabel.setBounds(544, -14, 229, 79);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(41, 163, 430, 292);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblmarque = new JLabel("Marque");
		lblmarque.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmarque.setBounds(24, 8, 99, 33);
		panel.add(lblmarque);
		
		JLabel lblquantite = new JLabel("Modele");
		lblquantite.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblquantite.setBounds(24, 43, 99, 33);
		panel.add(lblquantite);
		
		txtdepot = new JTextField();
		txtdepot.setBounds(160, 16, 211, 22);
		panel.add(txtdepot);
		txtdepot.setColumns(10);
		
		txtquantite = new JTextField();
		txtquantite.setColumns(10);
		txtquantite.setBounds(160, 51, 211, 22);
		panel.add(txtquantite);
		
		txtcout = new JTextField();
		txtcout.setColumns(10);
		txtcout.setBounds(160, 77, 211, 22);
		panel.add(txtcout);
		
		JLabel Lblcout = new JLabel("Capacite");
		Lblcout.setFont(new Font("Tahoma", Font.BOLD, 14));
		Lblcout.setBounds(24, 69, 99, 33);
		panel.add(Lblcout);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(160, 101, 211, 22);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(160, 123, 211, 22);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(160, 146, 211, 22);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(160, 167, 211, 22);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(160, 188, 211, 22);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(160, 208, 211, 22);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(160, 227, 211, 22);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(160, 249, 211, 22);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(160, 270, 211, 22);
		panel.add(textField_8);
		
		JLabel lblTransmission = new JLabel("Transmission");
		lblTransmission.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTransmission.setBounds(10, 86, 99, 33);
		panel.add(lblTransmission);
		
		JLabel lblCarburant = new JLabel("Carburant");
		lblCarburant.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCarburant.setBounds(10, 112, 99, 33);
		panel.add(lblCarburant);
		
		JLabel lblPays = new JLabel("Pays");
		lblPays.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPays.setBounds(10, 150, 99, 33);
		panel.add(lblPays);
		
		JLabel lblOption = new JLabel("Option");
		lblOption.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOption.setBounds(10, 171, 99, 33);
		panel.add(lblOption);
		
		JLabel lblEntrepot = new JLabel("Entrepot");
		lblEntrepot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEntrepot.setBounds(10, 192, 99, 33);
		panel.add(lblEntrepot);
		
		JLabel lblPrix = new JLabel("Prix");
		lblPrix.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrix.setBounds(10, 212, 99, 33);
		panel.add(lblPrix);
		
		JLabel lblQuantite = new JLabel("Quantite");
		lblQuantite.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantite.setBounds(10, 231, 99, 33);
		panel.add(lblQuantite);
		
		JLabel lblCouleur = new JLabel("Couleur");
		lblCouleur.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCouleur.setBounds(10, 127, 99, 33);
		panel.add(lblCouleur);
		
		JLabel lblNomVendeur = new JLabel("Nom vendeur");
		lblNomVendeur.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomVendeur.setBounds(10, 253, 99, 33);
		panel.add(lblNomVendeur);
		
		JLabel lblStatue = new JLabel("Statue");
		lblStatue.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatue.setBounds(78, 259, 99, 33);
		panel.add(lblStatue);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(160, 30, 211, 22);
		panel.add(textField_9);
		
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
		btnNewButton.setBounds(63, 454, 107, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(220, 454, 107, 50);
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
		btnClear.setBounds(383, 454, 107, 50);
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(500, 51, 676, 382);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(41, 51, 430, 110);
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