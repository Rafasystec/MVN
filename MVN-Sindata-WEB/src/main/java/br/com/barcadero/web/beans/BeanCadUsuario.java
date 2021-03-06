package br.com.barcadero.web.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import br.com.barcadero.rule.RuleEmpresa;
import br.com.barcadero.rule.RuleUsuario;
import br.com.barcadero.tables.Empresa;
import br.com.barcadero.tables.Usuario;
import br.com.barcadero.tables.UsuarioPermissoes;


@ManagedBean(name="cadUsuario")
public class BeanCadUsuario extends SuperBean<Usuario> {

	private static final long serialVersionUID = 746108176250467310L;
	private Usuario usuario 					= null;
	private UsuarioPermissoes usuarioPermissoes = null;
	private String confirm  		= "";
	public UsuarioPermissoes getUsuarioPermissoes() {
		return usuarioPermissoes;
	}
	public void setUsuarioPermissoes(UsuarioPermissoes usuarioPermissoes) {
		this.usuarioPermissoes = usuarioPermissoes;
	}
	@ManagedProperty("#{ruleUsuario}")
	private RuleUsuario fcdUser;
	@ManagedProperty("#{ruleEmpresa}")
	private RuleEmpresa ruleEmpresa;
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
	@PostConstruct
	private void init() {
		usuario 	= new Usuario(null,null);
		permissoesUsuarioFull();
		usuario.setPermissoes(usuarioPermissoes);
	}
	
	private void permissoesUsuarioFull() {
		usuarioPermissoes = new UsuarioPermissoes(usuario);
		usuarioPermissoes.setPodeAcessarCadastros(true);
		usuarioPermissoes.setPodeAcessarColaboradores(true);
		usuarioPermissoes.setPodeAcessarConfiguracoes(true);
		usuarioPermissoes.setPodeAcessarCRM(true);
		usuarioPermissoes.setPodeAcessarFinanceiro(true);
		usuarioPermissoes.setPodeAcessarOperacional(true);
		usuarioPermissoes.setPodeAcessarPagamentos(true);
		usuarioPermissoes.setPodeAcessarRecebimento(true);
		usuarioPermissoes.setPodeAcessarRelatorio(true);
	}
	
	@Override
	public String salvar() throws Exception {
		usuario = fcdUser.insert(usuario);
		Empresa empresa = ruleEmpresa.inserirEmpresaPadrao(usuario);
		
		getSession().setLojaLogada(empresa.getLojas().get(0));
		getSession().setEmpresa(empresa);
		autorizarLogin(usuario,"");
		return "sucesso";
	}

	@Override
	public String alterar() throws Exception {
		// TODO Auto-generated method stub
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
	@Override
	public String imprimir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public RuleUsuario getFcdUser() {
		return fcdUser;
	}
	public void setFcdUser(RuleUsuario fcdUser) {
		this.fcdUser = fcdUser;
	}
	public RuleEmpresa getRuleEmpresa() {
		return ruleEmpresa;
	}
	public void setRuleEmpresa(RuleEmpresa ruleEmpresa) {
		this.ruleEmpresa = ruleEmpresa;
	}
	@Override
	public boolean validar(Usuario entidade) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	

}
