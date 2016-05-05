package View;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Controller.Database;

public class ClientFrame extends JFrame {
	private JFrame frame;
	private JButton inapoi;

	public ClientFrame() {

		final Database dataBase = new Database();

		frame = new JFrame();
		frame.setTitle("Client");
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		inapoi = new JButton("Inapoi");

		inapoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Login();

			}
		});

		panel.add(inapoi);

		getContentPane().add(panel, BorderLayout.SOUTH);

		frame.add(getContentPane());
		frame.setVisible(true);
	}
}
