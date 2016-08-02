package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Cliente;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

public class DaoCliente extends DaoModelo<Cliente> {

	
	public DaoCliente(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cliente find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> findAll() throws Exception {
		Query qry = getSession().getNamedQuery(Cliente.FIND)
				.setLong(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo());
		return qry.list();
	}
	/**
	 * 
	 * @param codigo
	 * @param name
	 * @return
	 */
	public List<Cliente> findByCodeOrName(long codigo, String name) {
		Query qry = getSession().getNamedQuery(Cliente.FIND_BY_NAME_OR_CODIGO)
				.setLong(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo())
				.setLong(GlobalNameParam.PARAM_DEFAULT_CODE_COLUMN, codigo)
				.setString("nome", name);
		return qry.list();
	}

}
