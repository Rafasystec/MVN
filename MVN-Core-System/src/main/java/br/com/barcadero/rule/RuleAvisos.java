package br.com.barcadero.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.barcadero.dao.DaoAvisos;
import br.com.barcadero.tables.Avisos;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;


@Component
public class RuleAvisos extends RuleModelo<Avisos> {

	@Autowired
	private DaoAvisos daoAvisos;
	
	public String delete(long codigo) throws Exception {
		if(codigo <= 0){
			throw new Exception("Codigo teve ter seu valor maior que 0 - Codigo recebido: " + codigo);
		}
		return daoAvisos.delete(codigo);
	}

	public Avisos find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoAvisos.find(codigo);
	}
	
	public List<Avisos> findAll() throws Exception{
		return daoAvisos.findAll();
	}

	@Override
	public List<Avisos> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Avisos> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Avisos insert(Avisos entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Avisos update(Avisos entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
