package br.com.barcadero.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.dao.DaoCentroDeCusto;
import br.com.barcadero.tables.CentroDeCusto;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

@Service
public class RuleCentroDeCusto extends RuleModelo<CentroDeCusto> {

	@Autowired
	private DaoCentroDeCusto daoCentroDeCusto;
	
	public RuleCentroDeCusto() {
	
	}
	
	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CentroDeCusto find(long codigo) throws Exception {
		return daoCentroDeCusto.find(codigo);
	}

	@Override
	public List<CentroDeCusto> findByEmpresa(Empresa empresa) throws Exception {
		return daoCentroDeCusto.findByEmpresa(empresa);
	}

	@Override
	public List<CentroDeCusto> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		return daoCentroDeCusto.findByEmpresaELoja(empresa, loja);
	}

	@Override
	public List<CentroDeCusto> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CentroDeCusto insert(CentroDeCusto entidade) throws Exception {
		return daoCentroDeCusto.insert(entidade);
	}

	@Override
	public CentroDeCusto update(CentroDeCusto entidade) throws Exception {
		return daoCentroDeCusto.update(entidade);
	}

}
