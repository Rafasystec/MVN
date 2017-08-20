package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.barcadero.rule.RuleCargaCidadesCE;
import br.com.barcadero.rule.RuleEstado;
import br.com.barcadero.rule.RuleParametros;
import br.com.barcadero.tables.macroentidades.EnderecoCarga;
/**
 * Para realizar a carga de algumas tabelas quando necessario.
 * @author Rafael Rocha
 * @since 1.0 - dia 15/02/2016 as 10:42
 */
@ManagedBean(name="carga")
public class BeanCargaInicial extends SuperBean <EnderecoCarga>{

	private static final long serialVersionUID = 1L;
	@ManagedProperty("#{ruleEstado}")
	private RuleEstado fcdEstado;
	@ManagedProperty("#{ruleCargaCidadesCE}")
	private RuleCargaCidadesCE handleCargaCidadesCE;
	@ManagedProperty("#{ruleParametros}")
	private RuleParametros	ruleParam;
		
	public String carregarEstados() throws Exception {
		fcdEstado.carregarEstados();
		return null;
	}
	
	public String carregarCidadesCeara() throws Exception {
		System.out.println("Execuntando a carga na tabela de Cidades do Ceara");
		handleCargaCidadesCE.loadCeara();
		System.out.println("Fim da carga");
		return null;
	}
	
	public String carregarParametros() {
		System.out.println("Iniciando a carga dos parametros");
		try {
			ruleParam.cargaDeParametros();
		} catch (Exception e) {
			System.out.println("Problema oa realizar a carga inicial dos parametros");
			e.printStackTrace();
		}
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

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public RuleEstado getFcdEstado() {
		return fcdEstado;
	}

	public void setFcdEstado(RuleEstado fcdEstado) {
		this.fcdEstado = fcdEstado;
	}

	public RuleParametros getRuleParam() {
		return ruleParam;
	}

	public void setRuleParam(RuleParametros ruleParam) {
		this.ruleParam = ruleParam;
	}

	public RuleCargaCidadesCE getHandleCargaCidadesCE() {
		return handleCargaCidadesCE;
	}

	public void setHandleCargaCidadesCE(RuleCargaCidadesCE handleCargaCidadesCE) {
		this.handleCargaCidadesCE = handleCargaCidadesCE;
	}

	@Override
	public boolean validar(EnderecoCarga entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
