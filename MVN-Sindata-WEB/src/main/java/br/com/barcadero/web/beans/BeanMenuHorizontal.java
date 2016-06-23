package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.RuleUserMensagem;
import br.com.barcadero.tables.TmpUserMessage;

@ManagedBean(name="menuHorizontal")
@RequestScoped
public class BeanMenuHorizontal extends SuperBean {

	private static final long serialVersionUID = 138203880609210500L;
	private RuleUserMensagem ruleMensagem;
	public BeanMenuHorizontal() {
		// TODO Auto-generated constructor stub
		ruleMensagem = new RuleUserMensagem(getDataBaseSession());
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
	
	public List<TmpUserMessage> getMensagens() throws Exception {
		if(getUsuarioLogado() != null){
			return ruleMensagem.getMensagens(getUsuarioLogado());
		}else{
			return new ArrayList<TmpUserMessage>();
		}
	}

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
