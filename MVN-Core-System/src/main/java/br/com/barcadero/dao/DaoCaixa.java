package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

@Repository
public class DaoCaixa extends DaoModelo<Caixa> {

	public DaoCaixa() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Caixa find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		Query qry = manager.createNamedQuery(Caixa.FIND_BY_CODE).setParameter(Caixa.PARAM_CODE, codigo);
		return (Caixa) qry.getSingleResult();
	}

	public List<Caixa> findAll(Empresa empresa) throws Exception {
		Query qry = manager.createNamedQuery(Caixa.FIND_ALL)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, empresa.getCodigo());
		return qry.getResultList();
	}
	@Override
	public List<Caixa> findAll() throws Exception {
		javax.persistence.Query qry = manager.createNamedQuery(Caixa.FIND_ALL)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo());
		return qry.getResultList();
	}
	
	public List<Caixa> findAll(long codigo) {
		Query qry = manager.createNamedQuery(Caixa.FIND_ALL);
		qry.setParameter(GlobalNameParam.PARAM_COD_EMP, codigo);
		return qry.getResultList();
	}
	
	/**
	 * Procura o caixa pelo ip
	 * @param cdLoja
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public Caixa findByIp(Loja loja, String ip) throws Exception{
		try{
			Query qry = manager.createNamedQuery(Caixa.FIND_BY_IP)
					.setParameter(GlobalNameParam.PARAM_COD_LOJA, loja)
					.setParameter(Caixa.PARAM_IP, ip);
			return (Caixa) qry.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	public List<Caixa> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Caixa> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

