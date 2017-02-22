package br.com.barcadero.web.beans;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.commons.enuns.EnumTipoModuloSAT;
import br.com.barcadero.core.enums.EnumModeloNota;
import br.com.barcadero.rule.RuleCaixa;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.web.functions.HandleMessage;

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
	private Caixa selectedCaixa;
	private List<Caixa> caixas;
	@ManagedProperty(name="ruleCaixa",value="#{ruleCaixa}")
	private RuleCaixa ruleCaixa;
	private EnumModeloNota[] tiposNota;
	private EnumTipoModuloSAT[] modulosSAT;
	private String ipAddress;
	
	public BeanConfigCaixa() {
		// TODO Auto-generated constructor stub
		caixa 		= new Caixa(getEmpresaLogada(),getLojaLogada(),getUsuarioLogado());
		//ruleCaixa	= new RuleCaixa(getEmpresaLogada(),getLojaLogada(),getDataBaseSession());
		System.out.println(BeanConfigCaixa.class + " was created!");
	}
	
	@Override
	public String salvar() {
		try{
			// TODO Auto-generated method stub
			System.out.println("Salvar caixa");
			caixa.setIp(getSession().getIpAddress());
			String ret = ruleCaixa.insert(caixa);
			System.out.println("Retorno: " + ret);
			HandleMessage.info(ret);
		}catch(Exception e){
			HandleMessage.error("Erro ao tentar salvar o caixa: ", e.getMessage());
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

	public List<Caixa> getCaixas() {
		try {
			//this.caixas = ruleCaixa.findAll();
			this.caixas = ruleCaixa.findAll(getEmpresaLogada());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return caixas;
	}

	public void setCaixas(List<Caixa> caixas) {
		this.caixas = caixas;
	}

	public Caixa getSelectedCaixa() {
		return selectedCaixa;
	}

	public void setSelectedCaixa(Caixa selectedCaixa) {
		this.selectedCaixa = selectedCaixa;
	}

	public EnumTipoModuloSAT[] getModulosSAT() {
		return EnumTipoModuloSAT.values();
	}

	public void setModulosSAT(EnumTipoModuloSAT[] modulosSAT) {
		this.modulosSAT = modulosSAT;
	}

	public RuleCaixa getRuleCaixa() {
		return ruleCaixa;
	}

	public void setRuleCaixa(RuleCaixa ruleCaixa) {
		this.ruleCaixa = ruleCaixa;
	}
	

}
