package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;

import br.com.barcadero.core.enums.EnumTipoContaPagar;
import br.com.barcadero.rule.RuleContaPagar;
import br.com.barcadero.tables.ContaPagar;
/**
 * Bean para as contas a pagar
 * @author Rafael Rocha
 * @since 1.0 dia 21/02/2016 21:45
 */
@ManagedBean(name="contaPagar")
public class BeanContaPagar extends SuperBean {

	private static final long serialVersionUID = -4716441225911437900L;
	private ContaPagar contaPagar;
	private RuleContaPagar ruleContaPagar;
	private EnumTipoContaPagar[] tipoConta;
	public BeanContaPagar() {
		// TODO Auto-generated constructor stub
		contaPagar 		= new ContaPagar(getSession().getLojaLogada(),getSession().getUsuarioLogado());
		ruleContaPagar 	= new RuleContaPagar(getEmpresaLogada(),getLojaLogada(),getDataBaseSession());
	}
	
	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		return ruleContaPagar.insert(contaPagar);
	}

	@Override
	public String alterar() throws Exception {
		// TODO Auto-generated method stub
		return ruleContaPagar.update(contaPagar);
	}

	@Override
	public String deletar() throws Exception {
		// TODO Auto-generated method stub
		return ruleContaPagar.delete(contaPagar.getCodigo());
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

	public void setTipoConta(EnumTipoContaPagar[] tipoConta) {
		this.tipoConta = tipoConta;
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
