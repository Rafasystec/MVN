package br.com.barcadero.rule;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.barcadero.dao.DaoCaixa;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.CaixaAbertura;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;


@Component
public class RuleCaixa extends RuleModelo<Caixa> {

	private DaoCaixa daoCaixa;
	
	@Autowired
	public RuleCaixa(DaoCaixa daoCaixa) {
		this.daoCaixa = daoCaixa;
	}
	
//	public RuleCaixa(Empresa empresa, Loja loja, Session session) {
//		super(empresa, loja, session);
//		daoCaixa = new DaoCaixa(empresa, loja, session);
//	}

	/**
	 * Inserir um caixa.
	 */
//	@Override
//	public String insert(Entidade entidade) throws Exception {
//		// TODO Auto-generated method stub
//		Caixa caixa = (Caixa)entidade;
//		//Note: Quando for inserido um caixa iremos inserir uma abertura
//		CaixaAbertura abertura = new CaixaAbertura(caixa.getEmpresa(),caixa.getLoja(), caixa.getUsuario());
//		abertura.setCaixa(caixa);
//		List<CaixaAbertura> aberturas = new ArrayList<CaixaAbertura>();
//		aberturas.add(abertura);
//		caixa.setAberturas(aberturas);
//		return daoCaixa.insert(entidade);
//	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoCaixa.delete(codigo);
	}

	@Override
	public Caixa find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoCaixa.find(codigo);
	}
	
	@Deprecated
	public List<Caixa> findAll() throws Exception {
		return daoCaixa.findAll();
	}
	
	public List<Caixa> findAll(Empresa empresa) throws Exception {
		return daoCaixa.findAll(empresa);
	}

	/**
	 * Obter caixa pelo IP
	 * @param cdLoja
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public Caixa findByIp(Loja loja, String ip) throws Exception{
		Caixa caixa = daoCaixa.findByIp(loja, ip); 
		return caixa;
	}

	@Override
	public List<Caixa> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Caixa> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Caixa insert(Caixa caixa) throws Exception {
		//Note: Quando for inserido um caixa iremos inserir uma abertura
		CaixaAbertura abertura = new CaixaAbertura(caixa.getEmpresa(),caixa.getLoja(), caixa.getUsuario());
		abertura.setCaixa(caixa);
		List<CaixaAbertura> aberturas = new ArrayList<>();
		aberturas.add(abertura);
		caixa.setAberturas(aberturas);
		return daoCaixa.insert(caixa);
	}

	@Override
	public Caixa update(Caixa entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Caixa getCaixaVenda(Loja loja, String ipAddress) {
		Caixa caixa = null;
		try {
			caixa = findByIp(loja, ipAddress);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return caixa;
	}
}
