package br.com.barcadero.web.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.rule.RuleContaLancamento;
import br.com.barcadero.tables.ContaLancamento;

@ManagedBean
@ViewScoped
public class BeanContaLancamentos extends SuperBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7676371071030680469L;
	private RuleContaLancamento ruleContaLancamento;
	private ContaLancamento contaLancamento;
	
	@PostConstruct
	private void init() {
		ruleContaLancamento = new RuleContaLancamento(getEmpresaLogada(), getLojaLogada(), getUsuarioLogado());
		contaLancamento		= new ContaLancamento();
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salvar() throws Exception {
		ruleContaLancamento.insert(contaLancamento);
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

	public RuleContaLancamento getRuleContaLancamento() {
		return ruleContaLancamento;
	}

	public void setRuleContaLancamento(RuleContaLancamento ruleContaLancamento) {
		this.ruleContaLancamento = ruleContaLancamento;
	}

	public ContaLancamento getContaLancamento() {
		return contaLancamento;
	}

	public void setContaLancamento(ContaLancamento contaLancamento) {
		this.contaLancamento = contaLancamento;
	}

}
