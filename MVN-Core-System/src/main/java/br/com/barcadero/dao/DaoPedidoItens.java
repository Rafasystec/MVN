package br.com.barcadero.dao;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import br.com.barcadero.core.util.GlobalNameParam;
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
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @param pedido
	 * @return
	 */
	public List<PedidoItens> findByPedido(Pedido pedido) {
		Query qry = manager.createNamedQuery(PedidoItens.FIND_BY_PEDIDO)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo())
				.setParameter("pedido", pedido.getCodigo());
		return qry.getResultList();
	}

}
