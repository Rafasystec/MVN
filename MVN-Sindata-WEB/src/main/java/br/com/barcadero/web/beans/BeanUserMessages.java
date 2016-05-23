package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.backoffice.RuleUserMensagem;
import br.com.systeconline.sindata.beans.SuperBean;
import br.com.systeconline.tables.basicos.UserMensagens;

@ManagedBean(name="userMessage")
@RequestScoped
public class BeanUserMessages extends SuperBean {

	private UserMensagens message;
	private RuleUserMensagem ruleMensagem;
	private static final long serialVersionUID = -2290317476489236357L;

	public BeanUserMessages() {
		// TODO Auto-generated constructor stub
		message = new UserMensagens(getEmpresaLogada(),getUsuarioLogado());
		ruleMensagem = new RuleUserMensagem(getDataBaseSession());
	}
	
	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enviar Mensagem ao usuario");
		ruleMensagem.insert(message);
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

	public UserMensagens getMessage() {
		return message;
	}

	public void setMessage(UserMensagens message) {
		this.message = message;
	}

}
