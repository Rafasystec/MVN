package br.com.barcadero.rule;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.barcadero.dao.DaoAvisos;
import br.com.barcadero.tables.Avisos;
import br.com.barcadero.tables.Entidade;


@Component
public class RuleAvisos extends RuleModelo<Avisos> {

	private DaoAvisos daoAvisos;
	@Autowired
	public RuleAvisos(DaoAvisos daoAvisos){
		this.daoAvisos = daoAvisos;
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

	public Avisos find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Avisos> findAll() throws Exception{
		return daoAvisos.findAll();
	}

}
