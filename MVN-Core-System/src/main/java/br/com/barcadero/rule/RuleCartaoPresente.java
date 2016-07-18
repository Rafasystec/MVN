package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.tables.CartaoPresente;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;

public class RuleCartaoPresente extends RuleModelo<CartaoPresente> {

	public RuleCartaoPresente(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		return null;
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartaoPresente find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartaoPresente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
