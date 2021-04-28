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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

public class vendeur_commande {

	private JFrame frame;
	private JTextField txtmarque;
	private JTextField txtmodele;
	private JTextField txtcapacite;
	private JTable table;
	private JTextField txtid;
	private JLabel lblNoCommande ;
	private int count = 0;

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
		table_load();
	}

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtprix;
	private JTextField txtcouleur;
	private JTextField txtquantite;
	private JTextField txtvendeur;

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
		lblNoCommande.setText("No Commande :"+count);;
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

	/**
	 * Initialise the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 1561, 739);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("COMMANDE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(755, -18, 229, 79);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(41, 163, 430, 458);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblmarque = new JLabel("Marque");
		lblmarque.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmarque.setBounds(24, 17, 99, 33);
		panel.add(lblmarque);

		JLabel lblmodele = new JLabel("Modele");
		lblmodele.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmodele.setBounds(24, 49, 99, 33);
		panel.add(lblmodele);

		txtmarque = new JTextField();
		txtmarque.setBounds(160, 25, 211, 22);
		panel.add(txtmarque);
		txtmarque.setColumns(10);

		txtmodele = new JTextField();
		txtmodele.setColumns(10);
		txtmodele.setBounds(160, 57, 211, 22);
		panel.add(txtmodele);

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
		dropstatue.addItem("En attente");
		dropstatue.addItem("Commande deja passe");
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

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String marque, modele, capacite, couleur, prix, quantite, nom_vendeur, carburant, transmission, option_ref, pays, lieu, statue;
				marque = txtmarque.getText();
				modele = txtmodele.getText();
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

				try {
				    
				    final String CAPACITE_REGEX = "^[0-9]$";
				    
				    final Pattern CAPACITE_PATTERN = Pattern.compile(CAPACITE_REGEX);
				    
				    final String COULEUR_REGEX = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
					 
				    final Pattern COULEUR_PATTERN = Pattern.compile(COULEUR_REGEX);
				    
				    final String PRIX_REGEX = "^[0-9]$";
					 
				    final Pattern PRIX_PATTERN = Pattern.compile(PRIX_REGEX);
				    
				    final String QUANTITE_REGEX = "^[0-9]$";
					 
				    final Pattern QUANTITE_PATTERN = Pattern.compile(QUANTITE_REGEX);
				    
				   
				    
				    if (CAPACITE_PATTERN.matcher(capacite).matches() == false) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du capacite n`est pas bon");
				    }
				    
				    if(COULEUR_PATTERN.matcher(couleur).matches()  == false) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du couleur n`est pas bon");
				    }
				    
				    if( PRIX_PATTERN.matcher(prix).matches()  == false) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du prix n`est pas bon");
				    }
				    
				    if( QUANTITE_REGEX.matcher(quantite).matches() == false) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du quantite n`est pas bon");
				    }
				    
				    if (transmission.equals("")) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du transmission n'est pas bon");
				    }
				    
				    if (carburant.equals("")) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du carburant n'est pas bon");
				    }
				    
				    if (pays.equals("")) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du pays n'est pas bon");
				    }
				    
				    if (option_ref.equals("")) {
				    	JOptionPane.showMessageDialog(null, "L`insertion de l'option n'est pas bon");
				    }
				    
				    if (lieu.equals("")) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du lieu n'est pas bon");
				    }
				    
				    if (statue.equals("")) {
				    	JOptionPane.showMessageDialog(null, "L`insertion du statue n'est pas bon");
				    }
				    
				   
				   
					
					if (CAPACITE_PATTERN.matcher(capacite).matches()&&
							COULEUR_PATTERN.matcher(couleur).matches() && !transmission.equals("") && !carburant.equals("") && !pays.equals("") && !option_ref.equals("") && !lieu.equals("") && !statue.equals("") &&
							PRIX_PATTERN.matcher(prix).matches()&&
							QUANTITE_REGEX.matcher(quantite).matches()) 
					{
					
					
					pst = con.prepareStatement("insert into vendeur_commande(marque,modele,capacite,transmission,carburant,couleur,pays,option_ref,lieu,prix,quantite,nom_vendeur,statue)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1, marque);
					pst.setString(2, modele);
					pst.setString(3, capacite);
					pst.setString(4, transmission);
					pst.setString(5, carburant);
					pst.setString(6, couleur);
					pst.setString(7, pays);
					pst.setString(8, option_ref);
					pst.setString(9, lieu);
					pst.setString(10, prix);
					pst.setString(11, quantite);
					pst.setString(12, nom_vendeur);
					pst.setString(13, statue);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added!");
					}
					count_load();
					table_load();
					

					txtmarque.setText("");
					txtmodele.setText("");
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
					txtmarque.requestFocus();
				}

				catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(56, 631, 107, 50);
		frame.getContentPane().add(btnNewButton);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(218, 631, 107, 50);
		frame.getContentPane().add(btnExit);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtmarque.setText("");
				txtmodele.setText("");
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
				txtmarque.requestFocus();
			}
		});
		btnClear.setBounds(389, 631, 107, 50);
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

					pst = con.prepareStatement("select marque,modele,capacite,transmission,carburant,couleur,pays,option_ref,lieu,prix,quantite,nom_vendeur,statue from vendeur_commande where id = ?");
					pst.setString(1, id);
					ResultSet rs = pst.executeQuery();

					if (rs.next() == true) {

						String marque = rs.getString(1);
						String modele = rs.getString(2);
						String capacite = rs.getString(3);
						String transmission = rs.getString(4);
						String carburant = rs.getString(5);
						String couleur = rs.getString(6);
						String pays = rs.getString(7);
						String option_ref = rs.getString(8);
						String lieu = rs.getString(9);
						String prix = rs.getString(10);
						String quantite = rs.getString(11);
						String nom_vendeur = rs.getString(12);
						String statue = rs.getString(13);

						txtmarque.setText(marque);
						txtmodele.setText(modele);
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
						txtmarque.requestFocus();

					} else {
						txtmarque.setText("");
						txtmodele.setText("");
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
						txtmarque.requestFocus();

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

				String marque, modele, capacite, couleur, prix, quantite, nom_vendeur,id, carburant, transmission, option_ref, pays, lieu, statue;
				marque = txtmarque.getText();
				modele = txtmodele.getText();
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
				id  = txtid.getText();

				try {
					pst = con.prepareStatement("update vendeur_commande set marque= ?,modele= ?,capacite= ?,transmission= ?,carburant= ?,couleur= ?,pays= ?,option_ref= ?,lieu= ?,prix= ?,quantite= ?,nom_vendeur= ?,statue= ? where id =?");
					pst.setString(1, marque);
					pst.setString(2, modele);
					pst.setString(3, capacite);
					pst.setString(4, transmission);
					pst.setString(5, carburant);
					pst.setString(6, couleur);
					pst.setString(7, pays);
					pst.setString(8, option_ref);
					pst.setString(9, lieu);
					pst.setString(10, prix);
					pst.setString(11, quantite);
					pst.setString(12, nom_vendeur);
					pst.setString(13, statue);
					pst.setString(14, id);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Updated!");
					table_load();

					txtmarque.setText("");
					txtmodele.setText("");
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
					txtmarque.requestFocus();
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
					table_load();

					txtmarque.setText("");
					txtmodele.setText("");
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
					txtmarque.requestFocus();
				}

				catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
		});
		btnDelete.setBounds(838, 631, 107, 50);
		frame.getContentPane().add(btnDelete);
		
		lblNoCommande = new JLabel();
		lblNoCommande.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNoCommande.setBounds(1278, 650, 252, 31);
		frame.getContentPane().add(lblNoCommande);

	}
	

}
