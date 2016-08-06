package br.com.barcadero.local.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.barcadero.local.main.Main;
import br.com.barcadero.local.persistence.StartH2Engine;

public class JFMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3066403674196244914L;
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
		
		JMenu mnInicial = new JMenu("INICIAL");
		menuBar.add(mnInicial);
		
		JMenuItem mntmBancoDeDados = new JMenuItem("Banco De Dados");
		mntmBancoDeDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartH2Engine.runConsoleBrowser();
			}
		});
		mnInicial.add(mntmBancoDeDados);
		
		JMenuItem mntmSair = new JMenuItem("SAIR");
		mnInicial.add(mntmSair);
		
		JMenu mnConfiguraes = new JMenu("CONFIGURAÇÕES");
		menuBar.add(mnConfiguraes);
		
		JMenuItem mntmImpressora = new JMenuItem("IMPRESSORA");
		mnConfiguraes.add(mntmImpressora);
		
		JMenuItem mntmEcf = new JMenuItem("ECF");
		mnConfiguraes.add(mntmEcf);
		
		JMenuItem mntmTefcarto = new JMenuItem("TEF-CARTÃO");
		mnConfiguraes.add(mntmTefcarto);
		
		JMenu mnOperacional = new JMenu("OPERACIONAL");
		menuBar.add(mnOperacional);
		
		JMenuItem mntmRecberPedido = new JMenuItem("RECEBER PEDIDO");
		mntmRecberPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Receber Pedido ...");
			}
		});
		mnOperacional.add(mntmRecberPedido);
		
		JMenuItem mntmVendaConsumidor = new JMenuItem("VENDA CONSUMIDOR");
		mntmVendaConsumidor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Venda ao consumidor...");
				invokVendaConsumidor();
			}
		});
		mnOperacional.add(mntmVendaConsumidor);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setTitle(Main.APP_NAME + " - " + "Version: " + Main.APP_VERSION + " --  Windows & Linux");
	}
	
	private void invokVendaConsumidor() {
		JFVendaConsumidor consumidor = new JFVendaConsumidor();
		consumidor.setFocusable(true);
		consumidor.setDefaultCloseOperation(JFVendaConsumidor.DISPOSE_ON_CLOSE);
		consumidor.setVisible(true);
		
	}

}
