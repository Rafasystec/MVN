package br.com.barcadero.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
@Repository
public class DaoLoja extends DaoModelo<Loja> {

	public DaoLoja() {
		
	}

	@Override
	public Loja find(long codigo) throws Exception {
		return find(codigo, Loja.class);
	}

	@Override
	public List<Loja> findAll() throws Exception {
		TypedQuery<Loja> qry = manager.createNamedQuery(Loja.FIND_ALL,Loja.class);
		qry.setParameter(GlobalNameParam.PARAM_COD_EMP, getEmpresa());
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
			if(empresa != null){
				Query qry = manager.createNamedQuery(Loja.FIND_BY_EMP);
				qry.setParameter(GlobalNameParam.PARAM_COD_EMP, empresa);
				return (List<Loja>)qry.getResultList();
			}else{
				return new ArrayList<>();
			}
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

	@Override
	public List<Loja> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loja> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
