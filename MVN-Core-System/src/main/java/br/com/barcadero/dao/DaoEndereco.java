package br.com.barcadero.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.Endereco;
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

	

}
