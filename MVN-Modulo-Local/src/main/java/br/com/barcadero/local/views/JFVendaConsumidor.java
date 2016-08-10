package br.com.barcadero.local.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import br.com.barcadero.core.enums.EnumModeloNota;
import br.com.barcadero.core.enums.EnumNaturezaOperacao;
import br.com.barcadero.local.main.Main;
import br.com.barcadero.rule.RuleNota;
import br.com.barcadero.rule.RuleProduto;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.tables.NotaItens;
import br.com.barcadero.tables.Produto;

public class JFVendaConsumidor extends JFrame {

	
	private static final long serialVersionUID = 8198020765657224342L;
	private JPanel contentPane;
	private JTextField txtCodeProduto;
	private static JTextArea txtrTxtitens;
	private JTextField txtCliente;
	private JTextField txtQuantidade;
	private Nota nota;
	private RuleNota ruleNota;
	private RuleProduto ruleProduto;
	private JLabel lblNota;

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
		setBounds(100, 100, 894, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel.setBounds(12, 12, 830, 111);
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
		txtrTxtitens.setBounds(433, 165, 433, 370);
		contentPane.add(txtrTxtitens);
		
		JButton btnConsultarProduto = new JButton("+");
		btnConsultarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnConsultarProduto.setBounds(108, 79, 52, 23);
		panel.add(btnConsultarProduto);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(10, 31, 86, 20);
		panel.add(txtCliente);
		txtCliente.setColumns(10);
		
		JButton btnConsultarCliente = new JButton("+");
		btnConsultarCliente.setBounds(108, 30, 52, 23);
		panel.add(btnConsultarCliente);
		
		JLabel lblLblcliente = new JLabel("Cliente:");
		lblLblcliente.setBounds(10, 15, 86, 14);
		panel.add(lblLblcliente);
		
		JLabel lblLblnomecliente = new JLabel("MARCELO DE SOUSA LIMA");
		lblLblnomecliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLblnomecliente.setBounds(193, 33, 234, 17);
		panel.add(lblLblnomecliente);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(168, 80, 86, 20);
		panel.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Qauntidade:");
		lblQuantidade.setBounds(161, 64, 111, 14);
		panel.add(lblQuantidade);
		
		JButton btnAddItem = new JButton("Add. Item");
		btnAddItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItem();
			}
		});
		btnAddItem.setBounds(257, 79, 128, 23);
		panel.add(btnAddItem);
		
		JButton btnCancelarVenda = new JButton("Cancelar Venda");
		btnCancelarVenda.setBounds(641, 3, 144, 23);
		panel.add(btnCancelarVenda);
		
		JButton btnCancelarItem = new JButton("Cancelar Item");
		btnCancelarItem.setBounds(641, 29, 144, 23);
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
		
		JButton btnFecharvenda = new JButton("Fechar Venda");
		btnFecharvenda.setBounds(462, 0, 167, 51);
		panel.add(btnFecharvenda);
		
		JLabel lblLblproddescricao = new JLabel("SMARTPHONE LG NUBIA-X 7\"");
		lblLblproddescricao.setForeground(Color.BLUE);
		lblLblproddescricao.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLblproddescricao.setBounds(20, 133, 447, 33);
		contentPane.add(lblLblproddescricao);
		
		JLabel lblValoritematual = new JLabel("5,80");
		lblValoritematual.setFont(new Font("Tahoma", Font.BOLD, 42));
		lblValoritematual.setForeground(Color.RED);
		lblValoritematual.setBounds(81, 177, 177, 86);
		contentPane.add(lblValoritematual);
		
		JLabel lblColunasitens = new JLabel("item    | Descrição                 | Uni   | Qtde | Vl. Unit   | Vl. Total  ");
		lblColunasitens.setBounds(440, 135, 426, 15);
		contentPane.add(lblColunasitens);
		
		JLabel lblNumnota = new JLabel("Nota: ");
		lblNumnota.setBounds(12, 523, 70, 15);
		contentPane.add(lblNumnota);
		
		lblNota = new JLabel("Nota");
		lblNota.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNota.setForeground(Color.BLUE);
		lblNota.setBounds(78, 514, 102, 24);
		contentPane.add(lblNota);
		criarRuleNota();
		criarRuleProduto();
		criarNota();
	}
	
	private void criarNota() {
		this.nota = new Nota();
		nota.setInfAdicionais("ADICIONADO LOCALMENTE");
		nota.setNaturezaOperacao(EnumNaturezaOperacao.SAIDA);
		nota.setModelo(EnumModeloNota.MOD_59);
		try {
			Main.beginTransaction();
			ruleNota.insert(nota);
			lblNota.setText(""+nota.getCodigo());
			Main.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void criarRuleNota() {
		//this.ruleNota = new RuleNota(null, null, Main.getSession());
	}
	
	private void criarRuleProduto() {
		//this.ruleProduto = new RuleProduto(null, null, Main.getSession());
	}
	
	private void addItem() {
		
		
		NotaItens item = new NotaItens();
		System.out.println("Chamou evento de adcionar pedido.");
		try {
			Produto produto = ruleProduto.find(Integer.parseInt(txtCodeProduto.getText()));
			ruleNota.inserirItem(nota, item, produto);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		txtrTxtitens.append("0001 - PRODUTO SUBSTITUICAO TRIBUTARIA 1 X 5,80     5,80 \n");
		//txtrTxtitens.setText("OK");
		//txtrTxtitens.repaint();
		System.out.println("Término da Chamada.");
	}
}
