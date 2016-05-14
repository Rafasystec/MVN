package br.com.barcadero.web.beans;

import java.net.UnknownHostException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;

import br.com.systeconline.sindata.beans.SuperBean;
import br.com.systeconline.tables.frontend.Pedido;

@ManagedBean(name="pedido")
@ViewScoped
public class BeanPedidoVenda extends SuperBean{

	private Pedido pedido;
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	private Session session;
	public BeanPedidoVenda() {
		// TODO Auto-generated constructor stub
		session = getDBSessionForViewScope();
	}
	
	@PostConstruct
	public void init() {
		System.out.println("@PostConstruct method init");
		try {
			if(this.session != null){
				this.session.beginTransaction();
			}
			this.pedido = new Pedido();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
}
