import java.awt.EventQueue;
import java.sql.*;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class vendeur_devis {

	private JFrame frame;
	private JTextField txtmarque;
	private JTextField txtmodele;
	private JTextField txtcouleur;
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1206, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(37, 170, 430, 263);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblmarque = new JLabel("Marque");
		lblmarque.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmarque.setBounds(24, 5, 99, 33);
		panel.add(lblmarque);
		
		JLabel lblmodele = new JLabel("Modele");
		lblmodele.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmodele.setBounds(24, 37, 99, 33);
		panel.add(lblmodele);
		
		txtmarque = new JTextField();
		txtmarque.setBounds(160, 13, 211, 22);
		panel.add(txtmarque);
		txtmarque.setColumns(10);
		
		txtmodele = new JTextField();
		txtmodele.setColumns(10);
		txtmodele.setBounds(160, 45, 211, 22);
		panel.add(txtmodele);
		
		txtcouleur = new JTextField();
		txtcouleur.setColumns(10);
		txtcouleur.setBounds(160, 75, 211, 22);
		panel.add(txtcouleur);
		
		JLabel Lblcouleur = new JLabel("Couleur");
		Lblcouleur.setFont(new Font("Tahoma", Font.BOLD, 14));
		Lblcouleur.setBounds(24, 67, 99, 33);
		panel.add(Lblcouleur);
		
		JLabel lblcarburant = new JLabel("Carburant");
		lblcarburant.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcarburant.setBounds(24, 99, 99, 33);
		panel.add(lblcarburant);
		
		JLabel lbltransmission = new JLabel("Transmission");
		lbltransmission.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbltransmission.setBounds(24, 131, 99, 33);
		panel.add(lbltransmission);
		
		JLabel lbloption_ref = new JLabel("Option");
		lbloption_ref.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbloption_ref.setBounds(24, 163, 99, 33);
		panel.add(lbloption_ref);
		
		JLabel lblpays = new JLabel("Pays");
		lblpays.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblpays.setBounds(24, 191, 99, 33);
		panel.add(lblpays);
		
		txtdevis = new JTextField();
		txtdevis.setColumns(10);
		txtdevis.setBounds(160, 231, 211, 22);
		panel.add(txtdevis);
		
		JLabel lbldevis = new JLabel("Devis");
		lbldevis.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbldevis.setBounds(24, 223, 99, 33);
		panel.add(lbldevis);
		
		JComboBox dropcarbu = new JComboBox();
		dropcarbu.setBounds(160, 107, 211, 21);
		panel.add(dropcarbu);
		
		dropcarbu.addItem("Essence");
		dropcarbu.addItem("Diesel");
		
		JComboBox droptrans = new JComboBox();
		droptrans.setBounds(160, 143, 211, 21);
		panel.add(droptrans);
		droptrans.addItem("Manuel");
		droptrans.addItem("Automatique");
		droptrans.addItem("Septronique");
		
		JComboBox dropoption = new JComboBox();
		dropoption.setBounds(160, 171, 211, 21);
		panel.add(dropoption);
		dropoption.addItem("Full option");
		dropoption.addItem("Basic option");
		
		JComboBox droppays = new JComboBox();
		droppays.setBounds(160, 199, 211, 21);
		panel.add(droppays);
		droppays.addItem("Japon");
		droppays.addItem("Singapore");
		droppays.addItem("Afrique du Sud");
		droppays.addItem("Etat Unis");
		droppays.addItem("Chine");
		droppays.addItem("Allemagne");
		droppays.addItem("Inde");
		droppays.addItem("France");
		droppays.addItem("Coree");
		
		JButton btnNewButton = new JButton("Creation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{			
				String marque,modele,couleur,devis;
				Object carburant,transmission,option_ref,pays;
				marque = txtmarque.getText();
				modele = txtmodele.getText();
				couleur = txtcouleur.getText();
				carburant = dropcarbu.getSelectedItem();
				transmission = droptrans.getSelectedItem();
				option_ref = dropoption.getSelectedItem();
				pays = droppays.getSelectedItem();
				devis = txtdevis.getText();
							
				 try {
					 
					 
					final String COULEUR_REGEX = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
					final Pattern COULEUR_PATTERN = Pattern.compile(COULEUR_REGEX);
					 
					if (COULEUR_PATTERN.matcher(couleur).matches() == false) {
					    JOptionPane.showMessageDialog(null, "L`insertion du couleur n`est pas bon");
					}
					
					if (COULEUR_PATTERN.matcher(couleur).matches()) 
					{
					 
					 
					pst = con.prepareStatement("insert into vendeur_devis(marque,modele,couleur,carburant,transmission,option_ref,pays,devis)values(?,?,?,?,?,?,?,?)");
					pst.setString(1, marque);
					pst.setString(2, modele);
					pst.setString(3, couleur);
					pst.setString(4, (String) carburant);
					pst.setString(5, (String) transmission);
					pst.setString(6, (String) option_ref);
					pst.setString(7, (String) pays);
					pst.setString(8, devis);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added!");
				 }
					table_load();
					
						           
//					txtmarque.setText("");
//					txtmodele.setText("");
//					txtcouleur.setText("");
//					dropcarbu.setSelectedItem("");
//					droptrans.setSelectedItem("");
//					dropoption.setSelectedItem("");
//					droppays.setSelectedItem("");
//					txtdevis.setText("");
//					txtmarque.requestFocus();
				   }
			 
				catch (SQLException e1) 
			        {
									
				e1.printStackTrace();
				}
				
				 	marque = txtmarque.getText();
					modele = txtmodele.getText();
					couleur = txtcouleur.getText();
					carburant = dropcarbu.getSelectedItem();
					transmission = droptrans.getSelectedItem();
					option_ref = dropoption.getSelectedItem();
					pays = droppays.getSelectedItem();
					devis = txtdevis.getText();
					
					JFileChooser dialog = new JFileChooser();
					dialog.setSelectedFile(new File(marque+"_FicheDevis"+".pdf"));
					int dialogResult = dialog.showSaveDialog(null);
					if (dialogResult==JFileChooser.APPROVE_OPTION) {
						String filePath = dialog.getSelectedFile().getPath();
						
						try {
							
							Document myDoc = new Document();
							@SuppressWarnings("unused")
							PdfWriter  myWriter = PdfWriter.getInstance(myDoc, new FileOutputStream(filePath));
							myDoc.open();
							
							
							
							myDoc.add(new Paragraph("FICHE Devis", FontFactory.getFont(FontFactory.TIMES_BOLD,20)));
							
							myDoc.add(new Paragraph(" ", FontFactory.getFont(FontFactory.HELVETICA,20)));
							
							myDoc.add(new Paragraph("Detail du devis", FontFactory.getFont(FontFactory.HELVETICA,15)));
							myDoc.add(new Paragraph("Marque: "+marque+ " ", FontFactory.getFont(FontFactory.HELVETICA,15)));
							myDoc.add(new Paragraph("Modele: "+modele+" ", FontFactory.getFont(FontFactory.HELVETICA,15)));
							myDoc.add(new Paragraph("Couleur: "+couleur+" ", FontFactory.getFont(FontFactory.HELVETICA,15)));
							myDoc.add(new Paragraph("Carburant: "+carburant+" ", FontFactory.getFont(FontFactory.HELVETICA,15)));
							myDoc.add(new Paragraph("Transmission: "+transmission+" ", FontFactory.getFont(FontFactory.HELVETICA,15)));
							myDoc.add(new Paragraph("Option choisi: "+option_ref+" ", FontFactory.getFont(FontFactory.HELVETICA,15)));
							myDoc.add(new Paragraph("Pays: "+pays+" ", FontFactory.getFont(FontFactory.HELVETICA,15)));
							myDoc.add(new Paragraph("devis: "+devis+" ", FontFactory.getFont(FontFactory.HELVETICA,15)));

							myDoc.close();
							JOptionPane.showMessageDialog(null, "PDF Valider");
							
							txtmarque.setText("");
							txtmodele.setText("");
							txtcouleur.setText("");
							dropcarbu.setSelectedItem("");
							droptrans.setSelectedItem("");
							dropoption.setSelectedItem("");
							droppays.setSelectedItem("");
							txtdevis.setText("");
							txtmarque.requestFocus();
						
							
							
						}
							
					catch (FileNotFoundException | DocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					catch(Exception er) {
						JOptionPane.showMessageDialog(null, "Error");
					}
					
				 
			}
		}
		});
		btnNewButton.setBounds(27, 454, 107, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnExit = new JButton("Sortir");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(187, 454, 107, 50);
		frame.getContentPane().add(btnExit);
		
		JButton btnClear = new JButton("Effacer");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtmarque.setText("");
				txtmodele.setText("");
				txtcouleur.setText("");
				dropcarbu.setSelectedItem("");
				droptrans.setSelectedItem("");
				dropoption.setSelectedItem("");
				droppays.setSelectedItem(""); 
				txtdevis.setText(""); 
				txtmarque.requestFocus();
			}
		});
		btnClear.setBounds(347, 454, 107, 50);
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(500, 68, 676, 365);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(37, 59, 430, 110);
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
			                Object carburant = rs.getObject(4);
			                Object transmission = rs.getObject(5);
			                Object option_ref = rs.getObject(6);
			                Object pays = rs.getObject(7);
			                String devis = rs.getString(8);
			                
			                txtmarque.setText(marque);
			                txtmodele.setText(modele);
			                txtcouleur.setText(couleur);
			                dropcarbu.setSelectedItem(carburant);
			                droptrans.setSelectedItem(transmission);
			                dropoption.setSelectedItem(option_ref);
			                droppays.setSelectedItem(pays);
			                txtdevis.setText(devis);
			                
			            }   
			            else
			            {
			            	txtmarque.setText("");
			            	txtmodele.setText("");
			                txtcouleur.setText("");
			                dropcarbu.setSelectedItem("");
			            	droptrans.setSelectedItem("");
			                dropoption.setSelectedItem("");
			                droppays.setSelectedItem("");
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
		
		JButton btnUpdate = new JButton("Mise a jour");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String marque,modele,couleur,devis,id;
				Object carburant, transmission, option_ref,pays;
				
				marque = txtmarque.getText();
				modele = txtmodele.getText();
				couleur = txtcouleur.getText();
				carburant = dropcarbu.getSelectedItem();
				transmission = droptrans.getSelectedItem();
				option_ref = dropoption.getSelectedItem();
				pays = droppays.getSelectedItem();
				devis = txtdevis.getText();
				id  = txtid.getText();
				
				 try {
						pst = con.prepareStatement("update vendeur_devis set marque= ?,modele=?,couleur=?,carburant= ?,transmission=?,option_ref=?,pays=?,devis=? where id =?");
						pst.setString(1, marque);
			            pst.setString(2, modele);
			            pst.setString(3, couleur);
			            pst.setString(4, (String) carburant);
			            pst.setString(5, (String) transmission);
			            pst.setString(6, (String) option_ref);
			            pst.setString(7, (String) pays);
			            pst.setString(8, devis);
			            pst.setString(9, id);
			            pst.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Record Updated!");
			            table_load();
			           
			            txtmarque.setText("");
			            txtmodele.setText("");
			            txtcouleur.setText("");
			            dropcarbu.setSelectedItem("");
			            droptrans.setSelectedItem("");
			            dropoption.setSelectedItem("");
			            droppays.setSelectedItem("");
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
		
		JButton btnDelete = new JButton("Suppression");
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
		            dropcarbu.setSelectedItem("");
		            droptrans.setSelectedItem("");
		            dropoption.setSelectedItem("");
		            droppays.setSelectedItem("");
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
				
				JLabel lblNewLabel = new JLabel("DEVIS");
				lblNewLabel.setBounds(539, -11, 229, 79);
				frame.getContentPane().add(lblNewLabel);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
			}
}
