package br.com.barcadero.web.beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.core.enums.EnumModeloNota;
import br.com.barcadero.rule.RuleCaixa;
import br.com.barcadero.tables.Caixa;

/**
 * Para a configuracao do caixa
 * @author Rafael Rocha
 * @since versao 1.0 dia 24/02/2016 as 11:04
 */
@ManagedBean(name="configCaixa")
@RequestScoped
public class BeanConfigCaixa extends SuperBean {

	private static final long serialVersionUID = 2575309545374375876L;
	private Caixa caixa;
	private RuleCaixa ruleCaixa;
	private EnumModeloNota[] tiposNota;
	private String ipAddress;
	
	public BeanConfigCaixa() {
		// TODO Auto-generated constructor stub
		caixa 		= new Caixa(getSession().getLojaLogada(),getSession().getUsuarioLogado());
		ruleCaixa	= new RuleCaixa(getEmpresaLogada(),getLojaLogada(),getDataBaseSession());
		System.out.println(BeanConfigCaixa.class + " was created!");
	}
	
	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Salvar caixa");
		caixa.setIp(getSession().getIpAddress());
		System.out.println("Retorno: " + ruleCaixa.insert(caixa)); 
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

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public EnumModeloNota[] getTiposNota() {
		this.tiposNota = EnumModeloNota.values();
		return tiposNota;
	}

	public void setTiposNota(EnumModeloNota[] tiposNota) {
		this.tiposNota = tiposNota;
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
