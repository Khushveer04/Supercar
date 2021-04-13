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

public class vendeur_client {

	private JFrame frame;
	private JTextField txtnom;
	private JTextField txtprenom;
	private JTextField txtsex;
	private JTextField txtadresse;
	private JTextField txtemail;
	private JTextField txttelephone;
	private JTextField txtnumid; 
	private JTable table;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vendeur_client window = new vendeur_client();
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
	public vendeur_client() {
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
		    pst = con.prepareStatement("select * from vendeur_client");
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
		
		JLabel lblNewLabel = new JLabel("CLIENT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(552, 10, 229, 79);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(24, 107, 430, 223);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblnom = new JLabel("Nom");
		lblnom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblnom.setBounds(24, 13, 99, 33);
		panel.add(lblnom);
		
		JLabel lblprenom = new JLabel("Prenom");
		lblprenom.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblprenom.setBounds(24, 45, 99, 33);
		panel.add(lblprenom);
		
		txtnom = new JTextField();
		txtnom.setBounds(160, 21, 211, 22);
		panel.add(txtnom);
		txtnom.setColumns(10);
		
		txtprenom = new JTextField();
		txtprenom.setColumns(10);
		txtprenom.setBounds(160, 53, 211, 22);
		panel.add(txtprenom);
		
		txtsex = new JTextField();
		txtsex.setColumns(10);
		txtsex.setBounds(160, 85, 211, 22);
		panel.add(txtsex);
		
		JLabel Lblsex = new JLabel("Sex");
		Lblsex.setFont(new Font("Tahoma", Font.BOLD, 14));
		Lblsex.setBounds(24, 77, 99, 33);
		panel.add(Lblsex);
		
		JLabel lbladresse = new JLabel("Adresse");
		lbladresse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbladresse.setBounds(24, 108, 99, 33);
		panel.add(lbladresse);
		
		txtadresse = new JTextField();
		txtadresse.setColumns(10);
		txtadresse.setBounds(160, 117, 211, 22);
		panel.add(txtadresse);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblemail.setBounds(24, 141, 99, 33);
		panel.add(lblemail);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(160, 149, 211, 22);
		panel.add(txtemail);
		
		JLabel lbltelephone = new JLabel("Telephone");
		lbltelephone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbltelephone.setBounds(24, 163, 99, 33);
		panel.add(lbltelephone);
		
		JLabel lblnic = new JLabel("Num id");
		lblnic.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblnic.setBounds(24, 190, 99, 33);
		panel.add(lblnic);
		
		txtnumid = new JTextField();
		txtnumid.setColumns(10);
		txtnumid.setBounds(160, 199, 211, 22);
		panel.add(txtnumid);
		
		txttelephone = new JTextField();
		txttelephone.setColumns(10);
		txttelephone.setBounds(160, 172, 211, 22);
		panel.add(txttelephone);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{			
				String nom,prenom,sex,adresse,email,numero_telephone,num_id;
				nom = txtnom.getText();
				prenom = txtprenom.getText();
				sex = txtsex.getText();
				adresse = txtadresse.getText();
				email = txtemail.getText();
				numero_telephone = txttelephone.getText();
				num_id = txtnumid.getText();
							
				 try {
					pst = con.prepareStatement("insert into vendeur_client(nom,prenom,sex,adresse,email,numero_telephone,num_id)values(?,?,?,?,?,?,?)");
					pst.setString(1, nom);
					pst.setString(2, prenom);
					pst.setString(3, sex);
					pst.setString(4, adresse);
					pst.setString(5, email);
					pst.setString(6, numero_telephone);
					pst.setString(7, num_id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added!");
					table_load();
					
						           
					txtnom.setText("");
					txtprenom.setText("");
					txtsex.setText("");
					txtadresse.setText("");
					txtemail.setText("");
					txttelephone.setText("");
					txtnumid.setText("");
					txtnom.requestFocus();
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
				txtnom.setText("");
				txtprenom.setText("");
				txtsex.setText("");
				txtadresse.setText("");
				txtemail.setText("");
				txttelephone.setText("");
				txtnumid.setText(""); 
				txtnom.requestFocus();
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

			                pst = con.prepareStatement("select nom,prenom,sex,adresse,email,numero_telephone,num_id from vendeur_client where id = ?");
			                pst.setString(1, id);
			                ResultSet rs = pst.executeQuery();

			            if(rs.next()==true)
			            {
			              
			                String nom = rs.getString(1);
			                String prenom = rs.getString(2);
			                String sex = rs.getString(3);
			                String adresse = rs.getString(1);
			                String email = rs.getString(2);
			                String numero_telephone = rs.getString(3);
			                String num_id = rs.getString(3);
			                
			                txtnom.setText(nom);
			                txtprenom.setText(prenom);
			                txtsex.setText(sex);
			                txtadresse.setText(adresse);
			                txtemail.setText(email);
			                txttelephone.setText(numero_telephone);
			                txtnumid.setText(num_id);
			                
			            }   
			            else
			            {
			            	txtnom.setText("");
			            	txtprenom.setText("");
			                txtsex.setText("");
			                txtadresse.setText("");
			            	txtemail.setText("");
			                txttelephone.setText("");
			                txtnumid.setText("");
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
				
				String nom,prenom,sex,adresse,email,numero_telephone,num_id,id;
				
				nom = txtnom.getText();
				prenom = txtprenom.getText();
				sex = txtsex.getText();
				adresse = txtadresse.getText();
				email = txtemail.getText();
				numero_telephone = txttelephone.getText();
				num_id = txtnumid.getText();
				id  = txtid.getText();
				
				 try {
						pst = con.prepareStatement("update vendeur_client set nom= ?,prenom=?,sex=?,adresse= ?,email=?,numero_telephone=?,num_id=? where id =?");
						pst.setString(1, nom);
			            pst.setString(2, prenom);
			            pst.setString(3, sex);
			            pst.setString(4, adresse);
			            pst.setString(5, email);
			            pst.setString(6, numero_telephone);
			            pst.setString(7, num_id);
			            pst.setString(8, id);
			            pst.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Record Updated!");
			            table_load();
			           
			            txtnom.setText("");
			            txtprenom.setText("");
			            txtsex.setText("");
			            txtadresse.setText("");
			            txtemail.setText("");
			            txttelephone.setText("");
			            txtnumid.setText("");
			            txtnom.requestFocus();
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
					pst = con.prepareStatement("delete from vendeur_client where id =?");
			
		            pst.setString(1, id);
		            pst.executeUpdate();
		            JOptionPane.showMessageDialog(null, "Record Deleted!");
		            table_load();
		           
		            txtnom.setText("");
		            txtprenom.setText("");
		            txtsex.setText("");
		            txtadresse.setText("");
		            txtemail.setText("");
		            txttelephone.setText("");
		            txtnumid.setText("");
		            txtnom.requestFocus();
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
