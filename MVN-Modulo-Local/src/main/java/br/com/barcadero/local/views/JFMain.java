package br.com.barcadero.local.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

import br.com.barcadero.commons.enuns.EnumDateHourFormat;
import br.com.barcadero.commons.util.HandleDateHour;
import br.com.barcadero.local.main.Main;
import br.com.barcadero.local.main.TextAreaOutputStream;

public class JFMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3066403674196244914L;
	private JTextArea textArea = null;
	private TextAreaOutputStream taOutputStream = null;
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
		getContentPane().setBackground(Color.WHITE);
		
		textArea = new JTextArea();
		getContentPane().add(textArea, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 572);

		textArea.setText("Iniciando componenete local pra receber as comunicações com o servirdor.\n");
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnInicial = new JMenu("INICIAL");
		menuBar.add(mnInicial);
		
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
		this.setTitle(Main.APP_NAME + " - " + "Version: " + Main.APP_VERSION + " --  Windows & Linux");
		taOutputStream = new TextAreaOutputStream( textArea, "["+HandleDateHour.format(new Date(), EnumDateHourFormat.CURRENT_DATE_TIME)+"]");
		invocarTextAreaInterativoConsole();
		
	}
	
	public void setTextAreaAction(String text) {
		String textAreaText = textArea.getText();
		textAreaText = textAreaText + text + "\n";
	} 
	
	 private void invocarTextAreaInterativoConsole() {
	      setLayout(new BorderLayout());
	      add(new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
	      System.setOut(new PrintStream(taOutputStream));

	      int timerDelay = 1000;
	      new Timer(timerDelay , new ActionListener() {
	         int count = 0;
	         @Override
	         public void actionPerformed(ActionEvent arg0) {

//	            // though this outputs via System.out.println, it actually displays
//	            // in the JTextArea:
//	            System.out.println("Count is now: " + count + " seconds");
//	            count++;
	         }
	      }).start();
	   }


}
