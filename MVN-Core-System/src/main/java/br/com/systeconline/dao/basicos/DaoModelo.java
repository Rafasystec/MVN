package br.com.systeconline.dao.basicos;

import java.util.List;
import org.hibernate.Session;
import br.com.systeconline.tables.basicos.Entidade;

public abstract class DaoModelo implements DaoInterface {
	private final String MSG_SUCESS_SAVE = "Registro salvo com sucesso!";
	private final String MSG_SUCESS_DEL  = "Registro excluido!";
	private final String MSG_SUCESS_UPD  = "Registro atualizado com sucesso!";
	private final String MSG_ERRO_SAVE	 = "Erro ao tentar salvar o registro.";
	private final String MSG_ERRO_DEL	 = "Erro ao tentar excluir o registro.";
	private final String MSG_NOT_FOUND	 = "Registro não encontrado.";
	private final Session	session;

	public DaoModelo(Session session){
		//session = FacadeSessionFactory.getSession();
		this.session = session;
	}
	
	public String getMSG_NOT_FOUND() {
		return MSG_NOT_FOUND;
	}
	
	public String getMSG_SUCESS_SAVE() {
		return MSG_SUCESS_SAVE;
	}
	public String getMSG_SUCESS_DEL() {
		return MSG_SUCESS_DEL;
	}
	public String getMSG_SUCESS_UPD() {
		return MSG_SUCESS_UPD;
	}
	public String getMSG_ERRO_SAVE() {
		return MSG_ERRO_SAVE;
	}
	public String getMSG_ERRO_DEL() {
		return MSG_ERRO_DEL;
	}
	public Session getSession() {
		return session;
	}

	public String insert(Entidade entidade) throws Exception{
		try{
			if(entidade != null){
				getSession().save(entidade);
				return getMSG_SUCESS_SAVE();
			}else{
				return getMSG_ERRO_SAVE();
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	public String delete(long codigo) throws Exception{
		try {
			if(codigo <= 0){
				throw new Exception("Codigo teve ter seu valor maior que 0 - Codigo recebido: " + codigo);
			}
			Entidade entidade = this.find(codigo);
			if(entidade != null){
				getSession().delete(entidade);
			}
			return "";
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public String delete(Entidade entidade) throws Exception{
		try {
			if(entidade == null){
				throw new Exception("Entidade veio nula.");
			}
			getSession().delete(entidade);
			return "Registro Deletado.";
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public String update(Entidade entidade) throws Exception{
		if(entidade == null){
			throw new Exception("Entidade veio nula.");
		}
		getSession().update(entidade);
		return getMSG_SUCESS_UPD();
	}

	
	public abstract Entidade find(long codigo) throws Exception;
	public abstract List<Entidade> findAll() throws Exception;

}
