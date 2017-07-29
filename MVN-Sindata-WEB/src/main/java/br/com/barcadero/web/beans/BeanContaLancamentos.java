package br.com.barcadero.web.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.core.enums.EnumCentroCusto;
import br.com.barcadero.core.enums.EnumFormaPgto;
import br.com.barcadero.rule.RuleContaLancamento;
import br.com.barcadero.tables.ContaLancamento;

@ManagedBean
@ViewScoped
public class BeanContaLancamentos extends SuperBean<ContaLancamento> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7676371071030680469L;
	@ManagedProperty("#{ruleContaLancamento}")
	private RuleContaLancamento ruleContaLancamento;
	private ContaLancamento contaLancamento;
	private ContaLancamento selectedContaLancamento;
	private EnumCentroCusto[] centroCusto;
	private EnumFormaPgto[] formaPagamento;
	@PostConstruct
	private void init() {
		System.out.println("Init view Lancamentos");
		contaLancamento		= new ContaLancamento(getEmpresaLogada(), getUsuarioLogado(), getLojaLogada());
		System.out.println("Fim init");
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salvar() throws Exception {
		contaLancamento = ruleContaLancamento.insert(contaLancamento);
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
	
	public EnumCentroCusto[] getCentroCusto() {
		return EnumCentroCusto.values();
	}
	
	public EnumFormaPgto[] getFormaPagamento() {
		return EnumFormaPgto.values();
	}

	public void setCentroCusto(EnumCentroCusto[] centroCusto) {
		this.centroCusto = centroCusto;
	}

	public void setFormaPagamento(EnumFormaPgto[] formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public List<ContaLancamento> getLancamentos() {
		return this.ruleContaLancamento.getAllOfThisMonth(getEmpresaLogada(),getLojaLogada());
	}

	public ContaLancamento getSelectedContaLancamento() {
		return selectedContaLancamento;
	}

	public void setSelectedContaLancamento(ContaLancamento selectedContaLancamento) {
		this.selectedContaLancamento = selectedContaLancamento;
	}

	@Override
	public boolean validar(ContaLancamento entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}