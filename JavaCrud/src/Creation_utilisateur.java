import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Creation_utilisateur {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Creation_utilisateur window = new Creation_utilisateur();
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
	public Creation_utilisateur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 405);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREATION UTILISATEUR");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(125, 10, 204, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNom.setBounds(34, 77, 45, 13);
		panel.add(lblNom);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMotDePasse.setBounds(34, 117, 95, 18);
		panel.add(lblMotDePasse);
		
		JLabel lblConfirmationMotDe = new JLabel("Confirmation m.d.p");
		lblConfirmationMotDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmationMotDe.setBounds(34, 158, 130, 13);
		panel.add(lblConfirmationMotDe);
		
		JLabel lblNewLabel_1 = new JLabel("Privil\u00E8ge");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(34, 199, 95, 13);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(210, 115, 152, 28);
		panel.add(textField_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(210, 72, 152, 28);
		panel.add(textField);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(210, 153, 152, 28);
		panel.add(textField_2);
		
		JButton btnNewButton = new JButton("Creation");
		btnNewButton.setBounds(164, 287, 95, 29);
		panel.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Manager");
		comboBox.addItem("Administrateur");
		comboBox.addItem("Resource Humaines");
		comboBox.addItem("Vendeur");
		comboBox.setSelectedItem("Administrateur");
		comboBox.setBounds(210, 193, 152, 29);
		panel.add(comboBox);
	}
}
