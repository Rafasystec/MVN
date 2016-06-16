package br.com.barcadero.web.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import br.com.barcadero.tables.Usuario;

@ManagedBean(name="index")
public class BeanIndex implements Serializable{

	private static final long serialVersionUID = -8956924425290321691L;
	private String userName;
	private boolean isLogado;
	private Usuario user;
	
	public BeanIndex() {
		// TODO Auto-generated constructor stub
		System.out.println("Bean index was created");
	}
	
	
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}


	public boolean isLogado() {
		return isLogado;
	}

	public void setLogado(boolean isLogado) {
		this.isLogado = isLogado;
	}

	public String getUserName() {
		
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
//	
//	public void getUsuarioLogado() {
//		try{
//			if(SessionContext.getInstance().getUsuarioLogado() != null){
//				user = SessionContext.getInstance().getUsuarioLogado();
//				isLogado = true;
//				userName = user.getNome();
//			}else{
//				user 	 = new Usuario();
//				isLogado = false;
//				userName = "";
//			}
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
	
	public String logOut() throws IOException {
		SessionContext.getInstance().encerrarSessao();
		SessionContext.getInstance().redirectToLogin();
		System.out.println("Sessao encerrada. Indo para o login.");
		return null;
	}

}
