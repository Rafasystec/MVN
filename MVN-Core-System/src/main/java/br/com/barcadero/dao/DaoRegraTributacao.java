package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.RegraTributaria;

@Repository
public class DaoRegraTributacao extends DaoModelo<RegraTributaria> {

	public DaoRegraTributacao() {
		System.out.println("Auto-generated constructor stub DaoRegraTributacao");
	}
//	public DaoRegraTributacao(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//	}

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
		Query qry = manager.createQuery("DELETE FROM RegraTributaria");
		return qry.executeUpdate();
	}

}
