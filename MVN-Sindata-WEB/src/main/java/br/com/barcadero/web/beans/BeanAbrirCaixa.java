package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleCaixaAbertura;
import br.com.barcadero.tables.CaixaAbertura;
import br.com.barcadero.web.functions.HandleFaceContext;
import br.com.barcadero.web.functions.HandleMessage;

@ManagedBean
@RequestScoped
public class BeanAbrirCaixa extends SuperBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7436825363700179568L;
	private CaixaAbertura caixaAbertura 		= null;
	private RuleCaixaAbertura ruleCaixaAbertura = null;
	
	public BeanAbrirCaixa() {
		// TODO Auto-generated constructor stub
		caixaAbertura 		= getCaixaAberturaInstance();
		ruleCaixaAbertura	= new RuleCaixaAbertura(getEmpresaLogada(), getLojaLogada(), getDataBaseSession());
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salvar() throws Exception {
		try{
			String ret = ruleCaixaAbertura.insert(HandleFaceContext.getIpAddress(), caixaAbertura);
			System.out.println(ret);
			HandleMessage.info("Caixa aberto com sucesso!");
			caixaAbertura = getCaixaAberturaInstance();
			
		}catch(Exception e){
			HandleMessage.error("Erro ao abrir o caixa", e.getMessage());
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

	public CaixaAbertura getCaixaAbertura() {
		return caixaAbertura;
	}

	public void setCaixaAbertura(CaixaAbertura caixaAbertura) {
		this.caixaAbertura = caixaAbertura;
	}
	
	private CaixaAbertura getCaixaAberturaInstance() {
		return new CaixaAbertura(getEmpresaLogada(),getLojaLogada(), getUsuarioLogado());
	}

}
