package br.com.barcadero.dao;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Usuario;

/**
 * 
 * @author Rafael Rocha
 * @since Gsind 1.0 Beta dia 25/10/2013 as 11:05
 */
@Repository
public class DaoUsuario extends DaoModelo<Usuario> {
	
	public DaoUsuario() {
		System.out.println("Auto-generated constructor stub DaoUsuario");
	}
	
	@Override
	public Usuario find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		Query qry = null;
		try {
			qry = manager.createNamedQuery(Usuario.FIND_BY_CODE).setParameter(Usuario.PARA_CODIGO, codigo);
			return (Usuario)qry.getSingleResult();
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
		qry 	  = manager.createNamedQuery(Usuario.FIND_BY);
		qry.setParameter(Usuario.PARA_NOME, param+"%");
		qry.setParameter(Usuario.PARA_EMAIL, param+"%");
		return (List<Usuario>)qry.getResultList();
	}
	/**
	 * Procurar usuario por email
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public Usuario findByEmail(String email) throws Exception {
		Query qry = null;
		qry 	  = manager.createNamedQuery(Usuario.FIND_BY_EMAIL);
		qry.setParameter(Usuario.PARA_EMAIL, email);
		return (Usuario) qry.getSingleResult();
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
			qry = manager.createNamedQuery(Usuario.FIND_BY_LOGIN);
			qry.setParameter(Usuario.PARA_USUARIO, login);
			qry.setParameter(Usuario.PARA_PWD, pwd);
			return (Usuario)qry.getSingleResult();
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
		qry = manager.createNamedQuery(Usuario.FIND_ALL);
		return qry.getResultList();
	}

	@Override
	public List<Usuario> findByEmpresa(Empresa empresa) throws Exception {
		TypedQuery<Usuario> qry = manager.createNamedQuery(Usuario.FIND_ALL, Usuario.class)
				.setParameter("empresa", empresa);
		return qry.getResultList();
	}

	@Override
	public List<Usuario> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
