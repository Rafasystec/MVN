package br.com.barcadero.web.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;

import br.com.barcadero.tables.Pedido;

@ManagedBean(name="pedido")
@ViewScoped
public class BeanPedidoVenda extends SuperBean{


	private static final long serialVersionUID = -1991283788493039890L;
	private Pedido pedido;
	private String vededor;
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

	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getVededor() {
		return vededor;
	}

	public void setVededor(String vededor) {
		this.vededor = vededor;
	}
}
