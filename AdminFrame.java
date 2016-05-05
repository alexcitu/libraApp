package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class AdminFrame extends JFrame {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItem;
	private JPanel panel;
	private JLabel label;
	
	public AdminFrame() {

		frame = new JFrame();
		frame.setTitle("Admin");
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocationRelativeTo(null);

		menuBar = new JMenuBar();
		menu = new JMenu("Utilizatori");
		menuBar.add(menu);

		menuItem = new JMenuItem("Adauga utilizator", KeyEvent.VK_A);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				getContentPane().removeAll();

				panel = new JPanel();
				label = new JLabel("Adauga utilizator");
				panel.add(label);
				
				getContentPane().add(panel);
				getContentPane().validate();
				getContentPane().repaint();

				new Inregistrare();
			}
		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Sterge utilizator", KeyEvent.VK_S);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				getContentPane().removeAll();

				panel = new JPanel();
				label = new JLabel("Sterge utilizator");
				panel.add(label);
				
				getContentPane().add(panel);
				getContentPane().validate();
				getContentPane().repaint();
				
				new StergeUtilizator();
			}
		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Modifica parola unui utilizator", KeyEvent.VK_M);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getContentPane().removeAll();

				panel = new JPanel();
				label = new JLabel("Modificare parola utilizator");
				panel.add(label);
				
				getContentPane().add(panel);
				getContentPane().validate();
				getContentPane().repaint();
				
				new ModificaParolaU();
			}
		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Modifica parola mea", KeyEvent.VK_N);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getContentPane().removeAll();

				panel = new JPanel();
				label = new JLabel("Modificare parola admin");
				panel.add(label);
				
				getContentPane().add(panel);
				getContentPane().validate();
				getContentPane().repaint();
				
				new ModificaParolaAdmin();
				
			}
		});
		menu.add(menuItem);

		menu = new JMenu("Biblioteca");
		menuBar.add(menu);

		menuItem = new JMenuItem("Adauga un autor", KeyEvent.VK_Q);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getContentPane().removeAll();

				panel = new JPanel();
				label = new JLabel("Adauga autor");
				panel.add(label);
				
				getContentPane().add(panel);
				getContentPane().validate();
				getContentPane().repaint();
				
				new AdaugaAutor();
				
			}
		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Adauga o categorie", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clic");
			}
		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Adauga o carte", KeyEvent.VK_W);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clic2");
			}
		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Sterge o carte", KeyEvent.VK_E);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clic3");
			}
		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Cauta o carte", KeyEvent.VK_R);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clic4");
			}
		});
		menu.add(menuItem);

		menu = new JMenu("Iesire");
		menuBar.add(menu);

		menuItem = new JMenuItem("Click pentru a iesi", KeyEvent.VK_I);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.ALT_MASK));
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		menu.add(menuItem);

		frame.setJMenuBar(menuBar);

		frame.add(getContentPane());
		frame.setVisible(true);
	}
}
