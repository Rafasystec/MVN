package br.com.systeconline.rule;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.systeconline.tables.basicos.*;
import br.com.systeconline.tables.financeiro.*;
import br.com.systeconline.dao.financeiro.DaoHistoricoLancamento;
import br.com.systeconline.rule.FacadeSuperClass;

public class FacadeHistoricoLancamento extends FacadeSuperClass{

	EntityManager manager 	= null;
	DaoHistoricoLancamento daoHistorico ;
	public FacadeHistoricoLancamento(EntityManager manager) throws Exception{
		this.manager = manager;
		this.daoHistorico = new DaoHistoricoLancamento(this.manager);
	}
	
	public String salvar(Entidade entidade) throws Exception{
		try {
			return daoHistorico.salvar(entidade);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	public List<HistoricoLancamento> findAll() throws Exception{
		try {
			return daoHistorico.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	public String excluir(long codigo) throws Exception{
		try {
			return daoHistorico.excluir(codigo);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(long codigo) throws Exception{
		try {
			return "" ;//daoHistorico.alterar(entidade);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	public String alterar(HistoricoLancamento historico) throws Exception{
		try {
			return daoHistorico.alterar(historico);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
}
