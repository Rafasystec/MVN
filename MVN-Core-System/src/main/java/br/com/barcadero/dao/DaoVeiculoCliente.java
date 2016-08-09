package br.com.barcadero.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.VeiculoCliente;

@Repository("daoVeiculoCliente")
public class DaoVeiculoCliente extends DaoModelo<VeiculoCliente> {

	@Override
	public List<VeiculoCliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VeiculoCliente find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
