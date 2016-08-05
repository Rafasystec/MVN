package br.com.barcadero.local.tests;

import br.com.barcadero.local.views.JFVendaConsumidor;

public class TestViews {
	
	public static void main(String[] args) {
		System.out.println("Chamando janela");
		JFVendaConsumidor consumidor = new JFVendaConsumidor();
		consumidor.setVisible(true);
	}

}
