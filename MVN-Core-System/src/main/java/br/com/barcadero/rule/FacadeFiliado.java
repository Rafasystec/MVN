package br.com.barcadero.rule;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoFiliado;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Filiado;

public class FacadeFiliado extends RuleModelo implements RuleEntityInterface{
	private DaoFiliado daoFiliado	= null;
	public FacadeFiliado(Session session) {
		super(session);
		daoFiliado 	= new DaoFiliado(session);
	}
	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		try {
			return daoFiliado.insert((Filiado)entidade);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Erro na camada Facade de Filiados: " + e.getMessage());
		}
	}

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
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		try {
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Erro na camada Facade de Filiados: " + e.getMessage());
		}
	}

}
