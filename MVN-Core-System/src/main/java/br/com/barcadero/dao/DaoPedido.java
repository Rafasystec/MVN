package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Cliente;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Pedido;

public class DaoPedido extends DaoModelo<Pedido> {

	public DaoPedido(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> findAll() throws Exception {
		Query qry = getSession().getNamedQuery(Pedido.FIND_ALL)
				.setLong(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo());
		return qry.list();
	}

	@Override
	public Pedido find(long codigo) throws Exception {
		Query qry = getSession().getNamedQuery(Pedido.FIND_BY_CODE)
				.setLong(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo())
				.setLong("codigo", codigo);
		return (Pedido) qry.uniqueResult();
	}
	/**
	 * Todos os pedidos de um cliente da empresa
	 * @param cliente
	 * @return
	 */
	public List<Pedido> findByCliente(Cliente cliente) {
		Query qry = getSession().getNamedQuery(Pedido.FIND_BY_CLIENTE)
				.setLong(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo())
				.setLong("cliente", cliente.getCodigo());
		return qry.list();
	}

}
