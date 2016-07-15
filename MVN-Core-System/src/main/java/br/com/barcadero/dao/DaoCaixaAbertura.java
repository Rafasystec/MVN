package br.com.barcadero.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.CaixaAbertura;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;

public class DaoCaixaAbertura extends DaoModelo<CaixaAbertura> {

	public DaoCaixaAbertura(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CaixaAbertura> findAll() throws Exception {
		
		return getMainQuery(CaixaAbertura.FIND_ALL).list();
	}

	@Override
	public CaixaAbertura find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<CaixaAbertura> findByCaixa(Caixa caixa) {
		return getMainQuery(CaixaAbertura.FIND_BY_CAIXA)
				.setLong(GlobalNameParam.PARAM_CAIXA, caixa.getCodigo())
				.list();
				
	}
	
	/**
	 * Retorna as aberturas de caixa por loja
	 * @param loja
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CaixaAbertura> findByLoja(Loja loja) {
		return getMainQuery(CaixaAbertura.FIND_BY_LOJA)
				.setLong(GlobalNameParam.PARAM_COD_LOJA, loja.getCodigo())
				.list();
	}
	
	/**
	 * Obtem as aberturas de caixa da loja logada
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CaixaAbertura> findByLoja() {
		return getMainQuery(CaixaAbertura.FIND_BY_LOJA)
				.setLong(GlobalNameParam.PARAM_COD_LOJA, getLoja().getCodigo())
				.list();
	}
	
	private Query getMainQuery(String queryName) {
		return getSession().getNamedQuery(queryName)
				.setLong(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo());
	}

}
