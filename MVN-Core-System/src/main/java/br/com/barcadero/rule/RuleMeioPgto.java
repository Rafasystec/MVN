package br.com.barcadero.rule;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.barcadero.dao.DaoMeioPgto;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.MeiosPagamento;

@Service
public class RuleMeioPgto extends RuleModelo<MeiosPagamento> {

	private DaoMeioPgto dao;
	@Autowired
	public RuleMeioPgto(DaoMeioPgto dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}                                                                     
//	public RuleMeioPgto(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//		dao = new DaoMeioPgto(empresa, loja, session);
//	}

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
	public MeiosPagamento find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return (MeiosPagamento)dao.find(codigo);
	}
	
	public List<MeiosPagamento> getAll() {
		return dao.getAll();
	}

	@Override
	public List<MeiosPagamento> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
