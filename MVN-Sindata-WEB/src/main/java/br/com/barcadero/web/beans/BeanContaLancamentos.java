package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.TabChangeEvent;

import br.com.barcadero.commons.util.HandleDateHour;
import br.com.barcadero.core.enums.EnumCentroCusto;
import br.com.barcadero.core.enums.EnumFormaPgto;
import br.com.barcadero.core.enums.EnumNaturezaReceita;
import br.com.barcadero.core.enums.EnumTipoReceita;
import br.com.barcadero.rule.RuleCartaoDebitoCredito;
import br.com.barcadero.rule.RuleCentroDeCusto;
import br.com.barcadero.rule.RuleContaLancamento;
import br.com.barcadero.rule.RuleReceita;
import br.com.barcadero.tables.CartaoCreditoDebito;
import br.com.barcadero.tables.CentroDeCusto;
import br.com.barcadero.tables.ContaLancamento;
import br.com.barcadero.tables.Receita;
import br.com.barcadero.web.functions.HandleMessage;

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
	@ManagedProperty("#{ruleReceita}")
	private RuleReceita ruleReceita;
	//---------------------------------------------------
	//Beans
	//---------------------------------------------------
	private ContaLancamento contaLancamento;
	private ContaLancamento selectedContaLancamento;
	private Receita receita;
	private boolean habilitarDadosCartao = false;
	private boolean requiredDespesas = true;
	
	@PostConstruct
	private void init() {
		//System.out.println("Init view Lancamentos");
		novoLancamento();
		novaReceita();
		//System.out.println("Fim init");
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salvar() throws Exception {
		if(isRequiredDespesas()){
			contaLancamento = ruleContaLancamento.insert(contaLancamento);
			novoLancamento();
		}else{
			if(validarReceita()){
				receita			= ruleReceita.insert(receita);
				novaReceita();
				HandleMessage.info("Receita Salva com sucesso");
			}
		}
		
		return null;
	}
	
	public boolean validarReceita() {
		if(receita == null){
			HandleMessage.error("Erro de validação da Receita", "O objeto não foi instaciado.");
			return false;
		}
		return true;
	}

	private void novaReceita() {
		receita = new Receita(getEmpresaLogada(), getUsuarioLogado(), getLojaLogada());
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
	
	public EnumTipoReceita[] getTipoReceita() {
		return EnumTipoReceita.values();
	}
	
	public EnumNaturezaReceita[] getNaturezaReceita() {
		return EnumNaturezaReceita.values();
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
	
	public void onTabChange(TabChangeEvent event) {
		String tabId = event.getTab().getId();
		String title = event.getTab().getTitle();
		String message = "";
		if(tabId.equalsIgnoreCase("tabDespesa")){
			message = "Lance as suas depesas";
			setRequiredDespesas(true);
		}else{
			message = "Lance as suas receitas";
			setRequiredDespesas(false);
		}
		FacesMessage msg = new FacesMessage(title, message);
		FacesContext.getCurrentInstance().addMessage("growl", msg);
	}

	public boolean isRequiredDespesas() {
		return requiredDespesas;
	}

	public void setRequiredDespesas(boolean requiredDespesas) {
		this.requiredDespesas = requiredDespesas;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public RuleReceita getRuleReceita() {
		return ruleReceita;
	}

	public void setRuleReceita(RuleReceita ruleReceita) {
		this.ruleReceita = ruleReceita;
	}
	
	public List<String> getDiasDoMes() {
		return HandleDateHour.getDaysList();
	}

}
