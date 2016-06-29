package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.ParametrosSistema;
import br.com.barcadero.tables.ParametrosValores;

public class DaoParametros extends DaoModelo<ParametrosSistema> {

	public DaoParametros(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ParametrosSistema find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParametrosSistema> findAll() throws Exception {
		Query qry =  getSession().getNamedQuery(ParametrosSistema.FIND_ALL);
		return (List<ParametrosSistema>)qry.list();
	}
	
	@Deprecated
	public List<ParametrosSistema> findAll(boolean usarClasse) throws Exception {
		return findAll();
	}
	
	
	/**
	 * Inserir um parametro do sistema
	 * @param parametro
	 * @return
	 * @throws Exception
	 */
	public String insertParametro(ParametrosSistema parametro) throws Exception {
		insert(parametro);
		return getMSG_SUCESS_SAVE();
	}
	
	/**
	 * Inserir um valor para um parametro
	 * @param valor
	 * @return
	 * @throws Exception
	 */
	public String insertValorParametro(ParametrosValores valor) throws Exception {
		insert(valor);
		return getMSG_SUCESS_SAVE();
	}

}
