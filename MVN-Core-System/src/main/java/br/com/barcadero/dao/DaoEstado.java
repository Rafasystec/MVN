package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.core.enums.EnumUF;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Estado;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Usuario;

public class DaoEstado extends DaoModelo<Estado>{
	
	
	
	public DaoEstado(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		String result = "";
		if(entidade instanceof Estado){
			Estado estado = (Estado)entidade;
			result = super.insert(estado);
			return result;
		}else{
			throw new Exception("Entidade não compatíveis: " + entidade.getClass().getName() + " com " + Estado.class);
		}
		
	}

	@Override
	public Estado find(long codigo) throws Exception {
		try {
			return (Estado)getSession().getNamedQuery(Estado.FIND_BY_CODE).setLong("codigo", codigo).uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> findAll() throws Exception {
		try {
			return getSession().getNamedQuery(Estado.FIND).list();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Estado> findAllEstados() throws Exception {
		try {
			return (List<Estado>)getSession().getNamedQuery(Estado.FIND).list();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	public void carregarEstados(Usuario usuario) throws Exception{
		for (EnumUF uf : EnumUF.values()) {
			Estado estado = new Estado(usuario);
			estado.setCodIbge(String.valueOf(uf.getCdIbge()));
			estado.setDescricao(uf.getLabel());
			estado.setUf(uf);	
			estado.setCodigo(uf.getCdIbge());
			insert(estado);
		}
	}
	
	/**
	 * Consulta um estado pelo seu codigo do IBGE
	 * @param codeIBGE
	 * @return
	 */
	public Estado findByCodeIBGE(String codeIBGE) {
		Query qry = getSession().getNamedQuery(Estado.FIND_BY_IBGE);
		qry.setParameter(Estado.PARAM_IBGE, codeIBGE);
		return (Estado)qry.uniqueResult();
	}
	
			
}
