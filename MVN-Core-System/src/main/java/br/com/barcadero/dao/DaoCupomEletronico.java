package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.CupomEletronico;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

public class DaoCupomEletronico extends DaoModelo<CupomEletronico> {

	public DaoCupomEletronico(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CupomEletronico> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CupomEletronico find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
