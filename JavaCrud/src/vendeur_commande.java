import java.awt.EventQueue;
import java.sql.*;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;

public class vendeur_commande {

	private JFrame frame;
	private JTextField txtcapacite;
	private JTable table;
	private JTextField txtid;
	private JLabel lblNoCommande ;
	private JLabel lblNoVente ;
	private JLabel lblNoCommandeEn;
	private JLabel lblTotalCommandeDeja;
	private int count = 0;
	private int count1 = 0;
	private int count2 = 0;
	private int count3 = 0;

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
	 * 
	 * @throws SQLException
	 */
	public vendeur_commande() throws SQLException {
		initialize();
		Connect();
		count_load();
		count_load_termine();
		count_load_encours();
		count_load_commande();
		table_load();
	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtprix;
	private JTextField txtcouleur;
	private JTextField txtquantite;
	private JTextField txtvendeur;
	private JTextField txtdate;

	public void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud", "root", "");
		} catch (ClassNotFoundException ex) {

		} catch (SQLException ex) {

		}
	}

	public void count_load() {
		count = 0;
		try {
		pst = con.prepareStatement("select * from vendeur_commande");
		rs = pst.executeQuery();
	
		 while (rs.next()) {
		count++;
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		lblNoCommande.setText("Total commande : "+count);
		}
	
	
	//nombre de commande termine
	
	public void count_load_termine() {
		count1 = 0;
		try {
		pst = con.prepareStatement("select * from vendeur_commande where statue='Termine'");
		rs = pst.executeQuery();
	
		 while (rs.next()) {
		count1++;
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		lblNoVente.setText("Total vente conclus : "+count1);
		}
	
	//nombre de commande en cours
	
		public void count_load_encours() {
			count2 = 0;
			try {
			pst = con.prepareStatement("select * from vendeur_commande where statue='En cours'");
			rs = pst.executeQuery();
		
			 while (rs.next()) {
			count2++;
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
			lblNoCommandeEn.setText("Total commande en cours : "+count2);
			}
		
		//commande deja passe
		
		public void count_load_commande() {
			count3 = 0;
			try {
			pst = con.prepareStatement("select * from vendeur_commande where statue='commande deja passe'");
			rs = pst.executeQuery();
		
			 while (rs.next()) {
			count3++;
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
			lblTotalCommandeDeja.setText("Total commande deja passe : "+count3);
			}
		
	public void table_load() {
		try {
			pst = con.prepareStatement("select * from vendeur_commande");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
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

	/**
	 * Initialise the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 1554, 820);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("COMMANDE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(755, -18, 229, 79);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(41, 163, 430, 482);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		txtcapacite = new JTextField();
		txtcapacite.setColumns(10);
		txtcapacite.setBounds(160, 89, 211, 22);
		panel.add(txtcapacite);

		JLabel Lblcapacite = new JLabel("Capacite");
		Lblcapacite.setFont(new Font("Tahoma", Font.BOLD, 14));
		Lblcapacite.setBounds(24, 81, 99, 33);
		panel.add(Lblcapacite);

		txtprix = new JTextField();
		txtprix.setColumns(10);
		txtprix.setBounds(160, 313, 211, 22);
		panel.add(txtprix);

		txtcouleur = new JTextField();
		txtcouleur.setColumns(10);
		txtcouleur.setBounds(160, 185, 211, 22);
		panel.add(txtcouleur);

		txtquantite = new JTextField();
		txtquantite.setColumns(10);
		txtquantite.setBounds(160, 281, 211, 22);
		panel.add(txtquantite);

		JLabel lbltransmission = new JLabel("Transmission");
		lbltransmission.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbltransmission.setBounds(24, 113, 99, 33);
		panel.add(lbltransmission);

		JLabel lblcarburant = new JLabel("Carburant");
		lblcarburant.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcarburant.setBounds(24, 145, 99, 33);
		panel.add(lblcarburant);

		JLabel lblpays = new JLabel("Pays");
		lblpays.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblpays.setBounds(24, 241, 99, 33);
		panel.add(lblpays);

		JLabel lbloption = new JLabel("Option");
		lbloption.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbloption.setBounds(24, 209, 99, 33);
		panel.add(lbloption);

		JLabel lblentrepot = new JLabel("Lieu");
		lblentrepot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblentrepot.setBounds(24, 337, 99, 33);
		panel.add(lblentrepot);

		JLabel lblprix = new JLabel("Prix");
		lblprix.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblprix.setBounds(24, 306, 99, 30);
		panel.add(lblprix);

		JLabel lblquantite = new JLabel("Quantite");
		lblquantite.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblquantite.setBounds(24, 273, 99, 33);
		panel.add(lblquantite);

		JLabel lblcouleur = new JLabel("Couleur");
		lblcouleur.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcouleur.setBounds(24, 177, 99, 33);
		panel.add(lblcouleur);

		JLabel lblNomVendeur = new JLabel("Nom vendeur");
		lblNomVendeur.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomVendeur.setBounds(24, 373, 99, 33);
		panel.add(lblNomVendeur);

		JLabel lblstatue = new JLabel("Statue");
		lblstatue.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblstatue.setBounds(24, 404, 99, 33);
		panel.add(lblstatue);

		txtvendeur = new JTextField();
		txtvendeur.setColumns(10);
		txtvendeur.setBounds(160, 380, 211, 22);
		panel.add(txtvendeur);

		@SuppressWarnings("rawtypes")
		JComboBox droplieu = new JComboBox();
		droplieu.setBounds(160, 345, 211, 21);
		panel.add(droplieu);
		droplieu.addItem("");
		droplieu.addItem("Siege Sociale");
		droplieu.addItem("Port Louis");
		droplieu.addItem("Baie du Tombeau");
		droplieu.addItem("Phoenix");
		droplieu.addItem("Plaisance");

		@SuppressWarnings("rawtypes")
		JComboBox droppays = new JComboBox();
		droppays.setBounds(160, 249, 211, 21);
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

		@SuppressWarnings("rawtypes")
		JComboBox dropstatue = new JComboBox();
		dropstatue.setBounds(160, 412, 211, 21);
		panel.add(dropstatue);
		dropstatue.addItem("");
		dropstatue.addItem("Commande deja passe");
		dropstatue.addItem("En cours");
		dropstatue.addItem("Termine");

		@SuppressWarnings("rawtypes")
		JComboBox droptrans = new JComboBox();
		droptrans.setBounds(160, 121, 211, 21);
		panel.add(droptrans);
		droptrans.addItem("");
		droptrans.addItem("Manuel");
		droptrans.addItem("Automatique");
		droptrans.addItem("Septronique");

		@SuppressWarnings("rawtypes")
		JComboBox dropcarbu = new JComboBox();
		dropcarbu.setBounds(160, 153, 211, 21);
		panel.add(dropcarbu);
		dropcarbu.addItem("");
		dropcarbu.addItem("Essence");
		dropcarbu.addItem("Diesel");

		@SuppressWarnings("rawtypes")
		JComboBox dropoption = new JComboBox();
		dropoption.setBounds(160, 217, 211, 21);
		panel.add(dropoption);
		dropoption.addItem("");
		dropoption.addItem("Full option");
		dropoption.addItem("Basic option");
		
		txtdate = new JTextField();
		txtdate.setColumns(10);
		txtdate.setBounds(160, 443, 211, 22);
		panel.add(txtdate);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDate.setBounds(24, 435, 99, 33);
		panel.add(lblDate);
		
		@SuppressWarnings("rawtypes")
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
		dropvoiture.setBounds(160, 58, 211, 21);
		panel.add(dropvoiture);
		dropvoiture.addItem("");
		
		JLabel lblVoiture = new JLabel("Voiture");
		lblVoiture.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVoiture.setBounds(24, 45, 99, 33);
		panel.add(lblVoiture);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String voiture, capacite, couleur, prix, quantite, nom_vendeur, carburant, transmission, option_ref, pays, lieu, statue, date;

				voiture = dropvoiture.getSelectedItem().toString();
				capacite = txtcapacite.getText();
				transmission = droptrans.getSelectedItem().toString();
				carburant = dropcarbu.getSelectedItem().toString();
				couleur = txtcouleur.getText();
				pays = droppays.getSelectedItem().toString();
				option_ref = dropoption.getSelectedItem().toString();
				lieu = droplieu.getSelectedItem().toString();
				prix = txtprix.getText();
				quantite = txtquantite.getText();
				nom_vendeur = txtvendeur.getText();
				statue = dropstatue.getSelectedItem().toString();
				date = txtdate.getText();

				try {
				    
				    final String CAPACITE_REGEX = "^[0-9]{4}$";
				    
				    final Pattern CAPACITE_PATTERN = Pattern.compile(CAPACITE_REGEX);
				    
				    final String COULEUR_REGEX = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
					 
				    final Pattern COULEUR_PATTERN = Pattern.compile(COULEUR_REGEX);
				    
				    final String PRIX_REGEX = "^[0-9]{7}$";
					 
				    final Pattern PRIX_PATTERN = Pattern.compile(PRIX_REGEX);
				    
				    final String QUANTITE_REGEX = "^[0-9]$";
					 
				    final Pattern QUANTITE_PATTERN = Pattern.compile(QUANTITE_REGEX);
				    
				    final String NOM_VENDEUR_REGEX = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
					 
				    final Pattern NOM_VENDEUR_PATTERN = Pattern.compile(NOM_VENDEUR_REGEX);
				    
				    final String DATE_REGEX = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\\\d\\\\d$";
					 
				    final Pattern DATE_PATTERN = Pattern.compile(DATE_REGEX);
				    
				   
				    if (voiture.equals("")) {
				    	JOptionPane.showMessageDialog(null, "L`insertion de la voiture n'est pas bon");
				    }
				    
				    if (CAPACITE_PATTERN.matcher(capacite).matches() == false) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du capacite n`est pas bon");
				    }
				    
				    if (transmission.equals("")) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du transmission n'est pas bon");
				    }
				    
				    if (carburant.equals("")) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du carburant n'est pas bon");
				    }
				    
				    if(COULEUR_PATTERN.matcher(couleur).matches()  == false) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du couleur n`est pas bon");
				    }
				    
				    if (option_ref.equals("")) {
				    	JOptionPane.showMessageDialog(null, "L`insertion de l'option n'est pas bon");
				    }
				    
				    if (pays.equals("")) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du pays n'est pas bon");
				    }
				    
				    if( QUANTITE_PATTERN.matcher(quantite).matches() == false) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du quantite n`est pas bon");
				    }
				    
				    if( PRIX_PATTERN.matcher(prix).matches()  == false) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du prix n`est pas bon");
				    }
				    
				    if (lieu.equals("")) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du lieu n'est pas bon");
				    }
				    
				    if (NOM_VENDEUR_PATTERN.matcher(nom_vendeur).matches() == false) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du nom n`est pas bon");
				    }
				    
				    if (statue.equals("")) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du statue n'est pas bon");
				    }
				    
				    if (DATE_PATTERN.matcher(date).matches() == false) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du date n`est pas bon");
				    }
				    
				   
					
					if (!voiture.equals("") && CAPACITE_PATTERN.matcher(capacite).matches()&&
							COULEUR_PATTERN.matcher(couleur).matches() &&
							PRIX_PATTERN.matcher(prix).matches()&&
							QUANTITE_PATTERN.matcher(quantite).matches() && !transmission.equals("") &&
							!carburant.equals("") && !pays.equals("") && !option_ref.equals("") &&
							!lieu.equals("") && NOM_VENDEUR_PATTERN.matcher(nom_vendeur).matches() && !statue.equals("") && DATE_PATTERN.matcher(date).matches()) 
					{
					
					
					pst = con.prepareStatement("insert into vendeur_commande(voiture,capacite,transmission,carburant,couleur,pays,option_ref,lieu,prix,quantite,nom_vendeur,statue,date)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1, voiture);
					pst.setString(2, capacite);
					pst.setString(3, transmission);
					pst.setString(4, carburant);
					pst.setString(5, couleur);
					pst.setString(6, pays);
					pst.setString(7, option_ref);
					pst.setString(8, lieu);
					pst.setString(9, prix);
					pst.setString(10, quantite);
					pst.setString(11, nom_vendeur);
					pst.setString(12, statue);
					pst.setString(13, date);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added!");
					}
					count_load();
					count_load_termine();
					count_load_encours();
					count_load_commande();
					table_load();
					

					dropvoiture.setSelectedItem("");
					txtcapacite.setText("");
					droptrans.setSelectedItem("");
					dropcarbu.setSelectedItem("");
					txtcouleur.setText("");
					droppays.setSelectedItem("");
					dropoption.setSelectedItem("");
					droplieu.setSelectedItem("");
					txtprix.setText("");
					txtquantite.setText("");
					txtvendeur.setText("");
					dropstatue.setSelectedItem("");
					txtdate.setText("");
					dropvoiture.requestFocus();
				}

				catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(53, 655, 107, 50);
		frame.getContentPane().add(btnNewButton);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(217, 655, 107, 50);
		frame.getContentPane().add(btnExit);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dropvoiture.setSelectedItem("");
				txtcapacite.setText("");
				droptrans.setSelectedItem("");
				dropcarbu.setSelectedItem("");
				txtcouleur.setText("");
				droppays.setSelectedItem("");
				dropoption.setSelectedItem("");
				droplieu.setSelectedItem("");
				txtprix.setText("");
				txtquantite.setText("");
				txtvendeur.setText("");
				dropstatue.setSelectedItem("");
				txtdate.setText("");
				dropvoiture.requestFocus();
			}
		});
		btnClear.setBounds(389, 655, 107, 50);
		frame.getContentPane().add(btnClear);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(500, 51, 1030, 570);
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

					pst = con.prepareStatement("select voiture,capacite,transmission,carburant,couleur,pays,option_ref,lieu,prix,quantite,nom_vendeur,statue,date from vendeur_commande where id = ?");
					pst.setString(1, id);
					ResultSet rs = pst.executeQuery();

					if (rs.next() == true) {

						String voiture = rs.getString(1);
						String capacite = rs.getString(2);
						String transmission = rs.getString(3);
						String carburant = rs.getString(4);
						String couleur = rs.getString(5);
						String pays = rs.getString(6);
						String option_ref = rs.getString(7);
						String lieu = rs.getString(8);
						String prix = rs.getString(9);
						String quantite = rs.getString(10);
						String nom_vendeur = rs.getString(11);
						String statue = rs.getString(12);
						String date = rs.getString(13);

						dropvoiture.setSelectedItem(voiture);
						txtcapacite.setText(capacite);
						droptrans.setSelectedItem(transmission);
						dropcarbu.setSelectedItem(carburant);
						txtcouleur.setText(couleur);
						droppays.setSelectedItem(pays);
						dropoption.setSelectedItem(option_ref);
						droplieu.setSelectedItem(lieu);
						txtprix.setText(prix);
						txtquantite.setText(quantite);
						txtvendeur.setText(nom_vendeur);
						dropstatue.setSelectedItem(statue);
						txtdate.setText(date);
						dropvoiture.requestFocus();

					} else {
						
						dropvoiture.setSelectedItem("");
						txtcapacite.setText("");
						droptrans.setSelectedItem("");
						dropcarbu.setSelectedItem("");
						txtcouleur.setText("");
						droppays.setSelectedItem("");
						dropoption.setSelectedItem("");
						droplieu.setSelectedItem("");
						txtprix.setText("");
						txtquantite.setText("");
						txtvendeur.setText("");
						dropstatue.setSelectedItem("");
						txtdate.setText("");
						dropvoiture.requestFocus();

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

				String voiture, capacite, couleur, prix, quantite, nom_vendeur,id, carburant, transmission, option_ref, pays, lieu, statue, date;

				voiture = dropvoiture.getSelectedItem().toString();
				capacite = txtcapacite.getText();
				transmission = droptrans.getSelectedItem().toString();
				carburant = dropcarbu.getSelectedItem().toString();
				couleur = txtcouleur.getText();
				pays = droppays.getSelectedItem().toString();
				option_ref = dropoption.getSelectedItem().toString();
				lieu = droplieu.getSelectedItem().toString();
				prix = txtprix.getText();
				quantite = txtquantite.getText();
				nom_vendeur = txtvendeur.getText();
				statue = dropstatue.getSelectedItem().toString();
				date = txtdate.getText();
				id  = txtid.getText();

				try {
					pst = con.prepareStatement("update vendeur_commande set voiture=?,capacite= ?,transmission= ?,carburant= ?,couleur= ?,pays= ?,option_ref= ?,lieu= ?,prix= ?,quantite= ?,nom_vendeur= ?,statue= ?, date=? where id =?");
					pst.setString(1, voiture);
					pst.setString(2, capacite);
					pst.setString(3, transmission);
					pst.setString(4, carburant);
					pst.setString(5, couleur);
					pst.setString(6, pays);
					pst.setString(7, option_ref);
					pst.setString(8, lieu);
					pst.setString(9, prix);
					pst.setString(10, quantite);
					pst.setString(11, nom_vendeur);
					pst.setString(12, statue);
					pst.setString(13, date);
					pst.setString(14, id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Updated!");
					table_load();

					dropvoiture.setSelectedItem("");
					txtcapacite.setText("");
					droptrans.setSelectedItem("");
					dropcarbu.setSelectedItem("");
					txtcouleur.setText("");
					droppays.setSelectedItem("");
					dropoption.setSelectedItem("");
					droplieu.setSelectedItem("");
					txtprix.setText("");
					txtquantite.setText("");
					txtvendeur.setText("");
					dropstatue.setSelectedItem("");
					txtdate.setText("");
					dropvoiture.requestFocus();
				}

				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(682, 631, 107, 50);
		frame.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String id;
				id = txtid.getText();

				try {
					pst = con.prepareStatement("delete from vendeur_commande where id =?");

					pst.setString(1, id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Deleted!");
					count_load();
					count_load_termine();
					count_load_encours();
					count_load_commande();
					table_load();

					dropvoiture.setSelectedItem("");
					txtcapacite.setText("");
					droptrans.setSelectedItem("");
					dropcarbu.setSelectedItem("");
					txtcouleur.setText("");
					droppays.setSelectedItem("");
					dropoption.setSelectedItem("");
					droplieu.setSelectedItem("");
					txtprix.setText("");
					txtquantite.setText("");
					txtvendeur.setText("");
					dropstatue.setSelectedItem("");
					txtdate.setText("");
					dropvoiture.requestFocus();
				}

				catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(838, 631, 107, 50);
		frame.getContentPane().add(btnDelete);
		
		lblNoCommande = new JLabel();
		lblNoCommande.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNoCommande.setBounds(1289, 638, 252, 31);
		frame.getContentPane().add(lblNoCommande);
		
		lblNoVente = new JLabel();
		lblNoVente.setText("Total vente :0");
		lblNoVente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNoVente.setBounds(1027, 688, 252, 31);
		frame.getContentPane().add(lblNoVente);
		
		lblNoCommandeEn = new JLabel();
		lblNoCommandeEn.setText("Total commande en cours :0");
		lblNoCommandeEn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNoCommandeEn.setBounds(1027, 638, 252, 31);
		frame.getContentPane().add(lblNoCommandeEn);
		
		lblTotalCommandeDeja = new JLabel();
		lblTotalCommandeDeja.setText("Total commande deja passe :0");
		lblTotalCommandeDeja.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTotalCommandeDeja.setBounds(1027, 662, 252, 31);
		frame.getContentPane().add(lblTotalCommandeDeja);
		
	

	}
}
