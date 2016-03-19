package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoAvisos;
import br.com.systeconline.rule.RuleModelo;
import br.com.systeconline.tables.basicos.Avisos;
import br.com.systeconline.tables.basicos.Entidade;

public class RuleAvisos extends RuleModelo {

	private DaoAvisos daoAvisos;
	public RuleAvisos(Session session) {
		super(session);
		daoAvisos = new DaoAvisos(session);
	}

	public String insert(Entidade entidade) throws Exception {
		if(entidade == null){
			throw new Exception("Entidade veio nula.");
		}
		Avisos avisos = (Avisos)entidade;
		return daoAvisos.insert(avisos);
	}

	public String delete(long codigo) throws Exception {
		if(codigo <= 0){
			throw new Exception("Codigo teve ter seu valor maior que 0 - Codigo recebido: " + codigo);
		}
		return daoAvisos.delete(codigo);
	}

	public String update(Entidade entidade) throws Exception {
		
		return daoAvisos.update(entidade);
	}

	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Entidade> findAll() throws Exception{
		return daoAvisos.findAll();
	}

}
