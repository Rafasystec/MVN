package br.com.barcadero.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barcadero.commons.util.HandleMD5;
import br.com.barcadero.core.enums.EnumTipoUser;
import br.com.barcadero.dao.DaoUsuario;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Loja;
import br.com.barcadero.tables.Usuario;
@Service
public class RuleUsuario extends RuleModelo<Usuario>{
	
	

	@Autowired
	private DaoUsuario daoUsuario;	

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
	
	public List<Usuario> findAll() throws Exception{
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
	public String delete(long codigo) throws Exception {
		// TODO Auto-generated method stub
		return daoUsuario.delete(codigo);
	}

	@Override
	public Usuario find(long codigo) throws Exception {
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

	@Override
	public List<Usuario> findByEmpresa(Empresa empresa) throws Exception {
		return daoUsuario.findByEmpresa(empresa);
	}

	@Override
	public List<Usuario> findByEmpresaELoja(Empresa empresa, Loja loja) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario insert(Usuario usuario) throws Exception {
		if(usuario.getCodigo() > 0){
			return daoUsuario.update(usuario);
		}else{
			usuario.setPassWord(criptSenha(usuario.getPassWord()));
			return daoUsuario.insert(usuario);
		}
	}

	@Override
	public Usuario update(Usuario usuario) throws Exception {
		return daoUsuario.update(usuario);
	}
}
