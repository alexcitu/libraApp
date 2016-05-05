package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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

public class Login extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel username;
	private JLabel password;
	private JButton login;
	private JButton inregistrare;
	private JButton recuperareParola;
	private boolean ok = false;

	public Login() {

		final Database dataBase = new Database();

		frame = new JFrame();
		frame.setTitle("Login");
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

		textField = new JTextField(10);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		panel.add(textField, c);

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
		panel.setBorder(new LineBorder(Color.GRAY));

		login = new JButton("Login");

		JPanel panel2 = new JPanel(new GridLayout(2, 1));
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();

		panel3.add(login);
		inregistrare = new JButton("Register");
		inregistrare.setPreferredSize(new Dimension(90, 20));
		panel4.add(inregistrare);

		recuperareParola = new JButton("Recover");
		recuperareParola.setPreferredSize(new Dimension(90, 20));
		panel4.add(recuperareParola);

		panel2.add(panel3);
		panel2.add(panel4);

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok = dataBase.verificareLogin(textField.getText(), passwordField.getText());
				if (ok == true && textField.getText().equals("admin")) {
					frame.dispose();
					new AdminFrame();
				} else if (ok == true) {
					frame.dispose();
					new ClientFrame();
				} else {
					JOptionPane.showMessageDialog(frame, "eroare");
					textField.setText("");
					passwordField.setText("");
				}
			}
		});

		inregistrare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Inregistrare();
			}
		});

		recuperareParola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new RecuperareParola();
			}
		});

		getContentPane().add(panel, BorderLayout.CENTER);
		getContentPane().add(panel2, BorderLayout.PAGE_END);

		frame.add(getContentPane());
		frame.setVisible(true);
	}
}
