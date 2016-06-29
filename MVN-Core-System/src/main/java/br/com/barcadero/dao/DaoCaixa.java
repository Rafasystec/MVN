package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
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
		Query qry = getSession().getNamedQuery(Caixa.FIND_BY_CODE).setParameter(Caixa.PARAM_CODE, codigo);
		return (Caixa) qry.uniqueResult();
	}

	@Override
	public List<Caixa> findAll() throws Exception {
		Query qry = getSession().getNamedQuery(Caixa.FIND_ALL);
		return qry.list();
	}
	
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

