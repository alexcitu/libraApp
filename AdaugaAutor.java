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

public class AdaugaAutor extends JFrame{

	private JFrame frame;
	private JButton adauga;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JTextField textFieldCNP;
	private JTextField textFieldNume;
	private JTextField textFieldPrenume;
	private boolean ok;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;

	public AdaugaAutor() {

		final Database dataBase = new Database();

		frame = new JFrame();
		frame.setTitle("Adauga autor");
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);

		panel1 = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.insets = new Insets(5, 5, 5, 5);
		
		label1 = new JLabel("Adauga autor");
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel2.add(label1);
		
		label2 = new JLabel("CNP autor");
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		panel1.add(label2, c);
		
		textFieldCNP = new JTextField(10);
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		panel1.add(textFieldCNP, c);
		
		
		label3 = new JLabel("Nume autor: ");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		panel1.add(label3, c);

		textFieldNume = new JTextField(10);
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 2;
		panel1.add(textFieldNume, c);
		
		label4 = new JLabel("Prenume autor: ");
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		panel1.add(label4, c);

		textFieldPrenume = new JTextField(10);
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 2;
		panel1.add(textFieldPrenume, c);
		panel1.setBorder(new LineBorder(Color.GRAY));
		
		
		adauga = new JButton("Adauga");

		panel3.add(adauga);
		
		adauga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ok = dataBase.adaugaAutor(textFieldCNP.getText(), textFieldNume.getText(), textFieldPrenume.getText());
				if(ok){
					JOptionPane.showMessageDialog(frame, "Autor adaugat");
					textFieldCNP.setText("");
					textFieldNume.setText("");
					textFieldPrenume.setText("");
				}
				else{
					JOptionPane.showMessageDialog(frame, "Autorul exista deja");
					textFieldCNP.setText("");
					textFieldNume.setText("");
					textFieldPrenume.setText("");
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
