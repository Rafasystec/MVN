package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.core.enums.EnumTipoCentroCusto;
import br.com.barcadero.rule.RuleCentroDeCusto;
import br.com.barcadero.tables.CentroDeCusto;
import br.com.barcadero.web.functions.HandleMessage;

@ManagedBean
@ViewScoped
public class BeanCentroDeCusto extends SuperBean<CentroDeCusto> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7283049865422413349L;
	@ManagedProperty("#{ruleCentroDeCusto}")
	private RuleCentroDeCusto ruleCentroDeCusto;
	private CentroDeCusto centroDeCusto;
	private CentroDeCusto selectedCentroDeCusto;
	
	@PostConstruct
	public void init() {
		novoCentroDeCusto(); 
	}
	
	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validar(CentroDeCusto entidade) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String salvar() throws Exception {
		if(validar(centroDeCusto)){
			ruleCentroDeCusto.insert(centroDeCusto);
			HandleMessage.info("Salvo com sucesso!");
			novoCentroDeCusto(); 
		}else{
			HandleMessage.error("Erro Validação conteúdo", "Erro Validação conteúdo");
		}
		return null;
	}

	private void novoCentroDeCusto() {
		centroDeCusto = new CentroDeCusto(getEmpresaLogada(),getUsuarioLogado());
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

	public RuleCentroDeCusto getRuleCentroDeCusto() {
		return ruleCentroDeCusto;
	}

	public void setRuleCentroDeCusto(RuleCentroDeCusto ruleCentroDeCusto) {
		this.ruleCentroDeCusto = ruleCentroDeCusto;
	}

	public CentroDeCusto getCentroDeCusto() {
		return centroDeCusto;
	}

	public void setCentroDeCusto(CentroDeCusto centroDeCusto) {
		this.centroDeCusto = centroDeCusto;
	}
	
	public EnumTipoCentroCusto[] getTipoCentroCusto() {
		return EnumTipoCentroCusto.values();
	}
	
	public List<CentroDeCusto> getAllCentroCusto() {
		try {
			return ruleCentroDeCusto.findByEmpresa(getEmpresaLogada());
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	public CentroDeCusto getSelectedCentroDeCusto() {
		return selectedCentroDeCusto;
	}

	public void setSelectedCentroDeCusto(CentroDeCusto selectedCentroDeCusto) {
		this.selectedCentroDeCusto = selectedCentroDeCusto;
	}

}
