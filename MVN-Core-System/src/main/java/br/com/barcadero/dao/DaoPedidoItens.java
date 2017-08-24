package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Pedido;
import br.com.barcadero.tables.PedidoItens;

@Repository
public class DaoPedidoItens extends DaoModelo<PedidoItens> {

	public DaoPedidoItens() {
		System.out.println("Auto-generated constructor stub DaoPedidoItens");
	}
//	public DaoPedidoItens(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//	}

	@Override
	public List<PedidoItens> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoItens find(long codigo) throws Exception {
		return find(codigo, PedidoItens.class);
	}
	
	/**
	 * 
	 * @param pedido
	 * @return
	 */
	public List<PedidoItens> findByPedido(Pedido pedido) {
		TypedQuery<PedidoItens> qry = manager.createNamedQuery(PedidoItens.FIND_BY_PEDIDO,PedidoItens.class)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, pedido.getEmpresa())
				.setParameter("pedido", pedido);
		return qry.getResultList();
	}

	@Override
	public List<PedidoItens> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoItens> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
