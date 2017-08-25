package br.com.barcadero.web.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.core.enums.EnumMotivoCancelamento;
import br.com.barcadero.rule.RuleCaixa;
import br.com.barcadero.rule.RuleCancelamentoNota;
import br.com.barcadero.rule.RuleNota;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.Nota;
import br.com.barcadero.web.functions.HandleMessage;

@ManagedBean
@ViewScoped
public class BeanCancelamentoNota extends SuperBean<Nota> {

	/**
	 * 
	 */
	@ManagedProperty("#{ruleCancelamentoNota}")
	private RuleCancelamentoNota ruleCancelamentoNota;
	@ManagedProperty("#{ruleNota}")
	private RuleNota ruleNota;
	@ManagedProperty("#{ruleCaixa}")
	private RuleCaixa ruleCaixa;
	
	public RuleCaixa getRuleCaixa() {
		return ruleCaixa;
	}

	public void setRuleCaixa(RuleCaixa ruleCaixa) {
		this.ruleCaixa = ruleCaixa;
	}

	private static final long serialVersionUID = 876156773452975994L;
	private List<Nota> notas;
	private Nota selectedNota;
	private Caixa caixa;
	
	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	@PostConstruct
	public void init() {
		notas = ruleNota.obterNotasFaturadasDoDia(getEmpresaLogada(), getLojaLogada());
		try {
			caixa = ruleCaixa.findByIp(getLojaLogada(), getIp());
		} catch (Exception e) {
			HandleMessage.error("Erro ao incializar view", "Não foi possível obter o caixa pelo ip " + getIp() + ". Provavelmente "
					+ "esta estação não é um caixa válido");
			caixa = null;
		}
	}
	
	public RuleCancelamentoNota getRuleCancelamentoNota() {
		return ruleCancelamentoNota;
	}
	public void setRuleCancelamentoNota(RuleCancelamentoNota ruleCancelamentoNota) {
		this.ruleCancelamentoNota = ruleCancelamentoNota;
	}

	public Nota getSelectedNota() {
		return selectedNota;
	}
	public void setSelectedNota(Nota selectedNota) {
		this.selectedNota = selectedNota;
	}
	public List<Nota> getNotas() {
		return notas;
	}
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	public RuleNota getRuleNota() {
		return ruleNota;
	}
	public void setRuleNota(RuleNota ruleNota) {
		this.ruleNota = ruleNota;
	}
	
	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validar(Nota entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
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
	
	public EnumMotivoCancelamento[] getMotivoCancelamento() {
		return EnumMotivoCancelamento.values();
	}
	
	public void cancelar(Nota nota) {
		if(nota != null){
			String result = ruleCancelamentoNota.cancelarNotaNoSistema(getEmpresaLogada(), getLojaLogada(), caixa, nota);
			HandleMessage.info(result);
		}else{
			HandleMessage.errorValidacao("Nota veio com valor nulo.");
		}
	}

}
