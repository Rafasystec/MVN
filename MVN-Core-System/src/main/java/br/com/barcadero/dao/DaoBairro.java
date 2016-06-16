package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.tables.Bairro;
import br.com.barcadero.tables.Entidade;
/**
 * DAO para a tabela de bairro.
 * @author Rafael Rocha
 *
 */
public class DaoBairro extends DaoModelo implements DaoInterface{
	//private EntityManager manager;
	public DaoBairro(Session session) {
		super(session);
	}	
	
	@Override
	public Entidade find(long codigo) throws Exception{
		Query qry = getSession().getNamedQuery(Bairro.FIND_BY_CODE).setLong("codigo", codigo);
		return (Entidade)qry.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Entidade> findAll() throws Exception{
		List<Entidade> entidades	= null;
		Query qry				= null;
		try {
			qry = getSession().getNamedQuery(Bairro.FIND);
			entidades		= qry.list(); //.getResultList();
			return entidades;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * Obtem todos os bairro de uma cidade pelo codigo da mesma.
	 * @param codCidade
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Bairro> getBairroByCidade(long codCidade)throws Exception {
		Query qry = getSession().getNamedQuery(Bairro.FIND_BY_CID)
				.setParameter("codCidade", codCidade);
		return (List<Bairro>)qry.list();
	}
	
	
}
