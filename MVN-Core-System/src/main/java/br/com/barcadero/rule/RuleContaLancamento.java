package br.com.barcadero.rule;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.commons.util.HandleDateHour;
import br.com.barcadero.dao.DaoContaLancamento;
import br.com.barcadero.tables.ContaLancamento;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Usuario;

@Service
public class RuleContaLancamento extends RuleModelo<ContaLancamento> {

	@Autowired
	private DaoContaLancamento dao;
	
	public RuleContaLancamento() {
		if(this.dao != null){
			dao.setEmpresa(getEmpresa());
			dao.setLoja(getLoja());
		}
	}
	public RuleContaLancamento(Empresa empresa, Loja loja, Usuario usuario) {
		this.dao = new DaoContaLancamento(empresa, loja);
	}
	
	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContaLancamento find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaLancamento> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaLancamento> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContaLancamento> findAll() throws Exception {
		return null;
	}

	@Override
	public ContaLancamento insert(ContaLancamento entidade) throws Exception {
		return dao.insert(entidade);
	}

	@Override
	public ContaLancamento update(ContaLancamento entidade) throws Exception {
		return dao.update(entidade);
	}
	public List<ContaLancamento> getAllOfThisMonth(Empresa empresa, Loja loja) {
		Date dtIni = HandleDateHour.getFirstDateOfMonth();
		Date dtFin = HandleDateHour.getLastDateOfMonth();
		return dao.getAllOfThisMonthOfTheYear(empresa,loja, dtIni, dtFin);
	}
	
	public List<ContaLancamento> getAllOfThisMonthOfTheYear(Empresa empresa,Loja loja, String year, String month,Date dtIni, Date dtFin){
		return dao.getAllOfThisMonthOfTheYear(empresa,loja, dtIni, dtFin);
	}

}
