package br.com.systeconline.dao.financeiro;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.systeconline.tables.financeiro.Lancamento;

public class DaoLancamentos extends DaoSuperClasse implements DaoPersistivel{

	private EntityManager manager = null;
	public DaoLancamentos(EntityManager manager) throws Exception{
		try {
			this.manager = manager;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Erro: " + e.getMessage());
		}
	}	
	@Override
	public String salvar(Object entidade) throws Exception {
		try{
			this.manager.persist((Lancamento)entidade);
			return MSG_SAVE_SUCESS;
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String excluir(long codigo) throws Exception {
		Lancamento lanc = null;
		try {
			lanc = find(codigo);
			if(lanc != null){
				this.manager.remove(lanc);
				return MSG_EXCL_SUCESS;
			}
			return "Não foi possível excluir o registro.";
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public String alterar(Object entidade) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object consultar(long codigo) throws Exception {
		Query qry = null;
		try {
			qry = this.manager.createQuery("SELECT l FROM Lancamentos l WHERE codigo = :codigo");
			qry.setParameter("codigo", codigo);
			return qry.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	public Lancamento find(long codigo) throws Exception {
		Query qry = null;
		try {
			qry = this.manager.createQuery("SELECT l FROM Lancamentos l WHERE codigo = :codigo");
			qry.setParameter("codigo", codigo);
			return (Lancamento) qry.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Object> consultarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Lancamento> findAll() throws Exception{
		Query qry = null;
		try {
			qry = this.manager.createQuery("SELECT l FROM Lancamentos l");
			return qry.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}

}
