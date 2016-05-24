package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.event.SelectEvent;
import br.com.barcadero.rule.backoffice.RuleUserMensagem;
import br.com.systeconline.rule.FacadeUsuario;
import br.com.systeconline.sindata.beans.SuperBean;
import br.com.systeconline.tables.basicos.UserMensagens;
import br.com.systeconline.tables.basicos.Usuario;

@ManagedBean(name="userMessage")
@RequestScoped
public class BeanUserMessages extends SuperBean {

	private UserMensagens message;
	private RuleUserMensagem ruleMensagem;
	private FacadeUsuario fcdUsuario;
	private String paramEmail;
	private static final long serialVersionUID = -2290317476489236357L;

	public BeanUserMessages() {
		// TODO Auto-generated constructor stub
		message 	 = new UserMensagens(getEmpresaLogada(),getUsuarioLogado());
		ruleMensagem = new RuleUserMensagem(getDataBaseSession());
		fcdUsuario	 = new FacadeUsuario(getDataBaseSession());
	}
	
	@Override
	public String salvar() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enviar Mensagem ao usuario");
		Usuario user = fcdUsuario.findByEmail(paramEmail);
		message.setCdUserReceive(user.getCodigo());
		ruleMensagem.insert(message);
		return null;
	}

	public List<String> completeText(String query)  {
		try {
			return ruleMensagem.getNomeEmail(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<String>();
		}
    }
	
	public void onItemSelect(SelectEvent event) {
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
		String selected = event.getObject().toString();
		System.out.println( selected);
		String[] split = selected.split(" - ");
		if(split != null && split.length > 1){
			paramEmail = split[1];
		}
		
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

	public String getParamConsultar() {
		return paramEmail;
	}

	public void setParamConsultar(String paramConsultar) {
		this.paramEmail = paramConsultar;
	}

}
