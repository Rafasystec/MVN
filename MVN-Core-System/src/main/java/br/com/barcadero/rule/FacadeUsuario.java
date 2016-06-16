package br.com.barcadero.rule;

import java.util.List;

import org.hibernate.Session;

import br.com.barcadero.core.enums.EnumTipoUser;
import br.com.barcadero.core.handles.HandleMD5;
import br.com.barcadero.dao.DaoUsuario;
import br.com.barcadero.tables.Entidade;
import br.com.barcadero.tables.Usuario;
import br.com.barcadero.tables.Usuarios;

public class FacadeUsuario extends RuleModelo{
	
	

	private DaoUsuario daoUsuario;	
	
	public FacadeUsuario(Session session) {
		super(session);
		daoUsuario = new DaoUsuario(session);
	}

	public Usuario login(String login, String pwd) throws Exception{
		try {
			if(login.isEmpty()){
				throw new Exception("O login do usuário é obrigatório");
			}else if(pwd.isEmpty()){
				throw new Exception("Não é permito senhas em branco");
			}
			pwd = criptSenha(pwd);
			return daoUsuario.login(login, pwd);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception(e.getMessage());
		}
	}
	
	public String update(Usuario usuario) throws Exception{
		return daoUsuario.update(usuario);
	}
	
	public String salvar(Usuario usuario) throws Exception{
		try {
			if(usuario == null){
				throw new Exception("Usuário com valor nulo.");
			}
			usuario.setPassWord(criptSenha(usuario.getPassWord()));
			return daoUsuario.insert(usuario);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Erro grave ao tentar incluir o usuario: " + e.getMessage());
		}
	}
	
	public List<Entidade> findAll() throws Exception{
		try {
			return daoUsuario.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception();
		}
	}
	
	private String criptSenha(String senha) {
		String pwdEncripted = "";
		pwdEncripted = HandleMD5.toMD5(senha);
		return pwdEncripted;
	}

	@Override
	public String insert(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuario.insert(entidade);
	}

	@Override
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuario.delete(codigo);
	}

	@Override
	public String update(Entidade entidade) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuario.update(entidade);
	}

	@Override
	public Entidade find(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuario.find(codigo);
	}
	
	public List<Usuario> find(String param) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuario.find(param);
	}

	/**
	 * Inseri o usuario de homologacao caso ele nao exista, caso exista ele usara o usuario de codigo 1
	 * @return
	 * @throws Exception
	 */
	public String inserirUsuarioHomo() throws Exception {
		System.out.println("Iniciando metodo para inserir Usuario de Homologacao.");
		Usuario usuario = (Usuario) daoUsuario.find(1L);
		if(usuario == null){
			usuario = new Usuario();
			usuario.setCodPermissoes(1);
			usuario.setEmail("master@barcadero.com.br");
			usuario.setNome("USER MASTER");
			usuario.setPassWord("123456");
			usuario.setTipoUser(EnumTipoUser.MASTER);
			return "Resposta criacao do usuario padrao >> :" + daoUsuario.insert(usuario);
		}else{
			return "Usuario padrao ja existe!";
		}
	}
	
	/**
	 * Consultar usuario por email.
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public Usuario findByEmail(String email) throws Exception {
		return daoUsuario.findByEmail(email);
	}
}
