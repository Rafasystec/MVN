package br.com.barcadero.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import br.com.barcadero.core.enums.EnumStatusPedido;
import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Cliente;
import br.com.barcadero.tables.Pedido;

@Repository
public class DaoPedido extends DaoModelo<Pedido> {

	public DaoPedido() {
		System.out.println("Auto-generated constructor stub DaoPedido");
	}
//	public DaoPedido(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pedido> findAll() throws Exception {
		Query qry = manager.createNamedQuery(Pedido.FIND_ALL)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo());
		return qry.getResultList();
	}

	@Override
	public Pedido find(long codigo) throws Exception {
		Query qry = manager.createNamedQuery(Pedido.FIND_BY_CODE)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo())
				.setParameter("codigo", codigo);
		return (Pedido) qry.getSingleResult();
	}
	/**
	 * Todos os pedidos de um cliente da empresa
	 * @param cliente
	 * @return
	 */
	public List<Pedido> findByCliente(Cliente cliente) {
		Query qry = manager.createNamedQuery(Pedido.FIND_BY_CLIENTE)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo())
				.setParameter("cliente", cliente.getCodigo());
		return qry.getResultList();
	}
	
	public List<Pedido> findPedidosByDate(Date date) {
		Query qry = manager.createNamedQuery(Pedido.FIND_BY_DATE)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo())
				.setParameter(GlobalNameParam.PARAM_COD_LOJA, getLoja().getCodigo())
				.setParameter("dtCadastro", date);
		return qry.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> findPedidosAFaturarHoje(Date date) {
//		return manager.getCriteriaBuilder(). Criteria(Pedido.class)
//				//.createAlias("empresa", "emp")
//				//.createAlias("empresa", "emp", JoinType.INNER_JOIN)
//				.add(Restrictions.eq("dtCadastro", date))
//				.add(Restrictions.eq("empresa", getEmpresa().getCodigo()))
//				//.add(Restrictions.eq(GlobalNameParam.PARAM_COD_LOJA, getLoja().getCodigo()))
//				.add(Restrictions.eq("flStPed",EnumStatusPedido.FECHADO))
//				.addOrder(Property.forName("dtCadastro").asc())
//				.list();
		return null;
	}
	
	public List<Pedido> findPedidosAFaturarHoje() {
		Query qry = manager.createNamedQuery(Pedido.FIND_AFATURAR)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo())
				.setParameter(GlobalNameParam.PARAM_COD_LOJA, getLoja().getCodigo())
				.setParameter("dtCadastro", new Date())
				.setParameter("flStPed", EnumStatusPedido.FECHADO);
		return qry.getResultList();		
	}
	
	public List<Pedido> findPedidosAFaturar(Date dtInicial, Date dtFinal) {
		StringBuilder builder = new StringBuilder();
		builder.append("FROM Pedido WHERE ")
			   .append(GlobalNameParam.PARAM_COD_EMP).append(" = :empresa").append(" AND ")
			   .append(GlobalNameParam.PARAM_COD_LOJA).append(" = :loja").append(" AND ")
			   .append("dtCadastro BETWEEN (").append(":dtInicial").append(" AND ").append(":dtFinal)").append(" AND ")
			   .append("flStPed = ").append(EnumStatusPedido.FECHADO);
		Query query = manager.createQuery(builder.toString());
		query.setParameter(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo())
			 .setParameter(GlobalNameParam.PARAM_COD_LOJA, getLoja().getCodigo())
			 .setParameter("dtInicial", dtInicial)
			 .setParameter("dtFinal", dtFinal);
		return query.getResultList();
	}

}
