package br.com.barcadero.dao;

import java.util.List;
import org.hibernate.Session;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Estoque;
import br.com.barcadero.tables.Loja;

public class DaoEstoque extends DaoModelo<Estoque> {

	public DaoEstoque(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Estoque> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estoque find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Estoque> findByCodigoOrDescricao(String codigoDescricao) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
