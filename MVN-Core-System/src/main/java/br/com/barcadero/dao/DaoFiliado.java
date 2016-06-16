package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Filiado;

public class DaoFiliado extends DaoModelo implements DaoInterface{
	private Transaction trans;
	public DaoFiliado(Session session){
		super(session);
	}
		
	@SuppressWarnings("unchecked")
	public List<Entidade> findAll() throws Exception{
		List<Entidade> filiados	= null;
		TypedQuery<Entidade> qry	= null;
		try {
			qry			= ((TypedQuery<Entidade>)getSession().getNamedQuery("Estado.findAll"));
			filiados	= qry.getResultList(); //.getResultList();
			return filiados;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
