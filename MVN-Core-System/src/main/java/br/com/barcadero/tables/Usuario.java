package br.com.barcadero.tables;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import br.com.barcadero.core.enums.EnumTipoUser;

/**
 * 
 * @author Rafael Rocha
 * @since Gsind 1.0 beta dia 25/10/2013 as 21:12
 */
@NamedQueries(
		{
			@NamedQuery(name=Usuario.FIND_ALL		,query="FROM Usuario WHERE empresa = :empresa"),
			@NamedQuery(name=Usuario.FIND_BY_CODE	,query="FROM Usuario u WHERE u.codigo = :codigo"),
			@NamedQuery(name=Usuario.FIND_BY_LOGIN	,query="FROM Usuario u WHERE u.email = :email AND u.passWord = :senha"),
			@NamedQuery(name=Usuario.FIND_BY		,query="FROM Usuario u WHERE  u.nome LIKE :nome OR u.email LIKE :email "),
			@NamedQuery(name=Usuario.FIND_BY_EMAIL	,query="FROM Usuario u WHERE u.email = :email")
		}
)
@Audited(targetAuditMode=RelationTargetAuditMode.NOT_AUDITED)
@Entity
@Table(name="USUARIO")
public class Usuario extends EntidadeEmpresa{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8937600656781400155L;

	public Usuario() {
	}
	
	public Usuario(Empresa empresa,Usuario usuario) {
		super(empresa, usuario);
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
	private long codPermissoes = 0;
	@Column(name="email",nullable=false)
	private String email = "";
	@Column(name="senha",nullable=false)
	private String passWord = "";
	@Column
	private String nome = "";
	@Column(name="tipo_user")
	private EnumTipoUser tipoUser = EnumTipoUser.MASTER;
	
	@ManyToMany(mappedBy="usuarios",fetch=FetchType.EAGER)
	private List<Empresa> empresas = new ArrayList<Empresa>();
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=UsuarioPermissoes.class)
	@JoinColumn(name="permissoes",referencedColumnName="CODIGO")
	private UsuarioPermissoes permissoes;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (codPermissoes ^ (codPermissoes >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((empresas == null) ? 0 : empresas.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + ((tipoUser == null) ? 0 : tipoUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codPermissoes != other.codPermissoes)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (empresas == null) {
			if (other.empresas != null)
				return false;
		} else if (!empresas.equals(other.empresas))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (tipoUser != other.tipoUser)
			return false;
		return true;
	}

	public UsuarioPermissoes getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(UsuarioPermissoes permissoes) {
		this.permissoes = permissoes;
	}
	
	
}
