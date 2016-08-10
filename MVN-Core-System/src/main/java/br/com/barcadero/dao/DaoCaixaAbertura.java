package br.com.barcadero.dao;

import java.util.List;
import javax.persistence.Query;
//import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.CaixaAbertura;
import br.com.barcadero.tables.Loja;

@Repository
public class DaoCaixaAbertura extends DaoModelo<CaixaAbertura> {

	@Override
	public List<CaixaAbertura> findAll() throws Exception {
		return getMainQuery(CaixaAbertura.FIND_ALL).getResultList();
	}

	@Override
	public CaixaAbertura find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<CaixaAbertura> findByCaixa(Caixa caixa) {
		return getMainQuery(CaixaAbertura.FIND_BY_CAIXA)
				.setParameter(GlobalNameParam.PARAM_CAIXA, caixa.getCodigo())
				.getResultList();
				
	}
	
	/**
	 * Retorna as aberturas de caixa por loja
	 * @param loja
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CaixaAbertura> findByLoja(Loja loja) {
		return getMainQuery(CaixaAbertura.FIND_BY_LOJA)
				.setParameter(GlobalNameParam.PARAM_COD_LOJA, loja.getCodigo())
				.getResultList();
	}
	
	/**
	 * Obtem as aberturas de caixa da loja logada
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<CaixaAbertura> findByLoja() {
		return getMainQuery(CaixaAbertura.FIND_BY_LOJA)
				.setParameter(GlobalNameParam.PARAM_COD_LOJA, getLoja().getCodigo())
				.getResultList();
	}
	
	private Query getMainQuery(String queryName) {
		return manager.createNamedQuery(queryName)
				.setParameter(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo());
	}

}
