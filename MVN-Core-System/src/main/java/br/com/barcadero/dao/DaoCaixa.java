package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

public class DaoCaixa extends DaoModelo<Caixa> {

	

	public DaoCaixa(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Caixa find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		Query qry = getSession().getNamedQuery(Caixa.FIND_BY_CODE).setLong(Caixa.PARAM_CODE, codigo);
		return (Caixa) qry.uniqueResult();
	}

	@Override
	public List<Caixa> findAll() throws Exception {
		Query qry = getSession().getNamedQuery(Caixa.FIND_ALL)
				.setLong(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo());
		return qry.list();
	}
	
	public List<Caixa> findAll(long codigo) {
		Query qry = getSession().getNamedQuery(Caixa.FIND_ALL);
		qry.setLong(GlobalNameParam.PARAM_COD_EMP, codigo);
		return qry.list();
	}
	
	/**
	 * Procura o caixa pelo ip
	 * @param cdLoja
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public Caixa findByIp(long loja, String ip) throws Exception{
		Query qry = getSession().getNamedQuery(Caixa.FIND_BY_IP)
				.setLong(GlobalNameParam.PARAM_COD_LOJA, loja)
				.setString(Caixa.PARAM_IP, ip);
		return (Caixa) qry.uniqueResult();
	}

}

