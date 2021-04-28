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
import javax.swing.DefaultComboBoxModel;
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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class vendeur_devis {

	private JFrame frame;
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
	  
	  @SuppressWarnings({ "rawtypes", "unchecked" })
	  public JComboBox Test(JComboBox jc) throws SQLException {
	  DefaultComboBoxModel theModel = (DefaultComboBoxModel) jc.getModel();
	  PreparedStatement pst = con.prepareStatement("Select marque,modele from voitures");
	  ResultSet rs = pst.executeQuery();
	  theModel.removeAllElements();
	  // theModel.addElement("");
	  while (rs.next()) {
	  theModel.addElement(rs.getString("marque") + " " + rs.getString("modele"));
	  }
	  jc.setModel(theModel);
	  return jc;
	  }
	  
	  @SuppressWarnings({ "rawtypes", "unchecked" })
		public JComboBox Test2(JComboBox jc) throws SQLException {
		DefaultComboBoxModel theModel = (DefaultComboBoxModel) jc.getModel();
		PreparedStatement pst = con.prepareStatement("Select couleur from voitures");
		ResultSet rs = pst.executeQuery();
		theModel.removeAllElements();
		// theModel.addElement("");
		while (rs.next()) {
		theModel.addElement(rs.getString("couleur"));
		}
		jc.setModel(theModel);
		return jc;
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
		
		JLabel lblmarque = new JLabel("Voiture");
		lblmarque.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmarque.setBounds(24, 36, 99, 33);
		panel.add(lblmarque);
		
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
		dropcarbu.addItem("");
		dropcarbu.addItem("Essence");
		dropcarbu.addItem("Diesel");
		
		JComboBox droptrans = new JComboBox();
		droptrans.setBounds(160, 143, 211, 21);
		panel.add(droptrans);
		droptrans.addItem("");
		droptrans.addItem("Manuel");
		droptrans.addItem("Automatique");
		droptrans.addItem("Septronique");
		
		JComboBox dropoption = new JComboBox();
		dropoption.setBounds(160, 171, 211, 21);
		panel.add(dropoption);
		dropoption.addItem("");
		dropoption.addItem("Full option");
		dropoption.addItem("Basic option");
		
		JComboBox droppays = new JComboBox();
		droppays.setBounds(160, 199, 211, 21);
		panel.add(droppays);
		droppays.addItem("");
		droppays.addItem("Japon");
		droppays.addItem("Singapore");
		droppays.addItem("Afrique du Sud");
		droppays.addItem("Etat Unis");
		droppays.addItem("Chine");
		droppays.addItem("Allemagne");
		droppays.addItem("Inde");
		droppays.addItem("France");
		droppays.addItem("Coree");
		
		
		
		
		JComboBox dropcouleur = new JComboBox();
		dropcouleur.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			try {
			Test2(dropcouleur);
			} catch (SQLException e) {
			e.printStackTrace();
			}
			}
			});
		dropcouleur.setBounds(160, 75, 211, 21);
		panel.add(dropcouleur);
		
		JComboBox dropvoiture = new JComboBox();
		dropvoiture.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent arg0) {
		try {
		Test(dropvoiture);
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
		});
		dropvoiture.setBounds(160, 44, 211, 21);
		panel.add(dropvoiture);
		
		
		JButton btnNewButton = new JButton("Creation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{			
				String voiture,couleur,devis,carburant,transmission,option_ref,pays;
				voiture = dropvoiture.getSelectedItem().toString();
				couleur = dropcouleur.getSelectedItem().toString();
				carburant = dropcarbu.getSelectedItem().toString();
				transmission = droptrans.getSelectedItem().toString();
				option_ref = dropoption.getSelectedItem().toString();
				pays = droppays.getSelectedItem().toString();
				devis = txtdevis.getText();
							
				 try {
					 
					 
					final String COULEUR_REGEX = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
					final Pattern COULEUR_PATTERN = Pattern.compile(COULEUR_REGEX);
					 
					if (COULEUR_PATTERN.matcher(couleur).matches() == false) {
					    JOptionPane.showMessageDialog(null, "L`insertion du couleur n`est pas bon");
					}
					
					if (COULEUR_PATTERN.matcher(couleur).matches() && !carburant.equals("") && !transmission.equals("") && !option_ref.equals("") && !pays.equals("")) 
					{
					 
					 
					pst = con.prepareStatement("insert into vendeur_devis(voiture,couleur,carburant,transmission,option_ref,pays,devis)values(?,?,?,?,?,?,?)");
					pst.setString(1, voiture);
					pst.setString(2, couleur);
					pst.setString(3, carburant);
					pst.setString(4, transmission);
					pst.setString(5, option_ref);
					pst.setString(6, pays);
					pst.setString(7, devis);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added!");
				 }
					table_load();
					
						           
					dropvoiture.setSelectedItem("");
					dropcouleur.setSelectedItem("");
					dropcarbu.setSelectedItem("");
					droptrans.setSelectedItem("");
					dropoption.setSelectedItem("");
					droppays.setSelectedItem("");
					txtdevis.setText("");
					dropvoiture.requestFocus();
				   }
			 
				catch (SQLException e1) 
			        {
									
				e1.printStackTrace();
				}
				
				 	voiture = dropvoiture.getSelectedItem().toString();
				 	couleur = dropcouleur.getSelectedItem().toString();
					carburant = dropcarbu.getSelectedItem().toString();
					transmission = droptrans.getSelectedItem().toString();
					option_ref = dropoption.getSelectedItem().toString();
					pays = droppays.getSelectedItem().toString();
					devis = txtdevis.getText();
					
					JFileChooser dialog = new JFileChooser();
					dialog.setSelectedFile(new File(voiture+"_FicheDevis"+".pdf"));
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
							myDoc.add(new Paragraph("Marque et modele: "+voiture+ " ", FontFactory.getFont(FontFactory.HELVETICA,15)));
							myDoc.add(new Paragraph("Couleur: "+couleur+" ", FontFactory.getFont(FontFactory.HELVETICA,15)));
							myDoc.add(new Paragraph("Carburant: "+carburant+" ", FontFactory.getFont(FontFactory.HELVETICA,15)));
							myDoc.add(new Paragraph("Transmission: "+transmission+" ", FontFactory.getFont(FontFactory.HELVETICA,15)));
							myDoc.add(new Paragraph("Option choisi: "+option_ref+" ", FontFactory.getFont(FontFactory.HELVETICA,15)));
							myDoc.add(new Paragraph("Pays: "+pays+" ", FontFactory.getFont(FontFactory.HELVETICA,15)));
							myDoc.add(new Paragraph("devis: "+devis+" ", FontFactory.getFont(FontFactory.HELVETICA,15)));

							myDoc.close();
							JOptionPane.showMessageDialog(null, "PDF Valider");
							
							dropvoiture.setSelectedItem("");
							dropcouleur.setSelectedItem("");
							dropcarbu.setSelectedItem("");
							droptrans.setSelectedItem("");
							dropoption.setSelectedItem("");
							droppays.setSelectedItem("");
							txtdevis.setText("");
							dropvoiture.requestFocus();
						
							
							
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
				dropvoiture.setSelectedItem("");
				dropcouleur.setSelectedItem("");
				dropcarbu.setSelectedItem("");
				droptrans.setSelectedItem("");
				dropoption.setSelectedItem("");
				droppays.setSelectedItem(""); 
				txtdevis.setText(""); 
				dropvoiture.requestFocus();
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

			                pst = con.prepareStatement("select voiture,couleur,carburant,transmission,option_ref,pays,devis from vendeur_devis where id = ?");
			                pst.setString(1, id);
			                ResultSet rs = pst.executeQuery();

			            if(rs.next()==true)
			            {
			              
			            	String voiture = rs.getString(1);
			                String couleur = rs.getString(2);
			                String carburant = rs.getString(3);
			                String transmission = rs.getString(4);
			                String option_ref = rs.getString(5);
			                String pays = rs.getString(6);
			                String devis = rs.getString(7);
			                
			                dropvoiture.setSelectedItem(voiture);
			                dropcouleur.setSelectedItem(couleur);
			                dropcarbu.setSelectedItem(carburant);
			                droptrans.setSelectedItem(transmission);
			                dropoption.setSelectedItem(option_ref);
			                droppays.setSelectedItem(pays);
			                txtdevis.setText(devis);
			                
			            }   
			            else
			            {
			            	dropvoiture.setSelectedItem("");
			            	dropcouleur.setSelectedItem("");
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
				
				String voiture,couleur,devis,id, carburant, transmission, option_ref,pays;
				
				voiture = dropvoiture.getSelectedItem().toString();
				couleur = dropcouleur.getSelectedItem().toString();
				carburant = dropcarbu.getSelectedItem().toString();
				transmission = droptrans.getSelectedItem().toString();
				option_ref = dropoption.getSelectedItem().toString();
				pays = droppays.getSelectedItem().toString();
				devis = txtdevis.getText();
				id  = txtid.getText();
				
				 try {
						pst = con.prepareStatement("update vendeur_devis set voiture= ?,couleur=?,carburant= ?,transmission=?,option_ref=?,pays=?,devis=? where id =?");
						pst.setString(1, voiture);
			            pst.setString(2, couleur);
			            pst.setString(3, carburant);
			            pst.setString(4, transmission);
			            pst.setString(5, option_ref);
			            pst.setString(6, pays);
			            pst.setString(7, devis);
			            pst.setString(8, id);
			            pst.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Record Updated!");
			            table_load();
			           
			            dropvoiture.setSelectedItem("");
			            dropcouleur.setSelectedItem("");
			            dropcarbu.setSelectedItem("");
			            droptrans.setSelectedItem("");
			            dropoption.setSelectedItem("");
			            droppays.setSelectedItem("");
			            txtdevis.setText("");
			            dropvoiture.requestFocus();
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
		           
		            dropvoiture.setSelectedItem("");
		            dropcouleur.setSelectedItem("");
		            dropcarbu.setSelectedItem("");
		            droptrans.setSelectedItem("");
		            dropoption.setSelectedItem("");
		            droppays.setSelectedItem("");
		            txtdevis.setText("");
		            dropvoiture.requestFocus();
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
