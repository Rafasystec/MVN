package br.com.barcadero.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.rule.RuleModelo;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Receita;
@Service
public class RuleReceita extends RuleModelo<Receita> {

	@Autowired
	private DaoReceita daoReceita;
	public RuleReceita() {
		
	}
	
	@Override
	public String delete(long codigo) throws Exception {
		return daoReceita.delete(codigo);
	}

	@Override
	public Receita find(long codigo) throws Exception {
		return daoReceita.find(codigo, Receita.class);
	}

	@Override
	public List<Receita> findByEmpresa(Empresa empresa) throws Exception {
		return daoReceita.findByEmpresa(empresa);
	}

	@Override
	public List<Receita> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Receita> findAll() throws Exception {
		return daoReceita.findAll();
	}

	@Override
	public Receita insert(Receita entidade) throws Exception {
		return daoReceita.insert(entidade);
	}

	@Override
	public Receita update(Receita entidade) throws Exception {
		return daoReceita.update(entidade);
	}

	public DaoReceita getDaoReceita() {
		return daoReceita;
	}

	public void setDaoReceita(DaoReceita daoReceita) {
		this.daoReceita = daoReceita;
	}

}
