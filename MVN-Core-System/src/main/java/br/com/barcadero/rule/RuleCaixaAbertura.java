package br.com.barcadero.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.core.enums.EnumStatusCaixa;
import br.com.barcadero.dao.DaoCaixaAbertura;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.CaixaAbertura;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

@Service
public class RuleCaixaAbertura extends RuleModelo<CaixaAbertura> {

	@Autowired
	private DaoCaixaAbertura daoCaixaAbertura; 

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoCaixaAbertura.delete(codigo);
	}

	@Override
	public CaixaAbertura find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoCaixaAbertura.find(codigo);
	}

	@Override
	public List<CaixaAbertura> findAll() throws Exception {
		// TODO Auto-generated method stub
		return daoCaixaAbertura.findAll();
	}
	
	public boolean isCaixaAberto(Caixa caixa) {
		
		EnumStatusCaixa status = caixa.getStatusCaixa();
		if(status == EnumStatusCaixa.ABERTO){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<CaixaAbertura> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CaixaAbertura> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public CaixaAbertura insert(CaixaAbertura entidade) throws Exception {
		return daoCaixaAbertura.insert(entidade);
	}

	@Override
	public CaixaAbertura update(CaixaAbertura entidade) throws Exception {
		return daoCaixaAbertura.update(entidade);
	}
	
	

}
