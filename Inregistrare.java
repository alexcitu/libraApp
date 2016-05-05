package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Controller.Database;

public class Inregistrare extends JFrame {

	private JFrame frame;
	private JTextField textFieldUser;
	private JTextField textFieldNume;
	private JTextField textFieldPrenume;
	private JTextField textFieldEmail;
	private JTextField textFieldLocalitate;
	private JPasswordField passwordField;
	private JLabel username;
	private JLabel password;
	private JLabel nume;
	private JLabel prenume;
	private JLabel email;
	private JLabel localitate;
	private JButton inregistrare;
	private JButton inapoi;
	private boolean ok = false;

	public Inregistrare() {

		final Database dataBase = new Database();

		frame = new JFrame();
		frame.setTitle("Inregistrare");
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);

		username = new JLabel("Username: ");
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		panel.add(username, c);

		textFieldUser = new JTextField(10);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		panel.add(textFieldUser, c);

		password = new JLabel("Password: ");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		panel.add(password, c);

		passwordField = new JPasswordField(10);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		panel.add(passwordField, c);

		nume = new JLabel("Nume: ");
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		panel.add(nume, c);

		textFieldNume = new JTextField(10);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 2;
		panel.add(textFieldNume, c);

		prenume = new JLabel("Prenume: ");
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		panel.add(prenume, c);

		textFieldPrenume = new JTextField(10);
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 2;
		panel.add(textFieldPrenume, c);

		email = new JLabel("Email: ");
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		panel.add(email, c);

		textFieldEmail = new JTextField(10);
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 2;
		panel.add(textFieldEmail, c);

		localitate = new JLabel("Localitate: ");
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		panel.add(localitate, c);

		textFieldLocalitate = new JTextField(10);
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 2;
		panel.add(textFieldLocalitate, c);
		panel.setBorder(new LineBorder(Color.GRAY));

		JPanel panel2 = new JPanel();
		inregistrare = new JButton("Inregistrare");
		panel2.add(inregistrare);
		inapoi = new JButton("Inapoi");
		panel2.add(inapoi);

		inregistrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok = dataBase.introducereUtilizator(textFieldUser.getText(), passwordField.getText(),
						textFieldNume.getText(), textFieldPrenume.getText(), textFieldEmail.getText(),
						textFieldLocalitate.getText());
				if (ok == false) {
					JOptionPane.showMessageDialog(frame, "Email utilizat");
					textFieldUser.setText("");
					passwordField.setText("");
					textFieldNume.setText("");
					textFieldPrenume.setText("");
					textFieldEmail.setText("");
					textFieldLocalitate.setText("");
				} else {
					JOptionPane.showMessageDialog(frame, "Utilizator inregistrat!");
					textFieldUser.setText("");
					passwordField.setText("");
					textFieldNume.setText("");
					textFieldPrenume.setText("");
					textFieldEmail.setText("");
					textFieldLocalitate.setText("");
					frame.dispose();
					new Login();
				}
			}
		});

		inapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Login();
			}
		});

		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(panel2, BorderLayout.PAGE_END);

		frame.add(getContentPane());
		frame.setVisible(true);
	}
}
