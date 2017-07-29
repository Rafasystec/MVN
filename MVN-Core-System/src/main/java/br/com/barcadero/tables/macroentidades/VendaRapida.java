package br.com.barcadero.tables.macroentidades;

import java.util.List;

import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.tables.NotaItens;

public class VendaRapida extends Entidade {

	/**
	 * 
	 */
	private static final long serialVersionUID = -156795239504995979L;
	private Nota nota;
	private List<NotaItens> itens;
	public Nota getNota() {
		return nota;
	}
	public void setNota(Nota nota) {
		this.nota = nota;
	}
	public List<NotaItens> getItens() {
		return itens;
	}
	public void setItens(List<NotaItens> itens) {
		this.itens = itens;
	}
	
}
