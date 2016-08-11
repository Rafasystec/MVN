package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import br.com.barcadero.core.enums.EnumUF;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Estado;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Usuario;

@Repository
public class DaoEstado extends DaoModelo<Estado>{
	
	public DaoEstado() {
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
			return (Estado)manager.createNamedQuery(Estado.FIND_BY_CODE)
					.setParameter("codigo", codigo).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> findAll() throws Exception {
		try {
			return manager.createNamedQuery(Estado.FIND).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Estado> findAllEstados() throws Exception {
		try {
			return (List<Estado>)manager.createNamedQuery(Estado.FIND).getResultList();
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
			//estado.setCodigo(uf.getCdIbge());
			insert(estado);
		}
	}
	
	/**
	 * Consulta um estado pelo seu codigo do IBGE
	 * @param codeIBGE
	 * @return
	 */
	public Estado findByCodeIBGE(String codeIBGE) {
		Query qry = manager.createNamedQuery(Estado.FIND_BY_IBGE);
		qry.setParameter(Estado.PARAM_IBGE, codeIBGE);
		return (Estado)qry.getSingleResult();
	}

	@Override
	public List<Estado> findByEmpresa(Empresa empresa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Estado> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
			
}
