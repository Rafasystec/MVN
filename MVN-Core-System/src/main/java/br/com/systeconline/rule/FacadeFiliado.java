package br.com.systeconline.rule;

import org.hibernate.Session;

import br.com.systeconline.tables.basicos.Entidade;
import br.com.systeconline.tables.basicos.Filiado;
import br.com.systeconline.dao.basicos.DaoFiliado;
import br.com.systeconline.rule.RuleEntityInterface;
import br.com.systeconline.rule.RuleModelo;

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
