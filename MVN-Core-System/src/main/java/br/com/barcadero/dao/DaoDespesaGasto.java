package br.com.barcadero.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.DespesaGasto;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

@Repository
public class DaoDespesaGasto extends DaoModelo<DespesaGasto> {

	public DaoDespesaGasto() {
		
	}
	@Override
	public List<DespesaGasto> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DespesaGasto> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DespesaGasto> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DespesaGasto find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
