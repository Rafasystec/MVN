package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.rule.RuleBancos;
import br.com.barcadero.tables.Bancos;
import br.com.barcadero.web.functions.HandleMessage;
@ManagedBean
@ViewScoped
public class BeanBanco extends SuperBean<Bancos> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6947393610875835395L;
	private Bancos banco;
	private Bancos selectedBanco;
	@ManagedProperty("#{ruleBancos}")
	private RuleBancos ruleBancos;
	
	@PostConstruct
	public void init() {
		banco = new Bancos(getEmpresaLogada());
	}
	
	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validar(Bancos entidade) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String salvar() throws Exception {
		if(validar(banco)){
			ruleBancos.insert(banco);
			banco = new Bancos(getEmpresaLogada());
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

	public Bancos getBanco() {
		return banco;
	}

	public void setBanco(Bancos banco) {
		this.banco = banco;
	}

	public RuleBancos getRuleBancos() {
		return ruleBancos;
	}

	public void setRuleBancos(RuleBancos ruleBancos) {
		this.ruleBancos = ruleBancos;
	}
	
	public List<Bancos> getAll() {
		try {
			return ruleBancos.findByEmpresa(getEmpresaLogada());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return new ArrayList<>();
		}
	}

	public Bancos getSelectedBanco() {
		return selectedBanco;
	}

	public void setSelectedBanco(Bancos selectedBanco) {
		this.selectedBanco = selectedBanco;
	}

}
