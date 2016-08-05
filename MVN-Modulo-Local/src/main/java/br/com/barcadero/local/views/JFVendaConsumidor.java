package br.com.barcadero.local.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class JFVendaConsumidor extends JFrame {

	
	private static final long serialVersionUID = 8198020765657224342L;
	private JPanel contentPane;
	private JTextField txtCodeProduto;
	private static JTextArea txtrTxtitens;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFVendaConsumidor frame = new JFVendaConsumidor();
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
	public JFVendaConsumidor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel.setBounds(10, 11, 830, 111);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBounds(10, 64, 63, 14);
		panel.add(lblProduto);
		
		txtCodeProduto = new JTextField();
		txtCodeProduto.setToolTipText("ola");
		txtCodeProduto.setBounds(10, 80, 106, 20);
		panel.add(txtCodeProduto);
		txtCodeProduto.setColumns(10);

		JTextPane txtpnTxtitensvenda = new JTextPane();
		txtpnTxtitensvenda.setBounds(488, 133, 338, 340);
		contentPane.add(txtpnTxtitensvenda);
		
		txtrTxtitens = new JTextArea();
		txtrTxtitens.setText("txtItens");
		txtrTxtitens.setBounds(268, 133, 210, 340);
		contentPane.add(txtrTxtitens);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Chamou evento de adcionar pedido.");
				//txtrTxtitens.add("0001 - PRODUTO SUBSTITUICAO TRIBUTARIA 1 X 5,80     5,80");
				txtrTxtitens.append("0001 - PRODUTO SUBSTITUICAO TRIBUTARIA 1 X 5,80     5,80 \n");
				//txtrTxtitens.setText("OK");
				//txtrTxtitens.repaint();
				System.out.println("Término da Chamada.");
			}
		});
		button.setBounds(129, 79, 43, 23);
		panel.add(button);
	}
}
