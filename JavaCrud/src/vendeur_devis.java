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

public class vendeur_devis {

	private JFrame frame;
	private JTextField txtmarque;
	private JTextField txtmodele;
	private JTextField txtcouleur;
	private JTextField txtcarburant;
	private JTextField txttransmission;
	private JTextField txtoption;
	private JTextField txtpays; 
	private JTable table;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vendeur_devis window = new vendeur_devis();
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
	public vendeur_devis() {
		initialize();
		Connect();
		table_load();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtdevis;
 
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
		    pst = con.prepareStatement("select * from vendeur_devis");
		    rs = pst.executeQuery();
		    table.setModel(DbUtils.resultSetToTableModel(rs));
		} 
	    	catch (SQLException e) 
	    	 {
	    		e.printStackTrace();
		  } 
	    }
	 
	

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1206, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DEVIS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(552, 10, 229, 79);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(24, 107, 430, 223);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblmarque = new JLabel("Marque");
		lblmarque.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmarque.setBounds(24, 5, 99, 33);
		panel.add(lblmarque);
		
		JLabel lblmodele = new JLabel("Modele");
		lblmodele.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmodele.setBounds(34, 26, 99, 33);
		panel.add(lblmodele);
		
		txtmarque = new JTextField();
		txtmarque.setBounds(160, 13, 211, 22);
		panel.add(txtmarque);
		txtmarque.setColumns(10);
		
		txtmodele = new JTextField();
		txtmodele.setColumns(10);
		txtmodele.setBounds(160, 34, 211, 22);
		panel.add(txtmodele);
		
		txtcouleur = new JTextField();
		txtcouleur.setColumns(10);
		txtcouleur.setBounds(160, 66, 211, 22);
		panel.add(txtcouleur);
		
		JLabel Lblcouleur = new JLabel("Couleur");
		Lblcouleur.setFont(new Font("Tahoma", Font.BOLD, 14));
		Lblcouleur.setBounds(24, 58, 99, 33);
		panel.add(Lblcouleur);
		
		JLabel lblcarburant = new JLabel("Carburant");
		lblcarburant.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcarburant.setBounds(24, 90, 99, 33);
		panel.add(lblcarburant);
		
		txtcarburant = new JTextField();
		txtcarburant.setColumns(10);
		txtcarburant.setBounds(160, 98, 211, 22);
		panel.add(txtcarburant);
		
		JLabel lbltransmission = new JLabel("Transmission");
		lbltransmission.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbltransmission.setBounds(24, 110, 99, 33);
		panel.add(lbltransmission);
		
		txttransmission = new JTextField();
		txttransmission.setColumns(10);
		txttransmission.setBounds(160, 118, 211, 22);
		panel.add(txttransmission);
		
		JLabel lbloption_ref = new JLabel("Option");
		lbloption_ref.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbloption_ref.setBounds(24, 142, 99, 33);
		panel.add(lbloption_ref);
		
		JLabel lblpays = new JLabel("Pays");
		lblpays.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblpays.setBounds(34, 163, 99, 33);
		panel.add(lblpays);
		
		txtpays = new JTextField();
		txtpays.setColumns(10);
		txtpays.setBounds(160, 171, 211, 22);
		panel.add(txtpays);
		
		txtoption = new JTextField();
		txtoption.setColumns(10);
		txtoption.setBounds(160, 150, 211, 22);
		panel.add(txtoption);
		
		txtdevis = new JTextField();
		txtdevis.setColumns(10);
		txtdevis.setBounds(160, 191, 211, 22);
		panel.add(txtdevis);
		
		JLabel lbldevis = new JLabel("Devis");
		lbldevis.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbldevis.setBounds(24, 185, 99, 33);
		panel.add(lbldevis);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{			
				String marque,modele,couleur,carburant,transmission,option_ref,pays,devis;
				marque = txtmarque.getText();
				modele = txtmodele.getText();
				couleur = txtcouleur.getText();
				carburant = txtcarburant.getText();
				transmission = txttransmission.getText();
				option_ref = txtoption.getText();
				pays = txtpays.getText();
				devis = txtdevis.getText();
							
				 try {
					pst = con.prepareStatement("insert into vendeur_devis(marque,modele,couleur,carburant,transmission,option_ref,pays,devis)values(?,?,?,?,?,?,?,?)");
					pst.setString(1, marque);
					pst.setString(2, modele);
					pst.setString(3, couleur);
					pst.setString(4, carburant);
					pst.setString(5, transmission);
					pst.setString(6, option_ref);
					pst.setString(7, pays);
					pst.setString(8, devis);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added!");
					table_load();
					
						           
					txtmarque.setText("");
					txtmodele.setText("");
					txtcouleur.setText("");
					txtcarburant.setText("");
					txttransmission.setText("");
					txtoption.setText("");
					txtpays.setText("");
					txtdevis.setText("");
					txtmarque.requestFocus();
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
				txtmarque.setText("");
				txtmodele.setText("");
				txtcouleur.setText("");
				txtcarburant.setText("");
				txttransmission.setText("");
				txtoption.setText("");
				txtpays.setText(""); 
				txtdevis.setText(""); 
				txtmarque.requestFocus();
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

			                pst = con.prepareStatement("select marque,modele,couleur,carburant,transmission,option_ref,pays,devis from vendeur_devis where id = ?");
			                pst.setString(1, id);
			                ResultSet rs = pst.executeQuery();

			            if(rs.next()==true)
			            {
			              
			                String marque = rs.getString(1);
			                String modele = rs.getString(2);
			                String couleur = rs.getString(3);
			                String carburant = rs.getString(4);
			                String transmission = rs.getString(5);
			                String option_ref = rs.getString(6);
			                String pays = rs.getString(7);
			                String devis = rs.getString(8);
			                
			                txtmarque.setText(marque);
			                txtmodele.setText(modele);
			                txtcouleur.setText(couleur);
			                txtcarburant.setText(carburant);
			                txttransmission.setText(transmission);
			                txtoption.setText(option_ref);
			                txtpays.setText(pays);
			                txtdevis.setText(devis);
			                
			            }   
			            else
			            {
			            	txtmarque.setText("");
			            	txtmodele.setText("");
			                txtcouleur.setText("");
			                txtcarburant.setText("");
			            	txttransmission.setText("");
			                txtoption.setText("");
			                txtpays.setText("");
			                txtdevis.setText("");
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
				
				String marque,modele,couleur,carburant,transmission,option_ref,pays,devis,id;
				
				marque = txtmarque.getText();
				modele = txtmodele.getText();
				couleur = txtcouleur.getText();
				carburant = txtcarburant.getText();
				transmission = txttransmission.getText();
				option_ref = txtoption.getText();
				pays = txtpays.getText();
				devis = txtdevis.getText();
				id  = txtid.getText();
				
				 try {
						pst = con.prepareStatement("update vendeur_devis set marque= ?,modele=?,couleur=?,carburant= ?,transmission=?,option_ref=?,pays=?,devis=? where id =?");
						pst.setString(1, marque);
			            pst.setString(2, modele);
			            pst.setString(3, couleur);
			            pst.setString(4, carburant);
			            pst.setString(5, transmission);
			            pst.setString(6, option_ref);
			            pst.setString(7, pays);
			            pst.setString(8, devis);
			            pst.setString(9, id);
			            pst.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Record Updated!");
			            table_load();
			           
			            txtmarque.setText("");
			            txtmodele.setText("");
			            txtcouleur.setText("");
			            txtcarburant.setText("");
			            txttransmission.setText("");
			            txtoption.setText("");
			            txtpays.setText("");
			            txtdevis.setText("");
			            txtmarque.requestFocus();
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
					pst = con.prepareStatement("delete from vendeur_devis where id =?");
			
		            pst.setString(1, id);
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Record Deleted!");
		            table_load();
		           
		            txtmarque.setText("");
		            txtmodele.setText("");
		            txtcouleur.setText("");
		            txtcarburant.setText("");
		            txttransmission.setText("");
		            txtoption.setText("");
		            txtpays.setText("");
		            txtdevis.setText("");
		            txtmarque.requestFocus();
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
