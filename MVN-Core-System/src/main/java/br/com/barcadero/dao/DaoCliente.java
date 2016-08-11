package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Cliente;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

@Repository
public class DaoCliente extends DaoModelo<Cliente> {

	public DaoCliente() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Cliente find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> findAll() throws Exception {
		javax.persistence.Query qry = getManager().createNamedQuery(Cliente.FIND)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo());
		return qry.getResultList();
	}
	/**
	 * 
	 * @param codigo
	 * @param name
	 * @return
	 */
	public List<Cliente> findByCodeOrName(long codigo, String name) {
//		Query qry = getSession().getNamedQuery(Cliente.FIND_BY_NAME_OR_CODIGO)
//				.setLong(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo())
//				.setLong(GlobalNameParam.PARAM_DEFAULT_CODE_COLUMN, codigo)
//				.setString("nome", name);
//		return qry.list();
		return null;
	}

	@Override
	public List<Cliente> findByEmpresa(Empresa empresa) throws Exception {
		Query qry = getManager().createNamedQuery(Cliente.FIND)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, empresa);
		return qry.getResultList();
	}

	@Override
	public List<Cliente> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		Query qry = getManager().createNamedQuery(Cliente.FIND)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, empresa)
				.setParameter(GlobalNameParam.PARAM_COD_LOJA, loja);
		return qry.getResultList();
	}

	

}
