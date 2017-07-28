package br.com.barcadero.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.ContaLancamento;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

@Repository
public class DaoContaLancamento extends DaoModelo<ContaLancamento> {

	
	public DaoContaLancamento() {
		
	}
	//@Autowired
	public DaoContaLancamento(Empresa empresa, Loja loja) {
		super(empresa, loja);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContaLancamento find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<ContaLancamento> getAllOfThisMonthOfTheYear(Empresa empresa, Loja loja,Date dtIni, Date dtFin ) {
		List<ContaLancamento> list = null;
		TypedQuery<ContaLancamento> qry = manager.createNamedQuery(ContaLancamento.FIND_BY_MONTH, ContaLancamento.class)
				.setParameter("empresa", empresa)
				.setParameter("loja", loja)
				.setParameter("dtIni", dtIni)
				.setParameter("dtFim", dtFin);
		list = qry.getResultList();
		return list;
	}

}
