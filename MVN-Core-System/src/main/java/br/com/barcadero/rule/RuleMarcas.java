package br.com.barcadero.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.dao.DaoMarcas;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Marcas;

@Service
public class RuleMarcas extends RuleModelo<Marcas> {

	@Autowired
	private DaoMarcas daoMarcas;

	public RuleMarcas() {
		
	}
//	@Autowired
//	public RuleMarcas(DaoMarcas daoMarcas) {
//		System.out.println("Auto-generated constructor stub RuleMarcas"); 
//		this.daoMarcas = daoMarcas;
//	}
//	public RuleMarcas(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//		daoMarcas = new DaoMarcas(empresa, loja, session);
//	}	

//	@Override
//	public String insert(Entidade entidade) throws Exception {
//		// TODO Auto-generated method stub
//		return daoMarcas.insert(entidade);
//	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoMarcas.delete(codigo);
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

	@Override
	public List<Marcas> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Marcas> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Marcas insert(Marcas entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marcas update(Marcas entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

}
