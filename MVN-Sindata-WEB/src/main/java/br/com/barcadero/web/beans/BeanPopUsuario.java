package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.barcadero.rule.FacadeUsuario;
import br.com.barcadero.tables.Entidade;
/**
 * Para controlar a popup de usuario
 * @author Rafael Rocha
 * @since 1.0 dia 24/05/2016
 */
@ManagedBean(name="popUsuario")
@RequestScoped
public class BeanPopUsuario extends SuperBean {

	private FacadeUsuario fcdUsuario;
	private static final long serialVersionUID = 736684237610838273L;

	public BeanPopUsuario() {
		fcdUsuario = new FacadeUsuario(getDataBaseSession());
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
	
	public List<Entidade> getUsuarios() {
		try {
			return fcdUsuario.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Entidade>();
		}
	}
	public FacadeUsuario getFcdUsuario() {
		return fcdUsuario;
	}
	public void setFcdUsuario(FacadeUsuario fcdUsuario) {
		this.fcdUsuario = fcdUsuario;
	}

}
