package br.com.barcadero.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.barcadero.tables.Usuario;

/**
 * 
 * @author Rafael Rocha
 * @since Gsind 1.0 Beta dia 25/10/2013 as 11:05
 */
public class DaoUsuario extends DaoModelo<Usuario> {
	
	private Session	session = null;
	
	public DaoUsuario(Session session) {
		super(session);
		this.session = session;
	}
	
//	@Override
//	public String insert(Entidade entidade) throws Exception {
//		
//		try{
//			if(entidade != null){
//				session.save(entidade);
//				return getMSG_SUCESS_SAVE();
//			}else{
//				return getMSG_ERRO_SAVE();
//			}
//		}catch(Exception e){
//			return getMSG_ERRO_SAVE() + e.getMessage();
//		}
//	}
//
//	@Override
//	public String delete(long codigo) throws Exception {
//		// TODO Auto-generated method stub
//		Usuario usuario = null;
//		try {
//			usuario	= (Usuario)find(codigo);
//			if(usuario != null){
//				session.delete(usuario);
//			}else{
//				return getMSG_NOT_FOUND();
//			}
//			return getMSG_SUCESS_SAVE();
//		}catch (Exception e) {
//			throw new Exception(e.getMessage());
//		}
//	}
//
//	@Override
//	public String update(Entidade entidade) throws Exception {
//		Usuario usuario = null;
//		try {
//			if(entidade != null){
//				usuario = (Usuario)entidade;
//				this.session.update(usuario);
//			}else{
//				return getMSG_NOT_FOUND();
//			}
//			return getMSG_SUCESS_SAVE();
//		} catch (Exception e) {
//			// TODO: handle exception
//			return "Erro ao atualizar:" + e.getMessage();
//		}
//	}

	@Override
	public Usuario find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		Query qry = null;
		try {
			qry = session.getNamedQuery(Usuario.FIND_BY_CODE).setParameter(Usuario.PARA_CODIGO, codigo);
			return (Usuario)qry.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	/**
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<Usuario> find(String param) throws Exception {
		Query qry = null;
		qry 	  = this.session.getNamedQuery(Usuario.FIND_BY);
		qry.setParameter(Usuario.PARA_NOME, param+"%");
		qry.setParameter(Usuario.PARA_EMAIL, param+"%");
		return (List<Usuario>)qry.list();
	}
	/**
	 * Procurar usuario por email
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public Usuario findByEmail(String email) throws Exception {
		Query qry = null;
		qry 	  = this.session.getNamedQuery(Usuario.FIND_BY_EMAIL);
		qry.setParameter(Usuario.PARA_EMAIL, email);
		return (Usuario) qry.uniqueResult();
	}
	
	/**
	 * Metodo criado para verificar se o usuario possui permissao para acessar o sistema
	 * @param login : login do usuario
	 * @param pwd : senha do usuario
	 * @return true caso o usuario tenha sido validado e false caso contrario.
	 * @throws Exception
	 */
	public Usuario login(String login, String pwd) throws Exception{
		Query qry = null;
		try {
			qry = this.session.getNamedQuery(Usuario.FIND_BY_LOGIN);
			qry.setParameter(Usuario.PARA_USUARIO, login);
			qry.setParameter(Usuario.PARA_PWD, pwd);
			return (Usuario)qry.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Erro ao tentar verificar o usuario: " + e.getMessage());
		}
	}
	/**
	 * Consultar todos os usuarios
	 */
	public List<Usuario> findAll() throws Exception {
		Query qry = null;
		qry = this.session.getNamedQuery(Usuario.FIND_ALL);
		return qry.list();
	}

}
