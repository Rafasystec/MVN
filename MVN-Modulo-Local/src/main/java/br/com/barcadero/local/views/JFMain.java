package br.com.barcadero.local.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class JFMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFMain frame = new JFMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 572);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmInicial = new JMenuItem("INICIAL");
		menuBar.add(mntmInicial);
		
		JMenuItem mntmOperacional = new JMenuItem("OPERACIONAL");
		menuBar.add(mntmOperacional);
		
		JMenuItem mntmConfiguraes = new JMenuItem("CONFIGURAÇÕES");
		menuBar.add(mntmConfiguraes);
		
		JMenuItem mntmSobre = new JMenuItem("SOBRE");
		menuBar.add(mntmSobre);
		
		JMenu mnInicial = new JMenu("INICIAL");
		menuBar.add(mnInicial);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
