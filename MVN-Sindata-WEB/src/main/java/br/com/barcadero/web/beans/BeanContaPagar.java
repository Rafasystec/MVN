package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.core.enums.EnumTipoContaPagar;
import br.com.barcadero.rule.RuleContaPagar;
import br.com.barcadero.tables.ContaPagar;
/**
 * Bean para as contas a pagar
 * @author Rafael Rocha
 * @since 1.0 dia 21/02/2016 21:45
 */
@ManagedBean
@ViewScoped
public class BeanContaPagar extends SuperBean<ContaPagar> {

	private static final long serialVersionUID = -4716441225911437900L;
	private ContaPagar contaPagar;
	@ManagedProperty("#{ruleContaPagar}")
	private RuleContaPagar ruleContaPagar;
	
	@PostConstruct
	public void init() {
		contaPagar 		= new ContaPagar(getSession().getLojaLogada(),getSession().getUsuarioLogado());//
	}

	@Override
	public String deletar() throws Exception {
		ruleContaPagar.delete(contaPagar.getCodigo());
		return null;
	}

	@Override
	public String novo() throws Exception {
		// TODO Auto-generated method stub
		contaPagar = new ContaPagar(getSession().getLojaLogada(),getSession().getUsuarioLogado());
		return "";
	}

	public ContaPagar getContaPagar() {
		return contaPagar;
	}

	public void setContaPagar(ContaPagar contaPagar) {
		this.contaPagar = contaPagar;
	}

	public EnumTipoContaPagar[] getTipoConta() {
		return EnumTipoContaPagar.values();
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salvar() throws Exception {
		ruleContaPagar.insert(contaPagar);
		return null;
	}

	@Override
	public String alterar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public RuleContaPagar getRuleContaPagar() {
		return ruleContaPagar;
	}

	public void setRuleContaPagar(RuleContaPagar ruleContaPagar) {
		this.ruleContaPagar = ruleContaPagar;
	}

	@Override
	public boolean validar(ContaPagar entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<ContaPagar> getContasAPagarDesteMes() {
		try {
			return ruleContaPagar.findByEmpresa(getEmpresaLogada());
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}
	

}
