package br.com.barcadero.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class BeanLogin {
	private String usuario	= "";
	private String senha	= "";
	private final String SUCESSO = "sucesso";
	private final String ERRO	 = "erro";
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String logar() {
		try {
			if(String.valueOf("1") == "1"){
				//Se o login foi aceito
				return SUCESSO;
			}else{
				//Se nao foi aceito
				return null; //Retorna para a mesma pagina
			}
		} catch (Exception e) {
			// TODO: handle exception
			return ERRO;
		}
	}
	//desistir
	public String desistir() {
		try {
			return "desistir";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
