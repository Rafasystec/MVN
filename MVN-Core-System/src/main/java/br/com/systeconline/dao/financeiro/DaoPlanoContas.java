package br.com.systeconline.dao.financeiro;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.systeconline.tables.financeiro.PlanoConta;

public class DaoPlanoContas extends DaoSuperClasse implements DaoPersistivel{
	
	private EntityManager manager = null;
	public DaoPlanoContas(EntityManager manager) throws Exception {
		this.manager = manager;
	}

	@Override
	public String salvar(Object entidade) throws Exception{
		try {
			manager.persist((PlanoConta)entidade);
			return MSG_SAVE_SUCESS;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String excluir(long codigo) throws Exception{
		PlanoConta conta = null;
		try {
			conta = (PlanoConta)consultar(codigo);
			if(conta != null){
				manager.remove(conta);
				return MSG_EXCL_SUCESS;
			}else{
				return "Não foi possível encontrar esse registro para ser excluído.";
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String alterar(Object entidade) throws Exception{
		try {
			if(entidade != null){
				manager.refresh((PlanoConta)entidade);
				return "Alterado com sucesso";
			}
			return "Nao foi possivel alterar";
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Object consultar(long codigo) throws Exception{
		PlanoConta conta = null;
		try {
			conta = manager.find(PlanoConta.class, codigo);
			if(conta != null){
				if(conta.getCodigo() > 0){
					return conta;
				}
			}else{
				return null;
			}
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> consultarTodos() throws Exception{
		Query qry = null;
		try{
			qry = manager.createQuery("SELECT pc FROM PlanoConta pc");
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
	public List<PlanoConta> findAll() throws Exception{
		Query qry = null;
		try{
			qry = manager.createQuery("SELECT pc FROM PlanoConta pc");
			if(qry != null){
				return (List<PlanoConta>)qry.getResultList();
			}else{
				return null;
			}
		}catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}

}
