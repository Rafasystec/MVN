package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleCartaoPresente;
import br.com.barcadero.tables.CartaoPresente;
import br.com.barcadero.web.functions.HandleMessage;

@ManagedBean
@RequestScoped
public class BeanCartaoPresenteGerar extends SuperBean<CartaoPresente> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4661977303742500941L;
	private int serie;
	private int quantidade;
	private RuleCartaoPresente ruleCartaoPresente;
	
	public BeanCartaoPresenteGerar() {
		ruleCartaoPresente = new RuleCartaoPresente(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
	}
	
	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String alterar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String novo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String gerar() {
		try {
			ruleCartaoPresente.gerarCartoes(serie, quantidade, getUsuarioLogado());
			HandleMessage.info("Cartões gerados com sucesso.");
		} catch (Exception e) {
			// TODO: handle exception
			HandleMessage.error("Erro ao gerar os cartões", e.getMessage());
		}
		return null;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public boolean validar(CartaoPresente entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
