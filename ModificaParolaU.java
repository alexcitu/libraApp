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

public class ModificaParolaU extends JFrame{

	private JFrame frame;
	private JButton modifica;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JTextField textFieldEmail;
	private JPasswordField textFieldPass;
	private JPasswordField textFieldNewPass;
	private boolean ok;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;

	public ModificaParolaU() {

		final Database dataBase = new Database();

		frame = new JFrame();
		frame.setTitle("Modificare Parola");
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);

		panel1 = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);
		
		label1 = new JLabel("Modificare Parola Utilizator");
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel2.add(label1);
		
		label2 = new JLabel("Email");
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		panel1.add(label2, c);
		
		textFieldEmail = new JTextField(10);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		panel1.add(textFieldEmail, c);
		
		
		label3 = new JLabel("New password: ");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		panel1.add(label3, c);

		textFieldPass = new JPasswordField(10);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		panel1.add(textFieldPass, c);
		
		label4 = new JLabel("Confirm new password: ");
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		panel1.add(label4, c);

		textFieldNewPass = new JPasswordField(10);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 2;
		panel1.add(textFieldNewPass, c);
		panel1.setBorder(new LineBorder(Color.GRAY));
		
		
		modifica = new JButton("Modifica");

		panel3.add(modifica);
		
		modifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(textFieldPass.getText().equals(textFieldNewPass.getText())){
					ok = dataBase.modificareParola(textFieldEmail.getText(), textFieldPass.getText());
					if(ok){
						JOptionPane.showMessageDialog(frame, "Parola modificata");
						textFieldEmail.setText("");
						textFieldPass.setText("");
						textFieldNewPass.setText("");
					}
					else{
						JOptionPane.showMessageDialog(frame, "Email inexistent");
						textFieldEmail.setText("");
						textFieldPass.setText("");
						textFieldNewPass.setText("");
					}
				}
				else{
					JOptionPane.showMessageDialog(frame, "Parolele din cele 2 campuri trebuie sa corespunda");
					textFieldEmail.setText("");
					textFieldPass.setText("");
					textFieldNewPass.setText("");
				}
				
			}
		});

		getContentPane().add(panel2, BorderLayout.NORTH);
		getContentPane().add(panel1, BorderLayout.CENTER);
		getContentPane().add(panel3, BorderLayout.SOUTH);
		
		frame.add(getContentPane());
		frame.setVisible(true);
	}
}
