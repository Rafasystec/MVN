package br.com.systeconline.rule;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.systeconline.dao.financeiro.*;
import br.com.systeconline.tables.financeiro.*;

public class FacadePlanoConta {
	
	EntityManager manager 	= null;
	DaoPlanoContas daoPlano	= null;
	public FacadePlanoConta(EntityManager manager) throws Exception{
		this.manager = manager;
		daoPlano = new DaoPlanoContas(this.manager);
	}
	
	public String salvar(PlanoConta conta) throws Exception{
		try {
			return daoPlano.salvar(conta);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Erro ao tentar salvar o plano de contas: " + e.getMessage());
		}
	}
	
	public String excluir(long codigo) throws Exception{
		try {
			return daoPlano.excluir(codigo);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(PlanoConta conta) throws Exception{
		try{
			return daoPlano.alterar(conta);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	public List<Object> consultarTodos() throws Exception{
		try{
			return daoPlano.consultarTodos();
		}catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	public List<PlanoConta> findAll() throws Exception{
		try {
			return daoPlano.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}

}
