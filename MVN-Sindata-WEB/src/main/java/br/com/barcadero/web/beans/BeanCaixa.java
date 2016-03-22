package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;

import br.com.barcadero.rule.RuleCaixa;
import br.com.systeconline.sindata.beans.SuperBean;
import br.com.systeconline.tables.basicos.Caixa;

@ManagedBean(name="caixa")
public class BeanCaixa extends SuperBean {

	private static final long serialVersionUID = 6299768650271042835L;
	private Caixa caixa;
	private RuleCaixa ruleCaixa;
	
	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public RuleCaixa getRuleCaixa() {
		return ruleCaixa;
	}

	public void setRuleCaixa(RuleCaixa ruleCaixa) {
		this.ruleCaixa = ruleCaixa;
	}

	public BeanCaixa() {
		ruleCaixa = new RuleCaixa(getDataBaseSession());
	}
	
	@Override
	public String salvar() throws Exception {
		ruleCaixa.insert(caixa);
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

}
