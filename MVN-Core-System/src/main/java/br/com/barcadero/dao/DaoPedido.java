package br.com.barcadero.dao;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import br.com.barcadero.core.enums.EnumStatusPedido;
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
	
	public List<Pedido> findPedidosByDate(Date date) {
		Query qry = getSession().getNamedQuery(Pedido.FIND_BY_DATE)
				.setLong(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo())
				.setLong(GlobalNameParam.PARAM_COD_LOJA, getLoja().getCodigo())
				.setDate("dtCadastro", date);
		return qry.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> findPedidosAFaturarHoje(Date date) {
		return getSession().createCriteria(Pedido.class)
				//.createAlias("empresa", "emp")
				//.createAlias("empresa", "emp", JoinType.INNER_JOIN)
				.add(Restrictions.eq("dtCadastro", date))
				.add(Restrictions.eq("empresa", getEmpresa().getCodigo()))
				//.add(Restrictions.eq(GlobalNameParam.PARAM_COD_LOJA, getLoja().getCodigo()))
				.add(Restrictions.eq("flStPed",EnumStatusPedido.FECHADO))
				.addOrder(Property.forName("dtCadastro").asc())
				.list();
	}
	
	public List<Pedido> findPedidosAFaturarHoje() {
		Query qry = getSession().getNamedQuery(Pedido.FIND_AFATURAR)
				.setLong(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo())
				.setLong(GlobalNameParam.PARAM_COD_LOJA, getLoja().getCodigo())
				.setDate("dtCadastro", new Date())
				.setParameter("flStPed", EnumStatusPedido.FECHADO);
		return qry.list();		
	}
	
	public List<Pedido> findPedidosAFaturar(Date dtInicial, Date dtFinal) {
		StringBuilder builder = new StringBuilder();
		builder.append("FROM Pedido WHERE ")
			   .append(GlobalNameParam.PARAM_COD_EMP).append(" = :empresa").append(" AND ")
			   .append(GlobalNameParam.PARAM_COD_LOJA).append(" = :loja").append(" AND ")
			   .append("dtCadastro BETWEEN (").append(":dtInicial").append(" AND ").append(":dtFinal)").append(" AND ")
			   .append("flStPed = ").append(EnumStatusPedido.FECHADO);
		Query query = getSession().createQuery(builder.toString());
		query.setLong(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo())
			 .setLong(GlobalNameParam.PARAM_COD_LOJA, getLoja().getCodigo())
			 .setDate("dtInicial", dtInicial)
			 .setDate("dtFinal", dtFinal);
		return query.list();
	}

}
