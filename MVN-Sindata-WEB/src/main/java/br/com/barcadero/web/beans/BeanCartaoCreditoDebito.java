package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.core.enums.EnumCartaoBandeira;
import br.com.barcadero.core.enums.EnumTipoCartao;
import br.com.barcadero.core.enums.EnumTipoContaCartao;
import br.com.barcadero.rule.RuleBancos;
import br.com.barcadero.rule.RuleCartaoDebitoCredito;
import br.com.barcadero.tables.Bancos;
import br.com.barcadero.tables.CartaoCreditoDebito;
import br.com.barcadero.web.functions.HandleMessage;

@ManagedBean
@ViewScoped
public class BeanCartaoCreditoDebito extends SuperBean<CartaoCreditoDebito>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9085132960174975814L;
	@ManagedProperty("#{ruleCartaoDebitoCredito}")
	private RuleCartaoDebitoCredito ruleCartaoDebitoCredito;
	@ManagedProperty("#{ruleBancos}")
	private RuleBancos ruleBancos;
	
	private CartaoCreditoDebito cartaoCreditoDebito;
	
	@PostConstruct
	public void init() {
		cartaoCreditoDebito = new CartaoCreditoDebito(getEmpresaLogada());
	}
	
	public RuleCartaoDebitoCredito getRuleCartaoDebitoCredito() {
		return ruleCartaoDebitoCredito;
	}
	public void setRuleCartaoDebitoCredito(RuleCartaoDebitoCredito ruleCartaoDebitoCredito) {
		this.ruleCartaoDebitoCredito = ruleCartaoDebitoCredito;
	}
	public CartaoCreditoDebito getCartaoCreditoDebito() {
		return cartaoCreditoDebito;
	}
	public void setCartaoCreditoDebito(CartaoCreditoDebito cartaoCreditoDebito) {
		this.cartaoCreditoDebito = cartaoCreditoDebito;
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validar(CartaoCreditoDebito entidade) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String salvar() throws Exception {

		if(validar(cartaoCreditoDebito)){
			ruleCartaoDebitoCredito.insert(cartaoCreditoDebito);
			cartaoCreditoDebito = new CartaoCreditoDebito(getEmpresaLogada());
			HandleMessage.info("Salvo com sucesso!");
		}
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

	public RuleBancos getRuleBancos() {
		return ruleBancos;
	}

	public void setRuleBancos(RuleBancos ruleBancos) {
		this.ruleBancos = ruleBancos;
	}
	
	public List<Bancos> getAllBancosEmpresa() {
		try {
			return ruleBancos.findByEmpresa(getEmpresaLogada());
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}
	
	public EnumCartaoBandeira[] getBandeiras() {
		return EnumCartaoBandeira.values();
	}
	
	public EnumTipoCartao[] getTipoCartao() {
		return EnumTipoCartao.values();
	}
	
	public EnumTipoContaCartao[] getTipoContaCartao() {
		return EnumTipoContaCartao.values();
	}
	
	public int[] getDiaVencimentoCombo() {
		int[] result = {1,2,3,4,5,6,7,8,9,10,
						11,12,13,14,15,16,17,18,19,20,
						21,22,23,24,25,26,27,28,29,30,31};
		return result;
	}
	
}
