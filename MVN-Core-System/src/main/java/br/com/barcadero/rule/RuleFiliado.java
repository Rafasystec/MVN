package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoFiliado;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Filiado;
import br.com.barcadero.tables.Loja;

public class RuleFiliado extends RuleModelo<Filiado>{
	
	
	private DaoFiliado daoFiliado	= null;
	public RuleFiliado(Session session) {
		super(session);
		daoFiliado 	= new DaoFiliado(session);
	}
//	@Override
//	public String insert(Entidade entidade) throws Exception {
//		// TODO Auto-generated method stub
//		try {
//			return daoFiliado.insert((Filiado)entidade);
//		} catch (Exception e) {
//			// TODO: handle exception
//			throw new Exception("Erro na camada Facade de Filiados: " + e.getMessage());
//		}
//	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		try {
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Erro na camada Facade de Filiados: " + e.getMessage());
		}
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		try {
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Erro na camada Facade de Filiados: " + e.getMessage());
		}
	}

	@Override
	public Filiado find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		try {
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Erro na camada Facade de Filiados: " + e.getMessage());
		}
	}
	@Override
	public List<Filiado> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Filiado> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Filiado> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Filiado insert(Filiado entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Filiado update(Filiado entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
