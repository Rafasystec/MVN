package br.com.barcadero.frameworks.test.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoPedido;
import br.com.barcadero.frameworks.test.HandleEmpresaLoja;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Pedido;
import br.com.barcadero.test.db.HibernateHelper;

public class TestDaoPedido  {

	
	public static void main(String[] args) {
		TestDaoPedido test = new TestDaoPedido();
		test.testCriteria();
	}
	DaoPedido daoPedido;

	public TestDaoPedido() {
		//daoPedido = new DaoPedido(HandleEmpresaLoja.getEmpresa(), HandleEmpresaLoja.getLoja(), HibernateHelper.getSession());
	}
	
	public TestDaoPedido(Empresa empresa, Loja loja, Session session) {
		
		
	}

	
	public List<Pedido> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Pedido find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void testCriteria() {
		List<Pedido> findPedidosAFaturarHoje = daoPedido.findPedidosAFaturarHoje();
		for (Pedido pedido : findPedidosAFaturarHoje) {
			System.out.println("Codigo: " + pedido.getCodigo());
			System.out.println("Empresa: " + pedido.getEmpresa().getCodigo());
		}
	}
	

}
