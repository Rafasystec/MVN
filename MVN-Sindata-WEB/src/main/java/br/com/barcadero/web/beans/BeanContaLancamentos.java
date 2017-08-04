package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import br.com.barcadero.core.enums.EnumCentroCusto;
import br.com.barcadero.core.enums.EnumFormaPgto;
import br.com.barcadero.rule.RuleCartaoDebitoCredito;
import br.com.barcadero.rule.RuleCentroDeCusto;
import br.com.barcadero.rule.RuleContaLancamento;
import br.com.barcadero.tables.CartaoCreditoDebito;
import br.com.barcadero.tables.CentroDeCusto;
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
	@ManagedProperty("#{ruleCartaoDebitoCredito}")
	private RuleCartaoDebitoCredito ruleCartaoDebitoCredito;
	@ManagedProperty("#{ruleCentroDeCusto}")
	private RuleCentroDeCusto ruleCentroDeCusto;
	private ContaLancamento contaLancamento;
	private ContaLancamento selectedContaLancamento;
	private boolean habilitarDadosCartao = false;
	
	@PostConstruct
	private void init() {
		System.out.println("Init view Lancamentos");
		novoLancamento();
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
		novoLancamento();
		return null;
	}

	private void novoLancamento() {
		contaLancamento = new ContaLancamento(getEmpresaLogada(), getUsuarioLogado(), getLojaLogada());
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

	public boolean isHabilitarDadosCartao() {
		return habilitarDadosCartao;
	}

	public void setHabilitarDadosCartao(boolean habilitarDadosCartao) {
		this.habilitarDadosCartao = habilitarDadosCartao;
	}
	
	public void verificarSeMostraDadosCartao(final AjaxBehaviorEvent event) {
		if(contaLancamento != null){
			if(formasPgtoQueHabilitamCartao(contaLancamento.getFormaPgto())){
				setHabilitarDadosCartao(true);
			}else{
				setHabilitarDadosCartao(false);
			}
		}
	}
	
	public List<CartaoCreditoDebito> getCartoesAtivos() {
		try {
			return ruleCartaoDebitoCredito.findByEmpresa(getEmpresaLogada());
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}
	
	private boolean formasPgtoQueHabilitamCartao(EnumFormaPgto formaPgto) {
		boolean result = false;
		if(formaPgto == EnumFormaPgto.CARTAO_CREDITO){
			result = true;
		}else if(formaPgto == EnumFormaPgto.CARTAO_DEBITO){
			result = true;
		}else if(formaPgto == EnumFormaPgto.DEBITO_EM_CONTA){
			result = true;
		}
		return result;
	}

	public RuleCartaoDebitoCredito getRuleCartaoDebitoCredito() {
		return ruleCartaoDebitoCredito;
	}

	public void setRuleCartaoDebitoCredito(RuleCartaoDebitoCredito ruleCartaoDebitoCredito) {
		this.ruleCartaoDebitoCredito = ruleCartaoDebitoCredito;
	}
	
	public List<CentroDeCusto> getCentroDeCusto() {
		try {
			return ruleCentroDeCusto.findByEmpresa(getEmpresaLogada());
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	public RuleCentroDeCusto getRuleCentroDeCusto() {
		return ruleCentroDeCusto;
	}

	public void setRuleCentroDeCusto(RuleCentroDeCusto ruleCentroDeCusto) {
		this.ruleCentroDeCusto = ruleCentroDeCusto;
	}

}
