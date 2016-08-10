package br.com.barcadero.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
@Repository
public class DaoLoja extends DaoModelo<Loja> {

	public DaoLoja() {
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
		Query qry = manager.createNamedQuery(Loja.FIND_ALL);
		qry.setParameter(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo());
		return qry.getResultList();
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
			Query qry = manager.createNamedQuery(Loja.FIND_BY_EMP);
			qry.setParameter(GlobalNameParam.PARAM_COD_EMP, getEmpresa());
			return (List<Loja>)qry.getResultList();
		}catch(Exception e){
			return new ArrayList<Loja>();
		}
	}
	
	public List<Loja> getLojasDaEmpresa(Empresa empresa) throws Exception{
		try{
			Query qry = manager.createNamedQuery(Loja.FIND_BY_EMP);
			qry.setParameter(GlobalNameParam.PARAM_COD_EMP, empresa);
			return (List<Loja>)qry.getResultList();
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
		Query qry = manager.createNamedQuery(Loja.FIND_BY_EMP);
		qry.setParameter(GlobalNameParam.PARAM_COD_EMP, empresa.getCodigo());
		return (List<Loja>)qry.getResultList();
	}

}
