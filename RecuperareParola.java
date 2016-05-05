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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Controller.Database;
import Controller.SendEmail;

public class RecuperareParola extends JFrame {

	private JFrame frame;
	private JTextField textFieldEmail;
	private JLabel email;
	private JButton trimite;
	private JButton inapoi;
	private boolean ok = false;

	public RecuperareParola() {

		final Database dataBase = new Database();

		frame = new JFrame();
		frame.setTitle("Recuperare Parola");
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);

		email = new JLabel("Introduceti Email: ");
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		panel.add(email, c);

		textFieldEmail = new JTextField(10);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		panel.add(textFieldEmail, c);
		panel.setBorder(new LineBorder(Color.GRAY));

		trimite = new JButton("Trimite");
		inapoi = new JButton("Inapoi");
		JPanel panel2 = new JPanel();
		panel2.add(trimite);
		panel2.add(inapoi);

		trimite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ok = dataBase.modificareParola(textFieldEmail.getText(), "123456");
				if (ok) {
					SendEmail se = new SendEmail();
					se.sendEmail(textFieldEmail.getText());
					textFieldEmail.setText("");
				} else {
					JOptionPane.showMessageDialog(frame, "eroare");
					textFieldEmail.setText("");
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
