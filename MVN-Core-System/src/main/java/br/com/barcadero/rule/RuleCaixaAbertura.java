package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.core.enums.EnumStatusCaixa;
import br.com.barcadero.dao.DaoCaixa;
import br.com.barcadero.dao.DaoCaixaAbertura;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.CaixaAbertura;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;

public class RuleCaixaAbertura extends RuleModelo<CaixaAbertura> {

	private DaoCaixaAbertura daoCaixaAbertura; 
	private DaoCaixa daoCaixa;
	
	public RuleCaixaAbertura(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		daoCaixaAbertura = new DaoCaixaAbertura(empresa, loja, session);
		daoCaixa		 = new DaoCaixa(empresa, loja, session);
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoCaixaAbertura.insert(entidade);
	}
	
	public String insert(Entidade entidade, Caixa caixa) throws Exception {
		// TODO Auto-generated method stub
		caixa.setFlStCaixa(EnumStatusCaixa.ABERTO);
		daoCaixa.update(caixa);
		return daoCaixaAbertura.insert(entidade);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoCaixaAbertura.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoCaixaAbertura.update(entidade);
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
	
	

}
