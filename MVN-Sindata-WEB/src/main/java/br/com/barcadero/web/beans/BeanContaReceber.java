package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleContaAReceber;
import br.com.barcadero.tables.ContaReceber;

@ManagedBean
@RequestScoped
public class BeanContaReceber extends SuperBean {

	
	private static final long serialVersionUID = 7086040543170117779L;
	private ContaReceber conta; 
	private RuleContaAReceber rule;
	
	public BeanContaReceber(){
		conta 	= new ContaReceber(getEmpresaLogada(),getUsuarioLogado());
		rule	= new RuleContaAReceber(getEmpresaLogada(),getLojaLogada(),getDataBaseSession());
	}
	
	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		rule.insert(conta);
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

	public ContaReceber getConta() {
		return conta;
	}

	public void setConta(ContaReceber conta) {
		this.conta = conta;
	}

}
