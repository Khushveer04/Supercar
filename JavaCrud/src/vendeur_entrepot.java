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

public class vendeur_entrepot {

	private JFrame frame;
	private JTextField txtnomentrepot;
	private JTextField txtadresse;
	private JTextField txtnbvehicule;
	private JTextField txtnbstaff;
	private JTable table;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vendeur_entrepot window = new vendeur_entrepot();
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
	public vendeur_entrepot() {
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
		    pst = con.prepareStatement("select * from vendeur_entrepot");
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
		
		JLabel lblNewLabel = new JLabel("ENTREPOT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(552, 10, 229, 79);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(24, 107, 430, 223);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblnom_entrepot = new JLabel("Nom Entrepot");
		lblnom_entrepot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblnom_entrepot.setBounds(24, 24, 99, 33);
		panel.add(lblnom_entrepot);
		
		JLabel lbladresse = new JLabel("Adresse");
		lbladresse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbladresse.setBounds(24, 67, 99, 33);
		panel.add(lbladresse);
		
		txtnomentrepot = new JTextField();
		txtnomentrepot.setBounds(160, 32, 211, 22);
		panel.add(txtnomentrepot);
		txtnomentrepot.setColumns(10);
		
		txtadresse = new JTextField();
		txtadresse.setColumns(10);
		txtadresse.setBounds(160, 72, 211, 22);
		panel.add(txtadresse);
		
		txtnbvehicule = new JTextField();
		txtnbvehicule.setColumns(10);
		txtnbvehicule.setBounds(160, 113, 211, 22);
		panel.add(txtnbvehicule);
		
		JLabel Lblnbvehicule = new JLabel("nombre_de_vehicules");
		Lblnbvehicule.setFont(new Font("Tahoma", Font.BOLD, 14));
		Lblnbvehicule.setBounds(24, 105, 99, 33);
		panel.add(Lblnbvehicule);
		
		JLabel lblNombreDeStaff = new JLabel("Nombre de staff");
		lblNombreDeStaff.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreDeStaff.setBounds(24, 145, 99, 33);
		panel.add(lblNombreDeStaff);
		
		txtnbstaff = new JTextField();
		txtnbstaff.setColumns(10);
		txtnbstaff.setBounds(160, 154, 211, 22);
		panel.add(txtnbstaff);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{			
				String nom_entrepot,adresse,nombre_de_vehicules,nombre_staff;
				nom_entrepot = txtnomentrepot.getText();
				adresse = txtadresse.getText();
				nombre_de_vehicules = txtnbvehicule.getText();
				nombre_staff = txtnbstaff.getText();
							
				 try {
					pst = con.prepareStatement("insert into vendeur_entrepot(nom_entrepot,adresse,nombre_de_vehicules,nombre_staff)values(?,?,?,?)");
					pst.setString(1, nom_entrepot);
					pst.setString(2, adresse);
					pst.setString(3, nombre_de_vehicules);
					pst.setString(4, nombre_staff);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added!");
					table_load();
					
						           
					txtnomentrepot.setText("");
					txtadresse.setText("");
					txtnbvehicule.setText("");
					txtnbstaff.setText("");
					txtnomentrepot.requestFocus();
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
				txtnomentrepot.setText("");
				txtadresse.setText("");
				txtnbvehicule.setText("");
				txtnbstaff.setText("");
				txtnomentrepot.requestFocus();
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

			                pst = con.prepareStatement("select nom_entrepot,adresse,nombre_de_vehicules,nombre_staff from vendeur_entrepot where id = ?");
			                pst.setString(1, id);
			                ResultSet rs = pst.executeQuery();

			            if(rs.next()==true)
			            {
			              
			                String nom_entrepot = rs.getString(1);
			                String adresse = rs.getString(2);
			                String nombre_de_vehicules = rs.getString(3);
			                String nombre_staff = rs.getString(4);
			                
			                txtnomentrepot.setText(nom_entrepot);
			                txtadresse.setText(adresse);
			                txtnbvehicule.setText(nombre_de_vehicules);
			                txtnbstaff.setText(nombre_staff);
			                
			            }   
			            else
			            {
			            	txtnomentrepot.setText("");
			            	txtadresse.setText("");
			                txtnbvehicule.setText("");
			                txtnbstaff.setText("");
			                 
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
				
				String nom_entrepot,adresse,nombre_de_vehicules,nombre_staff,id;
				
				nom_entrepot = txtnomentrepot.getText();
				adresse = txtadresse.getText();
				nombre_de_vehicules = txtnbvehicule.getText();
				nombre_staff = txtnbstaff.getText();
				id  = txtid.getText();
				
				 try {
						pst = con.prepareStatement("update vendeur_entrepot set nom_entrepot= ?,adresse=?,nombre_de_vehicules=?,nombre_staff=? where id =?");
						pst.setString(1, nom_entrepot);
			            pst.setString(2, adresse);
			            pst.setString(3, nombre_de_vehicules);
			            pst.setString(4, nombre_staff);
			            pst.setString(5, id);
			            pst.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Record Updated!");
			            table_load();
			           
			            txtnomentrepot.setText("");
			            txtadresse.setText("");
			            txtnbvehicule.setText("");
			            txtnbstaff.setText("");
			            txtnomentrepot.requestFocus();
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
					pst = con.prepareStatement("delete from vendeur_entrepot where id =?");
			
		            pst.setString(1, id);
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Record Deleted!");
		            table_load();
		           
		            txtnomentrepot.setText("");
		            txtadresse.setText("");
		            txtnbvehicule.setText("");
		            txtnbstaff.setText("");
		            txtnomentrepot.requestFocus();
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

