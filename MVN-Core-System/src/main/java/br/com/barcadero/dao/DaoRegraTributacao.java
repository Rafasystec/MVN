package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
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

	@Override
	public List<RegraTributaria> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegraTributaria> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
