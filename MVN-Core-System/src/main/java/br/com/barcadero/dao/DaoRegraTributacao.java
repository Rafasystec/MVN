package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.RegraTributaria;

public class DaoRegraTributacao extends DaoModelo<RegraTributaria> {

	public DaoRegraTributacao(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
	}

	@Override
	public List<RegraTributaria> findAll() throws Exception {
		return null;
	}

	@Override
	public RegraTributaria find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Deleta todos as regras tributarias
	 * @return numero de rows afetadas
	 */
	public int deleteAll() {
		Query qry = getSession().createQuery("DELETE FROM RegraTributaria");
		return qry.executeUpdate();
	}

}
