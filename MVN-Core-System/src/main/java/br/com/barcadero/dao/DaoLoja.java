package br.com.barcadero.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

public class DaoLoja extends DaoModelo<Loja> {

	public DaoLoja(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Loja find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loja> findAll() throws Exception {
		// TODO Auto-generated method stub
		Query qry = getSession().getNamedQuery(Loja.FIND_ALL);
		qry.setLong(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo());
		return qry.list();
	}
	
	/**
	 * Obter todas as lojas de uma determinada empresa.Utilize o metodo getLoja da mesma DAO
	 * @param cdEmp
	 * @return
	 * @throws Exception
	 */
	@Deprecated
	public List<Loja> getLojasDaEmpresa(long cdEmp) throws Exception{
		try{
			Query qry = getSession().getNamedQuery(Loja.FIND_BY_EMP);
			qry.setLong(GlobalNameParam.PARAM_COD_EMP, cdEmp);
			return (List<Loja>)qry.list();
		}catch(Exception e){
			return new ArrayList<Loja>();
		}
		
	}
	/**
	 * 
	 * @param empresa
	 * @return
	 * @throws Exception
	 */
	public List<Loja> getLojas(Empresa empresa) throws Exception{
		Query qry = getSession().getNamedQuery(Loja.FIND_BY_EMP);
		qry.setParameter(GlobalNameParam.PARAM_COD_EMP, empresa.getCodigo());
		return (List<Loja>)qry.list();
	}

}
