package br.com.barcadero.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Endereco;
import br.com.barcadero.tables.Loja;
@Repository
public class DaoEndereco extends DaoModelo<Endereco> {

	
	public DaoEndereco() {
		
	}
	

	@Override
	public List<Endereco> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Endereco find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Endereco> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Endereco> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
