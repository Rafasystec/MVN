package br.com.barcadero.web.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleCaixaAbertura;
import br.com.barcadero.tables.CaixaAbertura;

@ManagedBean
@RequestScoped
public class BeanAbrirCaixa extends SuperBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7436825363700179568L;
	private CaixaAbertura caixaAbertura 		= null;
	@ManagedProperty("#{ruleCaixaAbertura}")
	private RuleCaixaAbertura ruleCaixaAbertura;
	
	@PostConstruct
	public void init() {
		this.setCaixaAbertura(getCaixaAberturaInstance());
		if(ruleCaixaAbertura != null){
			ruleCaixaAbertura.setEmpresa(getEmpresaLogada());
			ruleCaixaAbertura.setLoja(getLojaLogada());
		}
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public String salvar() throws Exception {
//		try{
//			String ret = ruleCaixaAbertura.insert(HandleFaceContext.getIpAddress(), caixaAbertura);
//			System.out.println(ret);
//			HandleMessage.info("Caixa aberto com sucesso!");
//			caixaAbertura = getCaixaAberturaInstance();
//		}catch(Exception e){
//			HandleMessage.error("Erro ao abrir o caixa", e.getMessage());
//		}
//		return null;
//	}

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

	public CaixaAbertura getCaixaAbertura() {
		return caixaAbertura;
	}

	public void setCaixaAbertura(CaixaAbertura caixaAbertura) {
		this.caixaAbertura = caixaAbertura;
	}
	
	private CaixaAbertura getCaixaAberturaInstance() {
		return new CaixaAbertura(getEmpresaLogada(),getLojaLogada(), getUsuarioLogado());
	}

	public RuleCaixaAbertura getRuleCaixaAbertura() {
		return ruleCaixaAbertura;
	}

	public void setRuleCaixaAbertura(RuleCaixaAbertura ruleCaixaAbertura) {
		this.ruleCaixaAbertura = ruleCaixaAbertura;
	}

	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
