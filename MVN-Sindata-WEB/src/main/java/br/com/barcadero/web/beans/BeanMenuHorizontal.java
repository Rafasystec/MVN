package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.backoffice.RuleUserMensagem;
import br.com.systeconline.sindata.beans.SuperBean;
import br.com.systeconline.tables.basicos.UserMensagens;

@ManagedBean(name="menuHorizontal")
@RequestScoped
public class BeanMenuHorizontal extends SuperBean {

	private static final long serialVersionUID = 138203880609210500L;
	private RuleUserMensagem ruleMensagem;
	public BeanMenuHorizontal() {
		// TODO Auto-generated constructor stub
		ruleMensagem = new RuleUserMensagem(getDataBaseSession());
		ruleMensagem.consultarMensagens();
		
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
	
	public List<UserMensagens> getMensagens() {
		List<UserMensagens> mensagens = new ArrayList<UserMensagens>();
		UserMensagens msg1 = new UserMensagens();
		msg1.setMensagem("Ola pessoal");
		UserMensagens msg2 = new UserMensagens();
		msg2.setMensagem("Ola pessoal 2");
		mensagens.add(msg1);
		mensagens.add(msg2);
		return mensagens;
	}

}
