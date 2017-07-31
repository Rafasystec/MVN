package br.com.barcadero.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.dao.DaoCartaoCreditoDebito;
import br.com.barcadero.tables.CartaoCreditoDebito;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
@Service
public class RuleCartaoDebitoCredito extends RuleModelo<CartaoCreditoDebito> {


	@Autowired
	private DaoCartaoCreditoDebito daoCartaoCreditoDebito;
	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartaoCreditoDebito find(long codigo) throws Exception {
		return daoCartaoCreditoDebito.find(codigo);
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
	public CartaoCreditoDebito insert(CartaoCreditoDebito entidade) throws Exception {
		return daoCartaoCreditoDebito.insert(entidade);
	}

	@Override
	public CartaoCreditoDebito update(CartaoCreditoDebito entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
