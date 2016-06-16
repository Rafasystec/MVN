package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoMeioPgto;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.MeiosPagamento;


public class RuleMeioPgto extends RuleModelo {

	private final DaoMeioPgto dao;
	
	public RuleMeioPgto(Session session) {
		super(session);
		dao = new DaoMeioPgto(session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		return dao.insert(entidade);
	}

	@Override
	public String delete(long codigo) throws Exception {
		return dao.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return dao.update(entidade);
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return (MeiosPagamento)dao.find(codigo);
	}
	
	public List<MeiosPagamento> getAll() {
		return dao.getAll();
	}

}
