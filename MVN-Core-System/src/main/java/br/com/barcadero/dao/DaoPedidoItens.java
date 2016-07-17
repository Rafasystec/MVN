package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.PedidoItens;

public class DaoPedidoItens extends DaoModelo<PedidoItens> {

	public DaoPedidoItens(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
	}

	@Override
	public List<PedidoItens> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoItens find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
