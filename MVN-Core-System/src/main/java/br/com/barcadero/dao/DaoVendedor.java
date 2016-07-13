package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Vendedor;

public class DaoVendedor extends DaoModelo <Vendedor>{

	public DaoVendedor(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Vendedor> findAll() throws Exception {
		Query qry = getSession().getNamedQuery(Vendedor.FIND_ALL)
				.setLong(Empresa.EMPRESA, empresa.getCodigo());
		
		return qry.list();
	}

	@Override
	public Vendedor find(long codigo) throws Exception {
		Query qry = getSession().getNamedQuery(Vendedor.FIND_BY_CODE)
				.setLong(Empresa.EMPRESA, empresa.getCodigo())
				.setLong("codigo", codigo);
		return (Vendedor) qry.uniqueResult();
	}
	
	public List<Vendedor> getByCodeOrApelido(long codigo, String apelido) {
		Query qry = getSession().getNamedQuery(Vendedor.FIND_BY_COD_OR_DESC)
				.setLong(Empresa.EMPRESA, empresa.getCodigo());
		qry.setLong("codigo", codigo)
		   .setString("apelido", apelido);
		return qry.list();
	}

}
