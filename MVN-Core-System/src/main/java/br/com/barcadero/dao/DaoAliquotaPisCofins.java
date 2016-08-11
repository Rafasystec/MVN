package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.AliquotasPISCOFINS;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

public class DaoAliquotaPisCofins extends DaoModelo<AliquotasPISCOFINS> {

	

	public DaoAliquotaPisCofins(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
	}

	@Override
	public List<AliquotasPISCOFINS> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AliquotasPISCOFINS find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AliquotasPISCOFINS> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AliquotasPISCOFINS> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
