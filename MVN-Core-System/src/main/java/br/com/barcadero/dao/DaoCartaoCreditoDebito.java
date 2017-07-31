package br.com.barcadero.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.CartaoCreditoDebito;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

@Repository
public class DaoCartaoCreditoDebito extends DaoModelo<CartaoCreditoDebito> {

	public DaoCartaoCreditoDebito() {
		System.out.println(mesageInstanceSpring+DaoCartaoCreditoDebito.class.getName());
	}
	
	@Override
	public List<CartaoCreditoDebito> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartaoCreditoDebito> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartaoCreditoDebito> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartaoCreditoDebito find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
