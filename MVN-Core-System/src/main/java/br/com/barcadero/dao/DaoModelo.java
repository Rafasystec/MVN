package br.com.barcadero.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
//import org.springframework.transaction.annotation.Transactional;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Loja;

//@Transactional
public abstract class DaoModelo<T extends Entidade> implements DaoInterface<T> {
	private final String MSG_SUCESS_SAVE = "Registro salvo com sucesso!";
	private final String MSG_SUCESS_DEL  = "Registro excluido!";
	private final String MSG_SUCESS_UPD  = "Registro atualizado com sucesso!";
	private final String MSG_ERRO_SAVE	 = "Erro ao tentar salvar o registro.";
	private final String MSG_ERRO_DEL	 = "Erro ao tentar excluir o registro.";
	private final String MSG_NOT_FOUND	 = "Registro não encontrado.";
	public static String mesageInstanceSpring = "spring-framework instace class ";
	protected Empresa empresa;
	protected Loja loja;

	@PersistenceContext
	protected EntityManager manager;
	
	private Session	session;
	
	public DaoModelo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Construtor da DaoModelo
	 * @param empresa: empresa logada
	 * @param loja: loja logada
	 * @param session
	 */
	public DaoModelo(Empresa empresa, Loja loja, Session session) {
		// TODO Auto-generated constructor stub
		this.session 	= session;
		this.loja 		= loja;
		this.empresa 	= empresa;
	}
	
	public DaoModelo(Empresa empresa, Loja loja) {
		this.loja 		= loja;
		this.empresa 	= empresa;
	}
	
	
	
	@Deprecated
	public DaoModelo(Session session){
		//session = FacadeSessionFactory.getSession();
		this.session = session;
		loja 	= null;
		empresa	= null;
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
	
	@Override
	public T insert(T entidade) throws Exception {
		if(entidade != null){
			manager.persist(entidade);
		}
		return entidade;
	}
	

	
	public String delete(long codigo) throws Exception{
		try {
			if(codigo <= 0){
				throw new Exception("Codigo teve ter seu valor maior que 0 - Codigo recebido: " + codigo);
			}
			T entidade = this.find(codigo);
			if(entidade != null){
				manager.remove(entidade);
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
			manager.remove(entidade);
			return "Registro Deletado.";
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public T update(T entidade) throws Exception {
		return manager.merge(entidade);
	}
	
	public abstract T find(long codigo) throws Exception;

	public T find(long primaryKey, Class<T> entityClass) {
		return manager.find(entityClass, primaryKey);
	}
	public Empresa getEmpresa() {
		return empresa;
	}

	public Loja getLoja() {
		return loja;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

}
