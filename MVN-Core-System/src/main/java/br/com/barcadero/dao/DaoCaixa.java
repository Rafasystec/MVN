package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.Entidade;

public class DaoCaixa extends DaoModelo {

	public DaoCaixa(Session session) {
		super(session);
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		Query qry = getSession().getNamedQuery(Caixa.FIND_BY_CODE).setParameter(Caixa.PARAM_CODE, codigo);
		return (Entidade) qry.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Deprecated
	@Override
	public List<Entidade> findAll() throws Exception {
		Query qry = getSession().getNamedQuery(Caixa.FIND_ALL);
		return qry.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Caixa> findAll(long cdEmp) {
		Query qry = getSession().getNamedQuery(Caixa.FIND_ALL);
		qry.setParameter("cdEmp", cdEmp);
		return qry.list();
	}
	
	/**
	 * Procura o caixa pelo ip
	 * @param cdLoja
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public Caixa findByIp(long cdLoja, String ip) throws Exception{
		Query qry = getSession().getNamedQuery(Caixa.FIND_BY_IP)
				.setParameter(Caixa.PARAM_CD_LOJA, cdLoja)
				.setParameter(Caixa.PARAM_IP, ip);
		return (Caixa) qry.uniqueResult();
	}

}

