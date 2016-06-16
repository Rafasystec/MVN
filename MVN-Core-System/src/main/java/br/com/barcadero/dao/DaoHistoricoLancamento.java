package br.com.barcadero.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.barcadero.tables.HistoricoLancamento;


public class DaoHistoricoLancamento extends DaoSuperClasse implements DaoPersistivel{
	
	private EntityManager manager = null;
	public DaoHistoricoLancamento(EntityManager manager) throws Exception{
		try {
			this.manager = manager;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Erro: " + e.getMessage());
		}
	}
	
	public String salvar(Object entidade) throws Exception {
		try {
			manager.persist((HistoricoLancamento)entidade);
			return MSG_SAVE_SUCESS;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}

	
	public String excluir(long codigo) throws Exception {
		HistoricoLancamento historico = null;
		String result = "";
		try {
			historico = find(codigo);
			if(historico != null){
				manager.remove(historico);
				result = "Excluido com sucesso!";
			}else{
				result = "Não foi possível excluir o histórico.";
			}
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}

	public String alterar(Object entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public Object consultar(long codigo) throws Exception {
		Query qry = null;
		List<HistoricoLancamento> historicos;
		try {
			qry = this.manager.createQuery("SELECT h FROM HistoricoLancamento h WHERE codigo = :codigo");
			qry.setParameter("codigo", codigo);
			historicos = qry.getResultList();
			if(historicos != null && historicos.size() > 0){
				return historicos;
			}else{
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<Object> consultarTodos() throws Exception {
		Query qry = null;
		try{
			qry = manager.createQuery("SELECT h FROM HistoricoLancamento h");
			if(qry != null){
				return qry.getResultList();
			}else{
				return null;
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<HistoricoLancamento> findAll() throws Exception{
		Query qry = null;
		try{
			qry = manager.createQuery("SELECT h FROM HistoricoLancamento h");
			if(qry != null){
				return (List<HistoricoLancamento>)qry.getResultList();
			}else{
				return null;
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	public HistoricoLancamento find(long codigo) throws Exception{
		Query qry 					 = null;
		try {
			qry = manager.createQuery("SELECT h FROM HistoricoLancamento h WHERE h.codigo = :codigo");
			qry.setParameter("codigo", codigo);
			return (HistoricoLancamento) qry.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
		
	}
}
