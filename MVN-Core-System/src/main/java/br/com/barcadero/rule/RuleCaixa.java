package br.com.barcadero.rule;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoCaixa;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.CaixaAbertura;
import br.com.barcadero.tables.Entidade;


public class RuleCaixa extends RuleModelo {

	private DaoCaixa daoCaixa;
	public RuleCaixa(Session session) {
		super(session);
		daoCaixa = new DaoCaixa(session);
	}

	/**
	 * Inserir um caixa.
	 */
	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		Caixa caixa = (Caixa)entidade;
		//Note: Quando for inserido um caixa iremos inserir uma abertura
		CaixaAbertura abertura = new CaixaAbertura(caixa.getLoja(), caixa.getUsuario());
		abertura.setCaixa(caixa);
		List<CaixaAbertura> aberturas = new ArrayList<CaixaAbertura>();
		aberturas.add(abertura);
		caixa.setAberturas(aberturas);
		return daoCaixa.insert(entidade);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoCaixa.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoCaixa.update(entidade);
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoCaixa.find(codigo);
	}
	
	public List<Caixa> findAll() {
		return daoCaixa.findAll(0);
	}

	/**
	 * Obter caixa pelo IP
	 * @param cdLoja
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public Caixa findByIp(long cdLoja, String ip) throws Exception{
		Caixa caixa = daoCaixa.findByIp(cdLoja, ip); 
		if(caixa == null){
			throw new Exception("Não foi encontrado caixa para loja >> " + cdLoja + " e ip >> " + ip);
		}
		return caixa;
	}
}
