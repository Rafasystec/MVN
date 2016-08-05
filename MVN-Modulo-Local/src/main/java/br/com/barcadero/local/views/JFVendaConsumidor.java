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

import br.com.barcadero.rule.RuleNota;
import br.com.barcadero.tables.Nota;

import java.awt.Font;

public class JFVendaConsumidor extends JFrame {

	
	private static final long serialVersionUID = 8198020765657224342L;
	private JPanel contentPane;
	private JTextField txtCodeProduto;
	private static JTextArea txtrTxtitens;
	private JTextField txtCliente;
	private JTextField txtQuantidade;
	private Nota nota;
	private RuleNota ruleNota;

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
		setTitle("VENDA AO CONSUMIDOR   ---    VERSÃO1.0 - RELEASE 35.06");
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
		txtCodeProduto.setBounds(9, 80, 86, 20);
		panel.add(txtCodeProduto);
		txtCodeProduto.setColumns(10);
		
		txtrTxtitens = new JTextArea();
		//txtrTxtitens.setText("txtItens");
		txtrTxtitens.setBounds(477, 133, 350, 370);
		contentPane.add(txtrTxtitens);
		
		JButton btnConsultarProduto = new JButton("+");
		btnConsultarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Chamou evento de adcionar pedido.");
				//txtrTxtitens.add("0001 - PRODUTO SUBSTITUICAO TRIBUTARIA 1 X 5,80     5,80");
				txtrTxtitens.append("0001 - PRODUTO SUBSTITUICAO TRIBUTARIA 1 X 5,80     5,80 \n");
				//txtrTxtitens.setText("OK");
				//txtrTxtitens.repaint();
				System.out.println("Término da Chamada.");
			}
		});
		btnConsultarProduto.setBounds(108, 79, 43, 23);
		panel.add(btnConsultarProduto);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(10, 31, 86, 20);
		panel.add(txtCliente);
		txtCliente.setColumns(10);
		
		JButton btnConsultarCliente = new JButton("+");
		btnConsultarCliente.setBounds(108, 30, 43, 23);
		panel.add(btnConsultarCliente);
		
		JLabel lblLblcliente = new JLabel("Cliente:");
		lblLblcliente.setBounds(10, 15, 46, 14);
		panel.add(lblLblcliente);
		
		JLabel lblLblnomecliente = new JLabel("MARCELO DE SOUSA LIMA");
		lblLblnomecliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLblnomecliente.setBounds(161, 34, 234, 17);
		panel.add(lblLblnomecliente);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setText("quantidade");
		txtQuantidade.setBounds(161, 80, 86, 20);
		panel.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Qauntidade:");
		lblQuantidade.setBounds(161, 64, 86, 14);
		panel.add(lblQuantidade);
		
		JButton btnAddItem = new JButton("Add. Item");
		btnAddItem.setBounds(257, 79, 111, 23);
		panel.add(btnAddItem);
		
		JButton btnFecharvenda = new JButton("Fechar Venda");
		btnFecharvenda.setBounds(429, 0, 111, 23);
		panel.add(btnFecharvenda);
		
		JButton btnCancelarVenda = new JButton("Cancelar Venda");
		btnCancelarVenda.setBounds(709, 0, 111, 23);
		panel.add(btnCancelarVenda);
		
		JButton btnCancelarItem = new JButton("Cancelar Item");
		btnCancelarItem.setBounds(595, 0, 111, 23);
		panel.add(btnCancelarItem);
		
		JLabel lblLabelSubTotal = new JLabel("Sub Total:");
		lblLabelSubTotal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLabelSubTotal.setBounds(517, 72, 99, 33);
		panel.add(lblLabelSubTotal);
		
		JLabel lblSubtotal = new JLabel("1.850,00");
		lblSubtotal.setForeground(Color.BLUE);
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblSubtotal.setBounds(632, 64, 188, 36);
		panel.add(lblSubtotal);
		
		JLabel lblLblproddescricao = new JLabel("SMARTPHONE LG NUBIA-X 7\"");
		lblLblproddescricao.setForeground(Color.BLUE);
		lblLblproddescricao.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLblproddescricao.setBounds(20, 133, 447, 33);
		contentPane.add(lblLblproddescricao);
		
		JLabel lblValoritematual = new JLabel("5,80");
		lblValoritematual.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblValoritematual.setForeground(Color.RED);
		lblValoritematual.setBounds(10, 177, 177, 86);
		contentPane.add(lblValoritematual);
		this.ruleNota = new RuleNota(null, null, null);
		criarNota();
	}
	
	private void criarNota() {
		this.nota = new Nota();
		
	}
}
