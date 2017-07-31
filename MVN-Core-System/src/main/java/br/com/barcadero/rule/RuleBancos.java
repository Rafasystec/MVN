package br.com.barcadero.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.dao.DaoBancos;
import br.com.barcadero.tables.Bancos;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

@Service
public class RuleBancos extends RuleModelo<Bancos> {

	@Autowired
	private DaoBancos daoBancos;
	public RuleBancos() {
		
	}
	

	@Override
	public String delete(long codigo) throws Exception {
		return daoBancos.delete(codigo);
	}

	@Override
	public Bancos find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bancos> findByEmpresa(Empresa empresa) throws Exception {
		return daoBancos.findByEmpresa(empresa);
	}

	@Override
	public List<Bancos> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bancos> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bancos insert(Bancos entidade) throws Exception {
		return daoBancos.insert(entidade);
	}

	@Override
	public Bancos update(Bancos entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoBancos.insert(entidade);
	}

}
