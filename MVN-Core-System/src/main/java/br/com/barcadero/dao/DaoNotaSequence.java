package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.core.enums.EnumModeloNota;
import br.com.barcadero.core.util.GlobalNameParam;
import br.com.barcadero.rule.RuleNota;
import br.com.barcadero.tables.Caixa;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.NotaSequence;
import br.com.barcadero.tables.Usuario;

public class DaoNotaSequence extends DaoModelo<NotaSequence> {

	private RuleNota ruleNota;
	public DaoNotaSequence(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		ruleNota = new RuleNota(empresa, loja, session);
	}

	@Override
	public List<NotaSequence> findAll() throws Exception {
		Query qry = getSession().getNamedQuery(NotaSequence.FIND_ALL)
				.setLong(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo());
		return qry.list();
	}
	/**
	 * 
	 * @param typeModeloNota
	 * @param serie
	 * @return
	 */
	public NotaSequence findByModAndSerie(EnumModeloNota typeModeloNota, long serie) throws Exception {
		Query qry = getSession().getNamedQuery(NotaSequence.FIND_BY_MOD_SERIE)
				.setLong(GlobalNameParam.PARAM_COD_EMP, getEmpresa().getCodigo())
				.setParameter("modeloNota", typeModeloNota)
				.setLong("serie", serie);
		return (NotaSequence) qry.uniqueResult();
	}

	@Override
	public NotaSequence find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Obtem o numero sequencial para a serie de uma determinda nota.
	 * @param typeModeloNota
	 * @param caixa
	 * @param usuario
	 * @return
	 * @throws Exception
	 */
	public long getSequence(EnumModeloNota typeModeloNota, Caixa caixa, Usuario usuario) throws Exception {
		long sequence = 0;
		long serie	  = ruleNota.getSerie(caixa);
		NotaSequence notaSequence = findByModAndSerie(typeModeloNota, serie );
		if(notaSequence != null){
			notaSequence.setSequence(notaSequence.getSequence() + 1L);
			update(notaSequence);
		}else{
			notaSequence = getSequencialInicial(typeModeloNota, serie, usuario);
			insert(notaSequence);
		}
		sequence = notaSequence.getSequence();
		return sequence;
	}
	
	/**
	 * 
	 * @param typeModeNota
	 * @param serie
	 * @param usuario
	 * @return
	 */
	public NotaSequence getSequencialInicial(EnumModeloNota typeModeNota, long serie, Usuario usuario) {
		NotaSequence sequence = new NotaSequence(getEmpresa(), getLoja(), usuario);
		sequence.setModeloNota(typeModeNota);
		sequence.setSequence(1);
		sequence.setSerie(serie);
		return sequence;
	}

}
