package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleCFeComandos;
import br.com.barcadero.web.functions.HandleMessage;

@ManagedBean
@RequestScoped
public class BeanCFeFuncoes extends SuperBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1980102755925943350L;
	private RuleCFeComandos ruleCFeComandos;
	
	public BeanCFeFuncoes() {
		ruleCFeComandos = new RuleCFeComandos(getCaixaVenda());
	}
	
	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
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
	
	public void consultarSAT() {
		try {
			String retSAT = ruleCFeComandos.consultarSAT(021524);
			HandleMessage.info("Retorno do Módulo: ", retSAT);
		} catch (Exception e) {
			HandleMessage.error("Erro a tentar consultar o SAT", e.getMessage());
		}
	}

}
