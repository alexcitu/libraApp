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

public class StergeUtilizator extends JFrame{

	private JFrame frame;
	private JButton sterge;
	private JLabel label;
	private JLabel email;
	private JTextField textField;
	private boolean ok;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;

	public StergeUtilizator() {

		final Database dataBase = new Database();

		frame = new JFrame();
		frame.setTitle("Sterge Utilizator");
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);

		panel1 = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);
		
		label = new JLabel("Sterge Utilizator");
		
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel2.add(label);
		
		email = new JLabel("Email");
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		panel1.add(email, c);
		
		textField = new JTextField(10);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		panel1.add(textField, c);
		panel1.setBorder(new LineBorder(Color.GRAY));
		
		
		sterge = new JButton("Sterge");
		panel3.add(sterge);

		sterge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok = dataBase.cautaUtilizator(textField.getText());
				if(ok == true){
					dataBase.stergeUtilizator(textField.getText());
					JOptionPane.showMessageDialog(frame, "Utilizator sters!");
					textField.setText("");
				}
				else{
					JOptionPane.showMessageDialog(frame, "Utilizatorul nu exista!");
					textField.setText("");
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
