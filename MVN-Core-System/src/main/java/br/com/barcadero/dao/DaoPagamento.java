package br.com.barcadero.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Pagamento;
@Repository
public class DaoPagamento extends DaoModelo<Pagamento> {

	public DaoPagamento() {
		
	}
	@Override
	public List<Pagamento> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pagamento> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pagamento> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pagamento find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
