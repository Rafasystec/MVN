package br.com.barcadero.web.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.barcadero.rule.RuleUsuario;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Usuario;
import br.com.barcadero.tables.UsuarioPermissoes;
import br.com.barcadero.web.functions.HandleMessage;

@ManagedBean
@ViewScoped
public class BeanUsuarios extends SuperBean<Usuario>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -849089551764159326L;
	private UsuarioPermissoes permissoes;
	private Usuario usuario;
	private Usuario selectedUsuario;
	private String senha;
	private String confimSenha;
	private List<Usuario> usuarios;
	@ManagedProperty(value="#{ruleUsuario}")
	private RuleUsuario ruleUsuario;
	
	@PostConstruct
	public void init() {
		novoUsuario();
		setUsuarios(consultarTodosDaEmpresa());
	}

	public List<Usuario> consultarTodosDaEmpresa() {
		try {
			return ruleUsuario.findByEmpresa(getEmpresaLogada());
		} catch (Exception e) {
			return new ArrayList<>();
		}
	}
	
	private void novoUsuario() {
		usuario	 	= new Usuario(getEmpresaLogada(),getUsuarioLogado());
		permissoes	= new UsuarioPermissoes(getUsuarioLogado());
		usuario.setPermissoes(permissoes);
		usuario.setEmpresas(getUsuarioLogado().getEmpresas());
		for (Empresa empresa : getUsuarioLogado().getEmpresas()) {
			empresa.setUsuarios(usuarios);
		}
	}
	
	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validar(Usuario entidade) throws Exception {
		if(usuario != null){
			if(usuario.getCodigo() == 0){
				if(!getSenha().equals(getConfimSenha())){
					HandleMessage.errorValidacao("A senha não confere com a confirmação.");
					return false;
				}
				if(getSenha().trim().isEmpty() || getConfimSenha().trim().isEmpty()){
					HandleMessage.errorValidacao("A senha não pode ficar em branco ao inserir um usuário, somente na atualização");
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public String salvar() throws Exception {
		if(validar(usuario)){
			if(usuario.getCodigo() == 0){
				usuario.setPassWord(getSenha());
			}
			ruleUsuario.insert(usuario);
			HandleMessage.info("Salvo com sucesso!");
		}
		return null;
	}

	@Override
	public String alterar() throws Exception {
		salvar();
		return null;
	}

	@Override
	public String deletar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String novo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public void selecionar(Usuario usuario) {
		setUsuario(usuario);
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public RuleUsuario getRuleUsuario() {
		return ruleUsuario;
	}

	public void setRuleUsuario(RuleUsuario ruleUsuario) {
		this.ruleUsuario = ruleUsuario;
	}

	public UsuarioPermissoes getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(UsuarioPermissoes permissoes) {
		this.permissoes = permissoes;
	}

	public String getConfimSenha() {
		return confimSenha;
	}

	public void setConfimSenha(String confimSenha) {
		this.confimSenha = confimSenha;
	}

	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}

	public void setSelectedUsuario(Usuario selectedUsuario) {
		this.selectedUsuario = selectedUsuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
