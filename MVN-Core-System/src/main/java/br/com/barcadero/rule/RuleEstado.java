package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.dao.DaoEstado;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Estado;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Usuario;

public class RuleEstado extends RuleModelo<Estado> {

	private final DaoEstado daoEstado ;
	public RuleEstado(Empresa empresa, Loja loja, Session session) {
		super(empresa, loja, session);
		this.daoEstado = new DaoEstado(empresa, loja, session);
	}
	
	@Override
	public String insert(Entidade entidade) throws Exception {
		Estado estado = (Estado)entidade;
		if(estado != null){
			return daoEstado.insert(estado);
		}else{
			return "O estado não pode ser recuperado.";
		}	
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoEstado.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoEstado.update(entidade);
	}

	@Override
	public Estado find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoEstado.find(codigo);
	}
	
	public List<Estado> findAll() throws Exception{
		try {
			return this.daoEstado.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Estado> findAllEstados() throws Exception {
		return daoEstado.findAllEstados();
	}
	
	/**
	 * Realiza a carga inicial dos estados na tabela
	 * @throws Exception
	 * @author Rafael Rocha
	 */
	public void carregarEstados(Usuario usuario) throws Exception{
		daoEstado.carregarEstados(usuario);
	}

}
