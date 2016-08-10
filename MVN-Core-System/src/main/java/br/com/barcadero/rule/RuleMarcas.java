package br.com.barcadero.rule;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.barcadero.dao.DaoMarcas;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Marcas;

@Service
public class RuleMarcas extends RuleModelo<Marcas> {

	private DaoMarcas daoMarcas;
	@Autowired
	public RuleMarcas(DaoMarcas daoMarcas) {
		System.out.println("Auto-generated constructor stub RuleMarcas"); 
		this.daoMarcas = daoMarcas;
	}
//	public RuleMarcas(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//		daoMarcas = new DaoMarcas(empresa, loja, session);
//	}	

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoMarcas.insert(entidade);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoMarcas.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoMarcas.update(entidade);
	}

	@Override
	public Marcas find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Marcas> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
