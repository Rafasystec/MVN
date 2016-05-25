package br.com.systeconline.tables.basicos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import br.com.systeconline.core.enums.EnumTipoUser;

/**
 * 
 * @author Rafael Rocha
 * @since Gsind 1.0 beta dia 25/10/2013 as 21:12
 */
@NamedQueries(
		{
			@NamedQuery(name=Usuario.FIND_ALL		,query="FROM Usuario"),
			@NamedQuery(name=Usuario.FIND_BY_CODE	,query="FROM Usuario u WHERE u.codigo = :codigo"),
			@NamedQuery(name=Usuario.FIND_BY_LOGIN	,query="FROM Usuario u WHERE u.email = :email AND u.passWord = :senha"),
			@NamedQuery(name=Usuario.FIND_BY		,query="FROM Usuario u WHERE  u.nome LIKE :nome OR u.email LIKE :email "),
			@NamedQuery(name=Usuario.FIND_BY_EMAIL	,query="FROM Usuario u WHERE u.email = :email")
		}
)

@Entity
@Table(name="USUARIO")
public class Usuario extends Entidade{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8937600656781400155L;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(Usuario usuario) {
		super(usuario);
	}
	public static final String FIND_ALL 	= "Usuario.findAll";
	public static final String FIND_BY_CODE = "Usuario.findByCodigo";
	public static final String FIND_BY_LOGIN= "Usuario.findByLogin";
	public static final String FIND_BY		= "Usuario.findBy";
	public static final String FIND_BY_EMAIL= "Usuario.findByEmail";
	public static final String PARA_CODIGO 	= "codigo";
	public static final String PARA_USUARIO = "email";
	public static final String PARA_EMAIL	= "email";
	public static final String PARA_PWD 	= "senha";
	public static final String PARA_NOME 	= "nome";
	
	@Column(name="cod_permissoes",nullable=false)
	private long codPermissoes;
	@Column(name="email",nullable=false)
	private String email;
	@Column(name="senha",nullable=false)
	private String passWord;
	@Column
	private String nome;
	@Column(name="tipo_user")
	private EnumTipoUser tipoUser = EnumTipoUser.MASTER;
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="usuarios",fetch=FetchType.EAGER)
	private List<Empresa> empresas = new ArrayList<Empresa>();
	
	public long getCodPermissoes() {
		return codPermissoes;
	}
	public void setCodPermissoes(long codPermissoes) {
		this.codPermissoes = codPermissoes;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	public EnumTipoUser getTipoUser() {
		return tipoUser;
	}
	public void setTipoUser(EnumTipoUser tipoUser) {
		this.tipoUser = tipoUser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
