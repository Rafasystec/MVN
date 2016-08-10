package br.com.barcadero.rule;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.barcadero.core.enums.EnumStatusCaixa;
import br.com.barcadero.dao.DaoCaixa;
import br.com.barcadero.dao.DaoCaixaAbertura;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.CaixaAbertura;
import br.com.barcadero.tables.Entidade;

@Service
public class RuleCaixaAbertura extends RuleModelo<CaixaAbertura> {

	private DaoCaixaAbertura daoCaixaAbertura; 
	private DaoCaixa daoCaixa;
	
	@Autowired
	public RuleCaixaAbertura(DaoCaixaAbertura daoCaixaAbertura,DaoCaixa daoCaixa) {
		this.daoCaixaAbertura 	= daoCaixaAbertura;
		this.daoCaixa 			= daoCaixa;
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		return daoCaixaAbertura.insert(entidade);
	}
	
	/**
	 * 
	 * @param ipCaixa
	 * @param entidade
	 * @return
	 * @throws Exception
	 */
	public String insert(String ipCaixa, Entidade entidade) throws Exception {
		long codigoLoja = getLoja().getCodigo();
		Caixa caixa = daoCaixa.findByIp(codigoLoja, ipCaixa);
		if(caixa != null){
			CaixaAbertura caixaAbertura = (CaixaAbertura) entidade;
			caixa.setStatusCaixa(EnumStatusCaixa.ABERTO);
			caixaAbertura.setCaixa(caixa);
			return insert(caixaAbertura);
		}else{
			throw new Exception("Não existe caixa com ip " + ipCaixa + " para a loja " + codigoLoja);
		}
	}
	
	public String insert(Entidade entidade, Caixa caixa) throws Exception {
		// TODO Auto-generated method stub
		caixa.setStatusCaixa(EnumStatusCaixa.ABERTO);
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
