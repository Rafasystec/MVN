package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.NotaEletronica;

/**
 * Para a nota eletronica NF-e
 * @author root
 *
 */
public final class DaoNotaEletronica extends DaoModelo<NotaEletronica> {


	public DaoNotaEletronica(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<NotaEletronica> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotaEletronica find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
