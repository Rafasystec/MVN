package br.com.barcadero.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
		return find(codigo, Cliente.class);
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
	public List<Cliente> findByCodeOrName(Empresa empresa,long codigo, String name) {
		TypedQuery<Cliente> qry = manager.createNamedQuery(Cliente.FIND_BY_NAME_OR_CODIGO, Cliente.class)
				
				.setParameter(GlobalNameParam.PARAM_DEFAULT_CODE_COLUMN, codigo)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, empresa)
				.setParameter("nome", name);
		qry.getResultList();
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
		TypedQuery<Cliente> qry = getManager().createNamedQuery(Cliente.FIND,Cliente.class)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, empresa)
				.setParameter(GlobalNameParam.PARAM_COD_LOJA, loja);
		return qry.getResultList();
	}
	
	public List<Cliente> conasultarClientesCadastradosDoDia(Empresa empresa) {
		TypedQuery<Cliente> qry = manager.createNamedQuery(Cliente.FIND_CLIENTES_CAD_HOJE, Cliente.class)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, empresa)
				.setParameter(GlobalNameParam.PARAM_DT_CADASTRO, new Date());
		
		return qry.getResultList();
	}

	

}
